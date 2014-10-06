
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

    @XmlElement(name = "arg0", namespace = "")
    private domain.car.CarDomain arg0;

    /**
     * 
     * @return
     *     returns CarDomain
     */
    public domain.car.CarDomain getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(domain.car.CarDomain arg0) {
        this.arg0 = arg0;
    }

}
