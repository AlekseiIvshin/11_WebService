package service.customer;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.customer.CustomerDomainImpl;

public class CustomerServiceImplTest {

	@Test
	public void testFindByPassportStringString() {
		CustomerServiceImpl serviceImpl = new CustomerServiceImpl();
		CustomerDomainImpl customer = serviceImpl.findByPassport("9100", "100100");
		assertNotNull(customer);
	}

}
