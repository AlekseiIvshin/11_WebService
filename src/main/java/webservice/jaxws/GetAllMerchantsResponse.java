
package webservice.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAllMerchantsResponse", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllMerchantsResponse", namespace = "http://webservice/")
public class GetAllMerchantsResponse {

    @XmlElement(name = "return", namespace = "")
    private List<webservice.elements.MerchantElement> _return;

    /**
     * 
     * @return
     *     returns List<MerchantElement>
     */
    public List<webservice.elements.MerchantElement> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<webservice.elements.MerchantElement> _return) {
        this._return = _return;
    }

}
