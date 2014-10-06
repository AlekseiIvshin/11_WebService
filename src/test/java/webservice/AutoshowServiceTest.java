package webservice;

import static org.junit.Assert.*;

import java.util.Random;

import javax.persistence.NoResultException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import domain.CarDomain;
import domain.CustomerDomain;

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
	public void testAddCar() {
		Random rnd = new Random();
		String carMark = "Mark " + (rnd.nextInt(100) + 20);
		String carModel = "Model " + (rnd.nextInt(100) + 20);
		String carModification = "Modif " + (rnd.nextInt(100) + 20);
		CarDomain newCar = null;
		try {
			newCar = service.addCar(carMark, carModel, carModification);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertNotNull(newCar);
		assertEquals(newCar.getMark(), carMark);
		assertEquals(newCar.getModel(), carModel);
		assertEquals(newCar.getModification(), carModification);

		assertNotNull(service.findOneCar(carMark, carModel, carModification));

	}

	@Test
	public void testRemoveCar() {
		Random rnd = new Random();
		String carMark = "Mark " + (rnd.nextInt(100) + 20);
		String carModel = "Model " + (rnd.nextInt(100) + 20);
		String carModification = "Modif " + (rnd.nextInt(100) + 20);
		CarDomain newCar = null;
		try {
			newCar = service.addCar(carMark, carModel, carModification);
		} catch (Exception e) {
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
		} catch (NoResultException e) {
		}
	}

	@Test
	public void testFindOneCar() {
		CarDomain car = service.findOneCar("Audi", "R8", "6.2 MT (442 hs)");
		assertNotNull(car);
		assertEquals(car.getMark(), "Audi");
		assertEquals(car.getModel(), "R8");
		assertEquals(car.getModification(), "6.2 MT (442 hs)");

	}

	@Ignore
	@Test
	public void testNewSaleAndUpdateStore() {

	}

	@Ignore
	@Test
	public void testGetStore() {
	}

	@Ignore
	@Test
	public void testGetMerchantById() {
		fail("Not yet implemented");
	}

}
