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
public class ReportBean {
    private String cusID;
    private String cusName;
    private String points;

    public ReportBean(String cusID, String cusName, String points) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.points = points;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
    
    
}
