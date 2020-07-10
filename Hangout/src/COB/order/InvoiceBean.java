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
public class InvoiceBean {
    private String paymentID;
    private String cateringID;
    private String customerID;
    private String date;
    private String total;

    public InvoiceBean(String paymentID, String cateringID,String customerID, String date, String total) {
        this.paymentID = paymentID;
        this.cateringID = cateringID;
        this.customerID = customerID;
        this.date = date;
        this.total = total;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getCateringID() {
        return cateringID;
    }

    public void setCateringID(String cateringID) {
        this.cateringID = cateringID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    
}
