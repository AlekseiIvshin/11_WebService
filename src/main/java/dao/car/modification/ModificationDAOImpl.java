package dao.car.modification;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import dao.GenericDAOImpl;
import dao.car.model.CarModel;

/**
 * Modification DAO implementation.
 * 
 * @author Aleksei_Ivshin
 *
 */
public class ModificationDAOImpl extends GenericDAOImpl<Modification, Long>
		implements ModificationDAO {

	/**
	 * Constructor.
	 * 
	 * @param entityManager
	 *            entity manager
	 */
	public ModificationDAOImpl(final EntityManager entityManager) {
		super(entityManager);
	}

	/**
	 * Find modification with name like parameter.
	 * 
	 * @param model
	 *            model of modification
	 * @param name
	 *            part or full car modification name
	 * @return founded modifications
	 */
	public final List<Modification> findAny(final CarModel model,
			final String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Modification> query = builder
				.createQuery(Modification.class);
		Root<Modification> root = query.from(Modification.class);
		query.where(builder.like(root.get(Modification_.name), name))
				.where(builder.equal(root.get(Modification_.model), model))
				.select(root);
		TypedQuery<Modification> ctq = entityManager.createQuery(query);
		return ctq.getResultList();
	}

	/**
	 * Find modification with name equal parameter.
	 * 
	 * @param model
	 *            model of modification
	 * @param name
	 *            full modification name
	 * @return founded modification or null (if not found)
	 */
	public final Modification findOne(final CarModel model, final String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Modification> query = builder
				.createQuery(Modification.class);
		Root<Modification> root = query.from(Modification.class);
		query.where(
				builder.and(
						builder.equal(root.get(Modification_.model), model),
						builder.equal(root.get(Modification_.name), name)))
				.select(root);
		TypedQuery<Modification> ctq = entityManager.createQuery(query);
		try {
			return ctq.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Modification> findByMark(String markName) {
		return entityManager
				.createQuery(
						"SELECT modif FROM Modification modif, CarModel model, Mark mark "
								+ "WHERE mark.name=:markName AND model.mark=mark AND modif.model=model")
				.setParameter("markName", markName).getResultList();
	}

	public List<Modification> findByMarkAndModel(String markName,
			String modelName) {
		return entityManager
				.createQuery(
						"SELECT modif FROM Modification modif, CarModel model, Mark mark "
								+ "WHERE mark.name=:markName AND model.mark=mark AND model.name=:modelName AND modif.model=model")
				.setParameter("markName", markName)
				.setParameter("modelName", modelName).getResultList();
	}
}
