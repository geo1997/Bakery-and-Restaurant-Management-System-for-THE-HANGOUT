/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestuarantBakery;

/**
 *
 * @author BEYOND
 */
public class BakeryOrders {
    
    private int orderId;
    private String product;
    private int qty;
    private String currentDate;
    private String dueDate;
    private String status;

    public BakeryOrders(int orderId, String product, int qty, String currentDate, String dueDate, String status) {
        this.orderId = orderId;
        this.product = product;
        this.qty = qty;
        this.currentDate = currentDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
    
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
