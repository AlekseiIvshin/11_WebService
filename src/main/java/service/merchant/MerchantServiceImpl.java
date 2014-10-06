package service.merchant;

import service.DomainServiceImpl;
import dao.merchant.Merchant;
import dao.merchant.MerchantDAOImpl;
import domain.merchant.MerchantDomain;

/**
 * Merchant service implementation.
 * 
 * @author Aleksei_Ivshin
 *
 */
public class MerchantServiceImpl
		extends
		DomainServiceImpl
				<MerchantDomain, Integer, Merchant, Integer, MerchantDAOImpl>
		implements MerchantService {

	/**
	 * Default constructor.
	 */
	public MerchantServiceImpl() {
		super();
		dao = new MerchantDAOImpl(entityManager);
	}

}
