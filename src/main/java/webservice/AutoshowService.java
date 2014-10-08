package webservice;

import java.util.List;

import javax.jws.WebService;

import domain.CarDomain;
import domain.CustomerDomain;
import domain.MerchantDomain;
import mapper.MainMapper;
import mapper.Mapper;
import service.car.CarServiceImpl;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import service.merchant.MerchantServiceImpl;
import service.sales.SalesServiceImpl;
import service.store.StoreServiceImpl;
import webservice.elements.CarElement;
import webservice.elements.CustomerElement;
import webservice.elements.MerchantElement;
import webservice.elements.SalesElement;
import webservice.elements.StoreElement;

@WebService(endpointInterface = "webservice.ShowService")
public class AutoshowService implements ShowService {
	Mapper mapper = new MainMapper();

	private CustomerService customerService = new CustomerServiceImpl();
	private CarServiceImpl carService = new CarServiceImpl();
	private MerchantServiceImpl merchantService = new MerchantServiceImpl();
	private SalesServiceImpl salesService = new SalesServiceImpl();
	private StoreServiceImpl storeService = new StoreServiceImpl();

	@Override
	public CustomerElement findCustomerByPassport(String series, String number) {
		return mapper.map(customerService.findByPassport(series, number),
				CustomerElement.class);
	}

	@Override
	public CarElement getCarById(long carId) {
		return mapper.map(carService.get(carId), CarElement.class);
	}

	@Override
	public CarElement addCar(String mark, String model, String modification)
			throws Exception {
		return mapper.map(carService.addCar(mark, model, modification),
				CarElement.class);
	}

	@Override
	public void removeCar(String mark, String model, String modification)
			throws Exception {
		carService.removeCar(mark, model, modification);
	}

	@Override
	public CarElement findOneCar(String mark, String model, String modification)
			throws Exception {
		return mapper.map(carService.findOne(mark, model, modification),
				CarElement.class);
	}

	@Override
	public SalesElement newSaleAndUpdateStore(CustomerElement customer,
			MerchantElement merchant, CarElement car) throws Exception {
		CarDomain carDom = mapper.map(car, CarDomain.class);
		CustomerDomain customerDom = mapper.map(customer, CustomerDomain.class);
		MerchantDomain merchantDom = mapper.map(merchant, MerchantDomain.class);
		return mapper.map(salesService.newSaleAndUpdateStore(customerDom,
				merchantDom, carDom), SalesElement.class);
	}

	@Override
	public StoreElement getStore(CarElement car) {
		return mapper.map(storeService.get(mapper.map(car, CarDomain.class)),
				StoreElement.class);
	}

	@Override
	public MerchantElement getMerchantById(int merchantId) {
		return mapper.map(merchantService.get(merchantId),
				MerchantElement.class);
	}

	@Override
	public List<CarElement> getCarByMark(String markName) {
		return mapper.mapAsList(carService.findByMarkName(markName),
				CarElement.class);
	}

	@Override
	public List<CarElement> getCarByMarkAndModel(String markName,
			String modelName) {
		return mapper.mapAsList(
				carService.findByMarkAndModel(markName, modelName),
				CarElement.class);
	}

	@Override
	public List<MerchantElement> getAllMerchants() {
		return mapper
				.mapAsList(merchantService.getAll(), MerchantElement.class);
	}

	@Override
	public List<String> getCarMarkList() {
		return carService.getMarks();
	}

	@Override
	public List<SalesElement> getAllSales() {
		return mapper.mapAsList(salesService.getAll(), SalesElement.class);
	}

	@Override
	public List<StoreElement> getAllStores() {
		return mapper.mapAsList(storeService.getAll(), StoreElement.class);
	}
}
