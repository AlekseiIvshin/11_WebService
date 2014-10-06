package dao.merchant;

import javax.persistence.EntityManager;

import dao.GenericDAOImpl;

/**
 * Merchant DAO implementation.
 * @author Aleksei_Ivshin
 *
 */
public class MerchantDAOImpl 
		extends GenericDAOImpl<Merchant, Integer>
		implements MerchantDAO {

	/**
	 * Constructor.
	 * @param entityManager entiry manager
	 */
	public MerchantDAOImpl(final EntityManager entityManager) {
		super(entityManager);
	}

}
