
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "removeCar", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "removeCar", namespace = "http://webservice/", propOrder = {
    "markName",
    "modelName",
    "modificationName"
})
public class RemoveCar {

    @XmlElement(name = "markName", namespace = "")
    private String markName;
    @XmlElement(name = "modelName", namespace = "")
    private String modelName;
    @XmlElement(name = "modificationName", namespace = "")
    private String modificationName;

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

    /**
     * 
     * @return
     *     returns String
     */
    public String getModificationName() {
        return this.modificationName;
    }

    /**
     * 
     * @param modificationName
     *     the value for the modificationName property
     */
    public void setModificationName(String modificationName) {
        this.modificationName = modificationName;
    }

}
