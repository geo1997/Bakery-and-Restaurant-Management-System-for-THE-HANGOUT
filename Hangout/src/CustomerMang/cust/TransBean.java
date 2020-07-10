/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerMang.cust;

/**
 *
 * @author Isuru
 */
public class TransBean {
    private String cusID;
    private String tot;
    private String discount;
    private String points;

    public TransBean(String cusID, String tot, String discount, String points) {
        this.cusID = cusID;
        this.tot = tot;
        this.discount = discount;
        this.points = points;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getTot() {
        return tot;
    }

    public void setTot(String tot) {
        this.tot = tot;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
    
    
}
