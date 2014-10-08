
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
    private webservice.elements.CarElement car;

    /**
     * 
     * @return
     *     returns CarElement
     */
    public webservice.elements.CarElement getCar() {
        return this.car;
    }

    /**
     * 
     * @param car
     *     the value for the car property
     */
    public void setCar(webservice.elements.CarElement car) {
        this.car = car;
    }

}
