
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findCustomerByPassport", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findCustomerByPassport", namespace = "http://webservice/", propOrder = {
    "series",
    "number"
})
public class FindCustomerByPassport {

    @XmlElement(name = "series", namespace = "")
    private String series;
    @XmlElement(name = "number", namespace = "")
    private String number;

    /**
     * 
     * @return
     *     returns String
     */
    public String getSeries() {
        return this.series;
    }

    /**
     * 
     * @param series
     *     the value for the series property
     */
    public void setSeries(String series) {
        this.series = series;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * 
     * @param number
     *     the value for the number property
     */
    public void setNumber(String number) {
        this.number = number;
    }

}
