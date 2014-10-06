package endpoint;

import javax.xml.ws.Endpoint;

import service.customer.CustomerServiceImpl;

public class Publisher {

	public static void main(String[] args){
		Endpoint.publish("http://localhost:8888/ws/customer", new CustomerServiceImpl());
	}
}
