package dao.car.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.GenericDAOImpl;
import dao.car.mark.Mark;

/**
 * Model DAO implementation.
 * 
 * @author Aleksei_Ivshin
 *
 */
public class ModelDAOImpl extends GenericDAOImpl<CarModel, Integer> implements
		ModelDAO {

	/**
	 * Logger.
	 */
	static final Logger LOG = LoggerFactory.getLogger(ModelDAOImpl.class);

	/**
	 * Constructor.
	 * 
	 * @param entityManager
	 *            entity manager
	 */
	public ModelDAOImpl(final EntityManager entityManager) {
		super(entityManager);
	}

	/**
	 * Find models with name like parameter.
	 * 
	 * @param mark
	 *            mark of model
	 * @param name
	 *            part or full car model name
	 * @return founded models
	 */
	public final List<CarModel> findAny(final Mark mark, final String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CarModel> query = builder.createQuery(CarModel.class);
		Root<CarModel> root = query.from(CarModel.class);
		query.where(builder.like(root.get(Model_.name), name))
				.where(builder.equal(root.get(Model_.mark), mark)).select(root);
		TypedQuery<CarModel> ctq = entityManager.createQuery(query);
		return ctq.getResultList();
	}

	/**
	 * Find model with name equal parameter.
	 * 
	 * @param mark
	 *            mark of model
	 * @param name
	 *            full model name
	 * @return founded model or null (if not found)
	 */
	public final CarModel findOne(final Mark mark, final String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CarModel> query = builder.createQuery(CarModel.class);
		Root<CarModel> root = query.from(CarModel.class);
		query.where(
				builder.and(builder.equal(root.get(Model_.mark), mark),
						builder.equal(root.get(Model_.name), name))).select(
				root);
		TypedQuery<CarModel> ctq = entityManager.createQuery(query);
		try {
			return ctq.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 * Find car model. If not founded create this model
	 * 
	 * @param mark
	 *            car mark
	 * @param name
	 *            model name
	 * @return founded or created model
	 */
	public final CarModel findOrCreate(final Mark mark, final String name) {
		CarModel modelData = findOne(mark, name);
		if (modelData == null) {
			modelData = new CarModel();
			modelData.setMark(mark);
			modelData.setName(name);
			modelData = create(modelData);
		}
		return modelData;
	}
}
