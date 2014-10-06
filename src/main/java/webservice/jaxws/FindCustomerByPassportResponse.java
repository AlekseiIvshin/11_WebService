
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findCustomerByPassportResponse", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findCustomerByPassportResponse", namespace = "http://webservice/")
public class FindCustomerByPassportResponse {

    @XmlElement(name = "return", namespace = "")
    private domain.customer.CustomerDomain _return;

    /**
     * 
     * @return
     *     returns CustomerDomain
     */
    public domain.customer.CustomerDomain getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(domain.customer.CustomerDomain _return) {
        this._return = _return;
    }

}
