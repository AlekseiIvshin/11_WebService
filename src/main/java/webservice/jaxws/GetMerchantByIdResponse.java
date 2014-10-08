
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getMerchantByIdResponse", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMerchantByIdResponse", namespace = "http://webservice/")
public class GetMerchantByIdResponse {

    @XmlElement(name = "return", namespace = "")
    private webservice.elements.MerchantElement _return;

    /**
     * 
     * @return
     *     returns MerchantElement
     */
    public webservice.elements.MerchantElement getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(webservice.elements.MerchantElement _return) {
        this._return = _return;
    }

}
