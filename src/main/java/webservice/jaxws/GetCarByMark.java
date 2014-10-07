
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCarByMark", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCarByMark", namespace = "http://webservice/")
public class GetCarByMark {

    @XmlElement(name = "markName", namespace = "")
    private String markName;

    /**
     * 
     * @return
     *     returns String
     */
    public String getMarkName() {
        return this.markName;
    }

    /**
     * 
     * @param markName
     *     the value for the markName property
     */
    public void setMarkName(String markName) {
        this.markName = markName;
    }

}
