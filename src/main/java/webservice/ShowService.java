package webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import domain.CarDomain;
import domain.CustomerDomain;
import domain.MerchantDomain;
import domain.SalesDomain;
import domain.StoreDomain;

@WebService
public interface ShowService {
	/**
	 * Get customer by passport.
	 * 
	 * @param series
	 *            passport series
	 * @param number
	 *            passport number
	 * @return found customer
	 */
	@WebMethod
	public CustomerDomain findCustomerByPassport(
			@WebParam(name = "series") String series,
			@WebParam(name = "number") String number);

	/**
	 * Get list of cars marks.
	 * 
	 * @return marks
	 */
	@WebMethod
	public List<String> getCarMarkList();

	/**
	 * Get cars by mark name.
	 * 
	 * @param markName
	 *            mark name
	 * @return
	 */
	@WebMethod
	public List<CarDomain> getCarByMark(
			@WebParam(name = "markName") String markName);

	/**
	 * Get cars by mark and model names.
	 * 
	 * @param markName
	 *            mark name
	 * @param modelName
	 *            model name
	 * @return
	 */
	@WebMethod
	public List<CarDomain> getCarByMarkAndModel(
			@WebParam(name = "markName") String markName,
			@WebParam(name = "modelName") String modelName);

	/**
	 * Find car by name
	 * 
	 * @param mark
	 *            mark name
	 * @param model
	 *            model name
	 * @param modification
	 *            modification
	 * @return first result of found cars
	 * @throws Exception 
	 */
	@WebMethod
	public CarDomain findOneCar(@WebParam(name = "markName") String mark,
			@WebParam(name = "modelName") String model,
			@WebParam(name = "modificationName") String modification) throws Exception;

	/**
	 * Cat car by id
	 * 
	 * @param carId
	 *            car id.
	 * @return found car
	 */
	@WebMethod
	public CarDomain getCarById(@WebParam(name = "carId") long carId);

	/**
	 * Add new car to data storage.
	 * 
	 * @param mark
	 *            new or exist mark name
	 * @param model
	 *            new or exist model name
	 * @param modification
	 *            new modification
	 * @return created car
	 * @throws Exception
	 *             throw if modification already exist
	 */
	@WebMethod
	public CarDomain addCar(@WebParam(name = "markName") String mark,
			@WebParam(name = "modelName") String model,
			@WebParam(name = "modificationName") String modification)
			throws Exception;

	/**
	 * Remove car from data storage.
	 * 
	 * @param mark
	 *            mark name
	 * @param model
	 *            model name
	 * @param modification
	 *            modification
	 * @throws Exception
	 *             some exception
	 */
	@WebMethod
	public void removeCar(@WebParam(name = "markName") String mark,
			@WebParam(name = "modelName") String model,
			@WebParam(name = "modificationName") String modification)
			throws Exception;

	/**
	 * Create new sales and update storage (decrement car count)
	 * 
	 * @param customer
	 *            buy car
	 * @param merchant
	 *            sell car
	 * @param car
	 *            car
	 * @return new sale object
	 * @throws Exception
	 */
	@WebMethod
	public SalesDomain newSaleAndUpdateStore(
			@WebParam(name = "customer") CustomerDomain customer,
			@WebParam(name = "merchant") MerchantDomain merchant,
			@WebParam(name = "car") CarDomain car) throws Exception;

	/**
	 * Get store by car.
	 * 
	 * @param car
	 *            car
	 * @return found store item
	 */
	@WebMethod
	public StoreDomain getStore(@WebParam(name = "car") CarDomain car);

	
	/**
	 * Get merchant by id.
	 * 
	 * @param merchantId
	 *            merchant id
	 * @return found merchant
	 */
	@WebMethod
	public MerchantDomain getMerchantById(
			@WebParam(name = "merchantId") int merchantId);

	/**
	 * Get all merchants.
	 * 
	 * @return all merchants.
	 */
	@WebMethod
	public List<MerchantDomain> getAllMerchants();
	
	@WebMethod
	public List<SalesDomain> getAllSales();
	
	@WebMethod
	public List<StoreDomain> getAllStores();

}
