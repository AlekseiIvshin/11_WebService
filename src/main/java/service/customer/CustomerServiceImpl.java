package service.customer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import mapper.MainMapper;
import mapper.Mapper;
import service.DomainServiceImpl;
import dao.customer.Customer;
import dao.customer.CustomerDAOImpl;
import domain.CustomerDomain;

/**
 * Customer service implementation.
 * 
 * @author Aleksei_Ivshin
 *
 */
@WebService
public class CustomerServiceImpl
		extends
		DomainServiceImpl<CustomerDomain, Integer, Customer, Integer, CustomerDAOImpl>
		implements CustomerService {

	/**
	 * Default constructor.
	 */
	public CustomerServiceImpl() {
		super();
		dao = new CustomerDAOImpl(entityManagerFactory);
	}

	/**
	 * Find customer by passport.
	 * 
	 * @param customer
	 *            some customer data
	 * @return founded customer
	 */
	public final CustomerDomain findByPassport(final CustomerDomain customer) {
		Mapper mapper = new MainMapper();
		Customer customerDao = mapper.map(customer, Customer.class);
		return mapper
				.map(dao.findByPassport(customerDao), CustomerDomain.class);
	}

	@WebMethod
	public CustomerDomain findByPassport(
			@WebParam(name = "series") String series,
			@WebParam(name = "number") String number) {
		return (CustomerDomain) mapper.map(
				dao.findByPassport(series, number), CustomerDomain.class);
	}

}
