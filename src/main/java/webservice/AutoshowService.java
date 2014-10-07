package webservice;

import java.util.List;

import javax.jws.WebService;

import service.car.CarServiceImpl;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import service.merchant.MerchantServiceImpl;
import service.sales.SalesServiceImpl;
import service.store.StoreServiceImpl;
import domain.CarDomain;
import domain.CustomerDomain;
import domain.MerchantDomain;
import domain.SalesDomain;
import domain.StoreDomain;

@WebService(endpointInterface = "webservice.ShowService")
public class AutoshowService implements ShowService {

	private CustomerService customerService = new CustomerServiceImpl();
	private CarServiceImpl carService = new CarServiceImpl();
	private MerchantServiceImpl merchantService = new MerchantServiceImpl();
	private SalesServiceImpl salesService = new SalesServiceImpl();
	private StoreServiceImpl storeService = new StoreServiceImpl();

	@Override
	public CustomerDomain findCustomerByPassport(String series, String number) {
		return customerService.findByPassport(series, number);
	}

	@Override
	public CarDomain getCarById(long carId) {
		return carService.get(carId);
	}

	@Override
	public CarDomain addCar(String mark, String model, String modification)
			throws Exception {
		return carService.addCar(mark, model, modification);
	}

	@Override
	public void removeCar(String mark, String model, String modification)
			throws Exception {
		carService.removeCar(mark, model, modification);
	}

	@Override
	public CarDomain findOneCar(String mark, String model, String modification) throws Exception {
		return carService.findOne(mark, model, modification);
	}

	@Override
	public SalesDomain newSaleAndUpdateStore(CustomerDomain customer,
			MerchantDomain merchant, CarDomain car) throws Exception {
		return salesService.newSaleAndUpdateStore(customer, merchant, car);
	}

	@Override
	public StoreDomain getStore(CarDomain car) {
		return storeService.get(car);
	}

	@Override
	public MerchantDomain getMerchantById(int merchantId) {
		return merchantService.get(merchantId);
	}

	@Override
	public List<CarDomain> getCarByMark(String markName) {
		return carService.findByMarkName(markName);
	}

	@Override
	public List<CarDomain> getCarByMarkAndModel(String markName, String modelName) {
		return carService.findByMarkAndModel(markName, modelName);
	}

	@Override
	public List<MerchantDomain> getAllMerchants() {
		return merchantService.getAll();
	}

	@Override
	public List<String> getCarMarkList() {
		return carService.getMarks();
	}
}
