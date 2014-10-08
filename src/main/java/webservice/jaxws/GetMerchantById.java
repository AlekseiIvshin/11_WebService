
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getMerchantById", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMerchantById", namespace = "http://webservice/")
public class GetMerchantById {

    @XmlElement(name = "merchantId", namespace = "")
    private int merchantId;

    /**
     * 
     * @return
     *     returns int
     */
    public int getMerchantId() {
        return this.merchantId;
    }

    /**
     * 
     * @param merchantId
     *     the value for the merchantId property
     */
    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

}
