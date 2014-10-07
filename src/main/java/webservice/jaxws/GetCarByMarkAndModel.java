
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCarByMarkAndModel", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCarByMarkAndModel", namespace = "http://webservice/", propOrder = {
    "markName",
    "modelName"
})
public class GetCarByMarkAndModel {

    @XmlElement(name = "markName", namespace = "")
    private String markName;
    @XmlElement(name = "modelName", namespace = "")
    private String modelName;

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

    /**
     * 
     * @return
     *     returns String
     */
    public String getModelName() {
        return this.modelName;
    }

    /**
     * 
     * @param modelName
     *     the value for the modelName property
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

}
