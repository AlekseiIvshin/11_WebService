
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
    private List<webservice.elements.CarElement> _return;

    /**
     * 
     * @return
     *     returns List<CarElement>
     */
    public List<webservice.elements.CarElement> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<webservice.elements.CarElement> _return) {
        this._return = _return;
    }

}
