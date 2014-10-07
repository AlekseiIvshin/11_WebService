
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findOneCarResponse", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findOneCarResponse", namespace = "http://webservice/")
public class FindOneCarResponse {

    @XmlElement(name = "return", namespace = "")
    private domain.CarDomain _return;

    /**
     * 
     * @return
     *     returns CarDomain
     */
    public domain.CarDomain getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(domain.CarDomain _return) {
        this._return = _return;
    }

}
