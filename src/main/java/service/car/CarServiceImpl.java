package service.car;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.DomainServiceImpl;
import mapper.MainMapper;
import mapper.Mapper;
import dao.car.mark.Mark;
import dao.car.mark.MarkDAO;
import dao.car.mark.MarkDAOImpl;
import dao.car.model.Model;
import dao.car.model.ModelDAO;
import dao.car.model.ModelDAOImpl;
import dao.car.modification.Modification;
import dao.car.modification.ModificationDAO;
import dao.car.modification.ModificationDAOImpl;
import domain.CarDomain;

/**
 * Car service implementation.
 * 
 * @author Aleksei_Ivshin
 *
 */
public class CarServiceImpl
		extends
		DomainServiceImpl<CarDomain, Long, Modification, Long, ModificationDAOImpl>
		implements CarService {

	/**
	 * Logger.
	 */
	static final Logger LOG = LoggerFactory.getLogger(CarServiceImpl.class);

	/**
	 * Default constructor.
	 */
	public CarServiceImpl() {
		super();
		dao = new ModificationDAOImpl(entityManager);
	}

	/**
	 * Add new car. Create mark and model if required.
	 * 
	 * @param mark
	 *            mark name
	 * @param model
	 *            model name
	 * @param modification
	 *            car modification
	 * @return created car
	 * @throws SQLException some exception
	 */
	public final CarDomain addCar(final String mark, final String model,
			final String modification) throws SQLException {
		MarkDAO markDAO = new MarkDAOImpl(entityManager);
		ModelDAO modelDAO = new ModelDAOImpl(entityManager);
		ModificationDAO modifDAO = new ModificationDAOImpl(entityManager);
		entityManager.getTransaction().begin();
		// find or create mark
		
		System.err.println(mark+" "+model+" "+modification);
		Mark markData = markDAO.findOrCreate(mark);
		Model modelData = modelDAO.findOrCreate(markData, model);
		Modification modif = modifDAO.findOne(modelData, modification);
		if (modif != null) {
			entityManager.getTransaction().rollback();
			throw new SQLException("This car (" + mark + " " + model + " "
					+ modification + ") is exist!");
		}
		modif = new Modification();
		modif.setModel(modelData);
		modif.setName(modification);

		modif = modifDAO.create(modif);

		entityManager.getTransaction().commit();
		Mapper mapper = new MainMapper();
		return mapper.map(modif, CarDomain.class);
	}

	/**
	 * Remove car.
	 * 
	 * @param mark
	 *            mark name
	 * @param model
	 *            model name
	 * @param modification
	 *            car modification
	 */
	public final void removeCar(final String mark, final String model,
			final String modification) {
		// search mark by name
		MarkDAO markDAO = new MarkDAOImpl(entityManager);
		Mark markEntity = markDAO.findOne(mark);
		if (markEntity == null) {
			throw new NoResultException("No found mark with name " + mark);
		}

		ModelDAO modelDAO = new ModelDAOImpl(entityManager);
		Model modelEntity = modelDAO.findOne(markEntity, model);
		if (modelEntity == null) {
			throw new NoResultException("No found mark with name " + mark
					+ " and model name " + model);
		}

		ModificationDAO modificationDAO = new ModificationDAOImpl(entityManager);
		Modification modifEntity = modificationDAO.findOne(modelEntity,
				modification);

		if (modifEntity == null) {
			throw new NoResultException("No found mark with name " + mark
					+ ", model name " + model + " and modification "
					+ modification);
		}

		modificationDAO.deleteById(modifEntity.getId());
	}

	/**
	 * Find car by name.
	 * 
	 * @param mark
	 *            mark name
	 * @param model
	 *            model name
	 * @param modification
	 *            modification
	 * @return founded car
	 */
	public final CarDomain findOne(final String mark, final String model,
			final String modification) {
		MarkDAO markDAO = new MarkDAOImpl(entityManager);
		Mark markEntity = markDAO.findOne(mark);
		if (markEntity == null) {
			throw new NoResultException("Mark with name " + mark
					+ " not founded");
		}

		ModelDAO modelDAO = new ModelDAOImpl(entityManager);
		Model modelEntity = modelDAO.findOne(markEntity, model);
		if (modelEntity == null) {
			throw new NoResultException("Model with name " + model
					+ " and mark " + mark + " not founded");
		}

		ModificationDAO modificationDAO = new ModificationDAOImpl(entityManager);
		Modification modifEntity = modificationDAO.findOne(modelEntity,
				modification);

		if (modifEntity == null) {
			throw new NoResultException("Modification " + modification
					+ " for " + mark + " " + model + " not founded");
		}

		Mapper mapper = new MainMapper();
		return mapper.map(modifEntity, CarDomain.class);
	}

}
