
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "newSaleAndUpdateStore", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "newSaleAndUpdateStore", namespace = "http://webservice/", propOrder = {
    "customer",
    "merchant",
    "car"
})
public class NewSaleAndUpdateStore {

    @XmlElement(name = "customer", namespace = "")
    private webservice.elements.CustomerElement customer;
    @XmlElement(name = "merchant", namespace = "")
    private webservice.elements.MerchantElement merchant;
    @XmlElement(name = "car", namespace = "")
    private webservice.elements.CarElement car;

    /**
     * 
     * @return
     *     returns CustomerElement
     */
    public webservice.elements.CustomerElement getCustomer() {
        return this.customer;
    }

    /**
     * 
     * @param customer
     *     the value for the customer property
     */
    public void setCustomer(webservice.elements.CustomerElement customer) {
        this.customer = customer;
    }

    /**
     * 
     * @return
     *     returns MerchantElement
     */
    public webservice.elements.MerchantElement getMerchant() {
        return this.merchant;
    }

    /**
     * 
     * @param merchant
     *     the value for the merchant property
     */
    public void setMerchant(webservice.elements.MerchantElement merchant) {
        this.merchant = merchant;
    }

    /**
     * 
     * @return
     *     returns CarElement
     */
    public webservice.elements.CarElement getCar() {
        return this.car;
    }

    /**
     * 
     * @param car
     *     the value for the car property
     */
    public void setCar(webservice.elements.CarElement car) {
        this.car = car;
    }

}
