package service.car;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class CarServiceImplTest {

	@Test
	public void testAddCar() {
		CarServiceImpl carservice  = new CarServiceImpl();
		try {
			carservice.addCar("Mersedes", "Benz", "620 ls");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testFindOne() {
		CarServiceImpl carservice  = new CarServiceImpl();
		assertNotNull(carservice.findOne("Audi", "R8", "6.2 MT (442 hs)"));
	}

}
