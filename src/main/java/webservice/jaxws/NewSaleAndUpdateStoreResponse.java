
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "newSaleAndUpdateStoreResponse", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "newSaleAndUpdateStoreResponse", namespace = "http://webservice/")
public class NewSaleAndUpdateStoreResponse {

    @XmlElement(name = "return", namespace = "")
    private domain.SalesDomain _return;

    /**
     * 
     * @return
     *     returns SalesDomain
     */
    public domain.SalesDomain getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(domain.SalesDomain _return) {
        this._return = _return;
    }

}
