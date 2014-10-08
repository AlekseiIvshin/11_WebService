
package webservice.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAllStoresResponse", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllStoresResponse", namespace = "http://webservice/")
public class GetAllStoresResponse {

    @XmlElement(name = "return", namespace = "")
    private List<webservice.elements.StoreElement> _return;

    /**
     * 
     * @return
     *     returns List<StoreElement>
     */
    public List<webservice.elements.StoreElement> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<webservice.elements.StoreElement> _return) {
        this._return = _return;
    }

}
