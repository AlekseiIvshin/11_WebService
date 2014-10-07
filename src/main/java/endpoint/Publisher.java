package endpoint;

import javax.xml.ws.Endpoint;

import org.apache.cxf.frontend.ServerFactoryBean;

import com.sun.media.sound.SF2GlobalRegion;

import webservice.AutoshowService;
import webservice.ShowService;

public class Publisher {

	public static void main(String[] args){
		//Endpoint.publish("http://localhost:8896/ws/autoshow", new AutoshowService());
		AutoshowService service = new AutoshowService();
		
		ServerFactoryBean factory = new ServerFactoryBean();
		factory.setServiceClass(ShowService.class);
		factory.setAddress("http://localhost:8888/ws/autoshow");
		factory.setServiceBean(service);
		factory.create();
	}
}
