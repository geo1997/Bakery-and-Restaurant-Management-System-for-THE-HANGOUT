/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COB.order;

/**
 *
 * @author Priyan
 */
public class OrderBean {
    private String cateringID;
    private String phone;
    private String customerID;
    private String packageID;
    private String plates;
    private String orderdate;
    private String status;

    public OrderBean(String cateringID, String phone, String customerID, String packageID,String plates, String orderdate, String status) {
        this.cateringID = cateringID;
        this.phone = phone;
        this.packageID = packageID;
        this.customerID = customerID;
        this.plates = plates;
        this.orderdate = orderdate;
        this.status = status;
    }

    public String getCateringID() {
        return cateringID;
    }

    public void setCateringID(String cateringID) {
        this.cateringID = cateringID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
        
    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }
    
    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
