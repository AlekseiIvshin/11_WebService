
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
    private domain.MerchantDomain _return;

    /**
     * 
     * @return
     *     returns MerchantDomain
     */
    public domain.MerchantDomain getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(domain.MerchantDomain _return) {
        this._return = _return;
    }

}
