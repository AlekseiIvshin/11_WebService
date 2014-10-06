
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "newSaleAndUpdateStore", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "newSaleAndUpdateStore", namespace = "http://webservice/", propOrder = {
    "arg0",
    "arg1",
    "arg2"
})
public class NewSaleAndUpdateStore {

    @XmlElement(name = "arg0", namespace = "")
    private domain.customer.CustomerDomain arg0;
    @XmlElement(name = "arg1", namespace = "")
    private domain.merchant.MerchantDomain arg1;
    @XmlElement(name = "arg2", namespace = "")
    private domain.car.CarDomain arg2;

    /**
     * 
     * @return
     *     returns CustomerDomain
     */
    public domain.customer.CustomerDomain getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(domain.customer.CustomerDomain arg0) {
        this.arg0 = arg0;
    }

    /**
     * 
     * @return
     *     returns MerchantDomain
     */
    public domain.merchant.MerchantDomain getArg1() {
        return this.arg1;
    }

    /**
     * 
     * @param arg1
     *     the value for the arg1 property
     */
    public void setArg1(domain.merchant.MerchantDomain arg1) {
        this.arg1 = arg1;
    }

    /**
     * 
     * @return
     *     returns CarDomain
     */
    public domain.car.CarDomain getArg2() {
        return this.arg2;
    }

    /**
     * 
     * @param arg2
     *     the value for the arg2 property
     */
    public void setArg2(domain.car.CarDomain arg2) {
        this.arg2 = arg2;
    }

}
