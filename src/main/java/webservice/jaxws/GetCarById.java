
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCarById", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCarById", namespace = "http://webservice/")
public class GetCarById {

    @XmlElement(name = "carId", namespace = "")
    private long carId;

    /**
     * 
     * @return
     *     returns long
     */
    public long getCarId() {
        return this.carId;
    }

    /**
     * 
     * @param carId
     *     the value for the carId property
     */
    public void setCarId(long carId) {
        this.carId = carId;
    }

}
