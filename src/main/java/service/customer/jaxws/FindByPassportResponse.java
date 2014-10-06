
package service.customer.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findByPassportResponse", namespace = "http://customer.service/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findByPassportResponse", namespace = "http://customer.service/")
public class FindByPassportResponse {

    @XmlElement(name = "return", namespace = "")
    private domain.customer.CustomerDomainImpl _return;

    /**
     * 
     * @return
     *     returns CustomerDomainImpl
     */
    public domain.customer.CustomerDomainImpl getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(domain.customer.CustomerDomainImpl _return) {
        this._return = _return;
    }

}
