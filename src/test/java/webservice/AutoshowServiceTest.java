package webservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.NoResultException;

import org.junit.Before;
import org.junit.Test;

import domain.CarDomain;
import domain.CustomerDomain;
import domain.MerchantDomain;
import domain.SalesDomain;
import domain.StoreDomain;

public class AutoshowServiceTest {

	AutoshowService service;

	@Before
	public void setUp() {
		service = new AutoshowService();
	}

	@Test
	public void testFindCustomerByPassport() {
		CustomerDomain customer = service.findCustomerByPassport("9100",
				"100100");
		assertNotNull(customer);
		assertEquals(customer.getPassportNumber(), "100100");
		assertEquals(customer.getPassportSeries(), "9100");
	}

	@Test
	public void testGetCarById() {
		CarDomain car = service.getCarById(1);
		assertNotNull(car);
		assertEquals(car.getId(), 1);
	}

	@Test
	public void testAddAndRemoveCar() {
		Random rnd = new Random();
		String carMark = "Mark " + (rnd.nextInt(100) + 20);
		String carModel = "Model " + (rnd.nextInt(100) + 20);
		String carModification = "Modif " + (rnd.nextInt(100) + 20);
		CarDomain newCar = null;
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
		CarDomain car;
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
		List<CarDomain> cars = service.getCarByMarkAndModel("Audi", "R8");
		assertNotNull(cars);
		assertFalse(cars.isEmpty());
	}

	@Test
	public void getAllMerchants() {
		List<MerchantDomain> merchants = service.getAllMerchants();
		assertNotNull(merchants);
		assertFalse(merchants.isEmpty());
	}

	@Test
	public void getMerchantById() {
		assertNotNull(service.getMerchantById(1));
	}

	@Test
	public void testSaleCar() {
		CustomerDomain customer = new CustomerDomain();
		customer.setName("Ivan");
		customer.setSurname("Ivanov");
		customer.setPassportNumber("Ivanovich");
		customer.setPassportNumber("100101");
		customer.setPassportSeries("9100");
		customer.setBirthDate(new Date());
		MerchantDomain merchant = service.getMerchantById(1);
		CarDomain car = service.getCarById(2);
		StoreDomain storeBefore = service.getStore(car);
		assertNotNull(storeBefore);
		SalesDomain sale;
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
		StoreDomain storeAfter = service.getStore(car);
		assertNotNull(storeAfter);
		// assertEquals(storeBefore.getQuantity()-1, storeAfter.getQuantity());
	}

	@Test
	public void testGetCarByMark() {
		List<CarDomain> cars = service.getCarByMark("Audi");
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
