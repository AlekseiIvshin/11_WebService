
package webservice.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCarByMarkResponse", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCarByMarkResponse", namespace = "http://webservice/")
public class GetCarByMarkResponse {

    @XmlElement(name = "return", namespace = "")
    private List<domain.CarDomain> _return;

    /**
     * 
     * @return
     *     returns List<CarDomain>
     */
    public List<domain.CarDomain> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<domain.CarDomain> _return) {
        this._return = _return;
    }

}
