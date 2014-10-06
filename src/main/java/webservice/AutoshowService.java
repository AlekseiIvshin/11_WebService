package webservice;

import java.sql.SQLException;

import service.car.CarServiceImpl;
import service.customer.CustomerServiceImpl;
import service.merchant.MerchantServiceImpl;
import service.sales.SalesServiceImpl;
import service.store.StoreServiceImpl;
import domain.car.CarDomain;
import domain.customer.CustomerDomain;
import domain.customer.CustomerDomainImpl;
import domain.merchant.MerchantDomain;
import domain.sales.SalesDomain;
import domain.store.StoreDomain;

public class AutoshowService {
	
	private CustomerServiceImpl customerService = new CustomerServiceImpl();
	private CarServiceImpl carService = new CarServiceImpl();
	private MerchantServiceImpl merchantService = new MerchantServiceImpl();
	private SalesServiceImpl salesService = new SalesServiceImpl();
	private StoreServiceImpl storeService = new StoreServiceImpl();

	public CustomerDomainImpl findCustomerByPassport(String series, String number){
		return customerService.findByPassport(series, number);
	}
	
	public CarDomain getCarById(long carId){
		return carService.get(carId);
	}
	
	public CarDomain addCar(String mark, String model, String modification) throws SQLException{
		return carService.addCar(mark, model, modification);
	}

	
	public void removeCar(String mark, String model, String modification){
		carService.removeCar(mark, model, modification);;
	}
	
	public CarDomain findOneCar(String mark, String model, String modification){
		return carService.findOne(mark, model, modification);
	}
	
	public SalesDomain newSaleAndUpdateStore(CustomerDomain customer,
			MerchantDomain merchant, CarDomain car) throws Exception{
		return salesService.newSaleAndUpdateStore(customer, merchant, car);
	}
	
	public StoreDomain getStore(CarDomain car){
		return storeService.get(car);
	}
	
	public MerchantDomain getMerchantById(int merchantId){
		return merchantService.get(merchantId);
	}
}
