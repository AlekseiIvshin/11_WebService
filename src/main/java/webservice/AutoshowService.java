package webservice;

import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import service.car.CarServiceImpl;
import service.customer.CustomerServiceImpl;
import service.merchant.MerchantServiceImpl;
import service.sales.SalesServiceImpl;
import service.store.StoreServiceImpl;
import domain.car.CarDomain;
import domain.customer.CustomerDomain;
import domain.merchant.MerchantDomain;
import domain.sales.SalesDomain;
import domain.store.StoreDomain;

@WebService
public class AutoshowService {

	private CustomerServiceImpl customerService = new CustomerServiceImpl();
	private CarServiceImpl carService = new CarServiceImpl();
	private MerchantServiceImpl merchantService = new MerchantServiceImpl();
	private SalesServiceImpl salesService = new SalesServiceImpl();
	private StoreServiceImpl storeService = new StoreServiceImpl();

	@WebMethod
	public CustomerDomain findCustomerByPassport(String series,
			String number) {
		return customerService.findByPassport(series, number);
	}

	@WebMethod
	public CarDomain getCarById(long carId) {
		return carService.get(carId);
	}

	@WebMethod
	public CarDomain addCar(String mark, String model, String modification)
			throws SQLException {
		return carService.addCar(mark, model, modification);
	}

	@WebMethod
	public void removeCar(String mark, String model, String modification) {
		carService.removeCar(mark, model, modification);
		;
	}

	@WebMethod
	public CarDomain findOneCar(String mark, String model, String modification) {
		return carService.findOne(mark, model, modification);
	}

	@WebMethod
	public SalesDomain newSaleAndUpdateStore(CustomerDomain customer,
			MerchantDomain merchant, CarDomain car) throws Exception {
		return salesService.newSaleAndUpdateStore(customer, merchant, car);
	}

	@WebMethod
	public StoreDomain getStore(CarDomain car) {
		return storeService.get(car);
	}

	@WebMethod
	public MerchantDomain getMerchantById(int merchantId) {
		return merchantService.get(merchantId);
	}
}
