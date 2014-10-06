package service.sales;

import mapper.MainMapper;
import mapper.Mapper;
import service.DomainServiceImpl;
import dao.car.modification.Modification;
import dao.customer.Customer;
import dao.merchant.Merchant;
import dao.sales.Sales;
import dao.sales.SalesDAOImpl;
import domain.car.CarDomain;
import domain.customer.CustomerDomain;
import domain.merchant.MerchantDomain;
import domain.sales.SalesDomain;

/**
 * Sales service implementation.
 * 
 * @author Aleksei_Ivshin
 *
 */
public class SalesServiceImpl extends
		DomainServiceImpl<SalesDomain, Integer, Sales, Integer, SalesDAOImpl>
		implements SalesService {

	/**
	 * Default constructor.
	 */
	public SalesServiceImpl() {
		super();
		dao = new SalesDAOImpl(entityManager);
	}

	/**
	 * Create new sale and update store (decrement car count).
	 * 
	 * @param newSales
	 *            new sale data
	 * @return sale data
	 * @throws Exception
	 *             some error
	 */
	public final SalesDomain newSaleAndUpdateStore(final SalesDomain newSales)
			throws Exception {
		return newSaleAndUpdateStore(newSales.getCustomer(),
				newSales.getMerchant(), newSales.getCar());
	}

	/**
	 * Create new sale and update store (decrement car count).
	 * 
	 * @param customer
	 *            who buy car
	 * @param merchant
	 *            who sale car
	 * @param car
	 *            car
	 * @return sale date
	 * @throws Exception
	 *             some error
	 */
	public final SalesDomain newSaleAndUpdateStore(
			final CustomerDomain customer, final MerchantDomain merchant,
			final CarDomain car) throws Exception {
		Mapper mapper = new MainMapper();
		Customer cust = mapper.map(customer, Customer.class);
		Merchant merch = mapper.map(merchant, Merchant.class);
		Modification modif = mapper.map(car, Modification.class);

		Sales changedSales = dao.newSaleAndUpdateStore(cust, merch, modif);
		return mapper.map(changedSales, SalesDomain.class);
	}

}
