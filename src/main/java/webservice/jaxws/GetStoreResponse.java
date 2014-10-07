
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
    private domain.StoreDomain _return;

    /**
     * 
     * @return
     *     returns StoreDomain
     */
    public domain.StoreDomain getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(domain.StoreDomain _return) {
        this._return = _return;
    }

}
