package webservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import webservice.elements.CarElement;
import webservice.elements.CustomerElement;
import webservice.elements.MerchantElement;
import webservice.elements.SalesElement;
import webservice.elements.StoreElement;

public class AutoshowServiceTest {

	AutoshowService service;

	@Before
	public void setUp() {
		service = new AutoshowService();
	}

	@Test
	public void testFindCustomerByPassport() {
		CustomerElement customer = service.findCustomerByPassport("9100",
				"100100");
		assertNotNull(customer);
		assertEquals(customer.getPassportNumber(), "100100");
		assertEquals(customer.getPassportSeries(), "9100");
	}

	@Test
	public void testGetCarById() {
		CarElement car = service.getCarById(1);
		assertNotNull(car);
		assertEquals(car.getId(), 1);
	}

	@Test
	public void testAddAndRemoveCar() {
		Random rnd = new Random();
		String carMark = "Mark " + (rnd.nextInt(100) + 20);
		String carModel = "Model " + (rnd.nextInt(100) + 20);
		String carModification = "Modif " + (rnd.nextInt(100) + 20);
		CarElement newCar = null;
		try {
			newCar = service.addCar(carMark, carModel, carModification);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		assertNotNull(newCar);
		assertEquals(newCar.getMark(), carMark);
		assertEquals(newCar.getModel(), carModel);
		assertEquals(newCar.getModification(), carModification);
		try {
			service.removeCar(carMark, carModel, carModification);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {
			assertNull(service.findOneCar(carMark, carModel, carModification));
			fail("Car is found!!!");
		} catch (Exception e) {
		}
	}

	@Test
	public void testFindOneCar() {
		CarElement car;
		try {
			car = service.findOneCar("Audi", "R8", "6.2 MT (442 hs)");
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}
		assertNotNull(car);
		assertEquals(car.getMark(), "Audi");
		assertEquals(car.getModel(), "R8");
		assertEquals(car.getModification(), "6.2 MT (442 hs)");

	}

	@Test
	public void getCarByMarkAndModel() {
		List<CarElement> cars = service.getCarByMarkAndModel("Audi", "R8");
		assertNotNull(cars);
		assertFalse(cars.isEmpty());
	}

	@Test
	public void getAllMerchants() {
		List<MerchantElement> merchants = service.getAllMerchants();
		assertNotNull(merchants);
		assertFalse(merchants.isEmpty());
	}

	@Test
	public void getMerchantById() {
		assertNotNull(service.getMerchantById(1));
	}

	@Test
	public void testSaleCar() {
		CustomerElement customer = new CustomerElement();
		customer.setName("Ivan");
		customer.setSurname("Ivanov");
		customer.setPassportNumber("Ivanovich");
		customer.setPassportNumber("100101");
		customer.setPassportSeries("9100");
		customer.setBirthDate(new Date());
		MerchantElement merchant = service.getMerchantById(1);
		CarElement car = service.getCarById(2);
		StoreElement storeBefore = service.getStore(car);
		assertNotNull(storeBefore);
		SalesElement sale;
		try {
			sale = service.newSaleAndUpdateStore(customer, merchant, car);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
			return;
		}
		assertNotNull(sale);
		assertEquals(sale.getMerchant().getId(), merchant.getId());
		assertEquals(sale.getCar().getId(), car.getId());
		assertEquals(sale.getCustomer().getPassportSeries(),
				customer.getPassportSeries());
		assertEquals(sale.getCustomer().getPassportNumber(),
				customer.getPassportNumber());
		StoreElement storeAfter = service.getStore(car);
		assertNotNull(storeAfter);
		// assertEquals(storeBefore.getQuantity()-1, storeAfter.getQuantity());
	}

	@Test
	public void testGetCarByMark() {
		List<CarElement> cars = service.getCarByMark("Audi");
		assertNotNull(cars);
		assertFalse(cars.isEmpty());
	}

	@Test
	public void testGetAllMarks() {
		List<String> marks = service.getCarMarkList();
		assertNotNull(marks);
		assertFalse(marks.isEmpty());
	}

}
