package endpoint;

import javax.xml.ws.Endpoint;

import webservice.AutoshowService;

public class Publisher {

	public static void main(String[] args){
		Endpoint.publish("http://localhost:8897/ws/autoshow", new AutoshowService());
	}
}
