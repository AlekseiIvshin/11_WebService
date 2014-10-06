package webservice;

import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.NoResultException;

import service.car.CarServiceImpl;
import service.customer.CustomerServiceImpl;
import service.merchant.MerchantServiceImpl;
import service.sales.SalesServiceImpl;
import service.store.StoreServiceImpl;
import domain.CarDomain;
import domain.CustomerDomain;
import domain.MerchantDomain;
import domain.SalesDomain;
import domain.StoreDomain;

@WebService
public class AutoshowService {

	private CustomerServiceImpl customerService = new CustomerServiceImpl();
	private CarServiceImpl carService = new CarServiceImpl();
	private MerchantServiceImpl merchantService = new MerchantServiceImpl();
	private SalesServiceImpl salesService = new SalesServiceImpl();
	private StoreServiceImpl storeService = new StoreServiceImpl();

	@WebMethod
	public CustomerDomain findCustomerByPassport(
			@WebParam(name = "series") String series,
			@WebParam(name = "number") String number) {
		return customerService.findByPassport(series, number);
	}

	@WebMethod
	public CarDomain getCarById(@WebParam(name = "carId") long carId) {
		return carService.get(carId);
	}

	@WebMethod
	public CarDomain addCar(@WebParam(name = "markName") String mark,
			@WebParam(name = "modelName") String model,
			@WebParam(name = "modificationName") String modification)
			throws SQLException {
		System.err.println(mark + " " + model + " " + modification);
		return carService.addCar(mark, model, modification);
	}

	@WebMethod
	public void removeCar(@WebParam(name = "markName") String mark,
			@WebParam(name = "modelName") String model,
			@WebParam(name = "modificationName") String modification) throws NoResultException {
		carService.removeCar(mark, model, modification);
	}

	@WebMethod
	public CarDomain findOneCar(@WebParam(name = "markName") String mark,
			@WebParam(name = "modelName") String model,
			@WebParam(name = "modificationName") String modification) {
		return carService.findOne(mark, model, modification);
	}

	@WebMethod
	public SalesDomain newSaleAndUpdateStore(
			@WebParam(name = "customer") CustomerDomain customer,
			@WebParam(name = "merchant") MerchantDomain merchant,
			@WebParam(name = "car") CarDomain car) throws Exception {
		return salesService.newSaleAndUpdateStore(customer, merchant, car);
	}

	@WebMethod
	public StoreDomain getStore(@WebParam(name = "car") CarDomain car) {
		return storeService.get(car);
	}

	@WebMethod
	public MerchantDomain getMerchantById(
			@WebParam(name = "merchantId") int merchantId) {
		return merchantService.get(merchantId);
	}
}
