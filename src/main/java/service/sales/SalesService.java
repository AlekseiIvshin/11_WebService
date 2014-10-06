package service.sales;

import service.DomainService;
import domain.car.CarDomain;
import domain.customer.CustomerDomain;
import domain.merchant.MerchantDomain;
import domain.sales.SalesDomain;

/**
 * Sales service interface.
 * 
 * @author Aleksei_Ivshin
 *
 */
public interface SalesService extends DomainService<SalesDomain, Integer> {

	/**
	 * Create new sale and update store (decrement car count).
	 * 
	 * @param newSales
	 *            new sale data
	 * @return sale data
	 * @throws Exception
	 *             some error
	 */
	SalesDomain newSaleAndUpdateStore(SalesDomain newSales) throws Exception;

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
	SalesDomain newSaleAndUpdateStore(CustomerDomain customer,
			MerchantDomain merchant, CarDomain car) throws Exception;
}
