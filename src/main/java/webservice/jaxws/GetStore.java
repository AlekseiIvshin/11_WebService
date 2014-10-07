
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getStore", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStore", namespace = "http://webservice/")
public class GetStore {

    @XmlElement(name = "car", namespace = "")
    private domain.CarDomain car;

    /**
     * 
     * @return
     *     returns CarDomain
     */
    public domain.CarDomain getCar() {
        return this.car;
    }

    /**
     * 
     * @param car
     *     the value for the car property
     */
    public void setCar(domain.CarDomain car) {
        this.car = car;
    }

}
