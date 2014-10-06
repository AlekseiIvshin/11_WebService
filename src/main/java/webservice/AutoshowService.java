package webservice;

import service.car.CarServiceImpl;
import service.customer.CustomerServiceImpl;
import service.customer.CustomerServiceImplTest;
import service.merchant.MerchantServiceImpl;
import service.sales.SalesServiceImpl;
import service.store.StoreServiceImpl;
import domain.customer.CustomerDomainImpl;

public class AutoshowService {
	
	private CustomerServiceImpl customerService = new CustomerServiceImpl();
	private CarServiceImpl carService = new CarServiceImpl();
	private MerchantServiceImpl merchantService = new MerchantServiceImpl();
	private SalesServiceImpl salesService = new SalesServiceImpl();
	private StoreServiceImpl storeService = new StoreServiceImpl();

	public CustomerDomainImpl findCustomerByPassport(String series, String number){
		return customerService.findByPassport(series, number);
	}
	
	
}
