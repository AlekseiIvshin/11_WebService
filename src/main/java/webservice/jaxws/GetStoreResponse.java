
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getStoreResponse", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStoreResponse", namespace = "http://webservice/")
public class GetStoreResponse {

    @XmlElement(name = "return", namespace = "")
    private webservice.elements.StoreElement _return;

    /**
     * 
     * @return
     *     returns StoreElement
     */
    public webservice.elements.StoreElement getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(webservice.elements.StoreElement _return) {
        this._return = _return;
    }

}
