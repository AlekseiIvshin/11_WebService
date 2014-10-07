
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
    private domain.CustomerDomain customer;
    @XmlElement(name = "merchant", namespace = "")
    private domain.MerchantDomain merchant;
    @XmlElement(name = "car", namespace = "")
    private domain.CarDomain car;

    /**
     * 
     * @return
     *     returns CustomerDomain
     */
    public domain.CustomerDomain getCustomer() {
        return this.customer;
    }

    /**
     * 
     * @param customer
     *     the value for the customer property
     */
    public void setCustomer(domain.CustomerDomain customer) {
        this.customer = customer;
    }

    /**
     * 
     * @return
     *     returns MerchantDomain
     */
    public domain.MerchantDomain getMerchant() {
        return this.merchant;
    }

    /**
     * 
     * @param merchant
     *     the value for the merchant property
     */
    public void setMerchant(domain.MerchantDomain merchant) {
        this.merchant = merchant;
    }

    /**
     * 
     * @return
     *     returns CarDomain
     */
    public domain.CarDomain getCar() {
        return this.car;
    }

    /**
     * 
     * @param car
     *     the value for the car property
     */
    public void setCar(domain.CarDomain car) {
        this.car = car;
    }

}
