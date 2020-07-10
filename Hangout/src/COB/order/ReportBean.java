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
public class ReportBean {
    private String catID;
    private String packID;
    private String cus_Name;
    private String ev_date;
    private String pay_date;
    private String total;

    public ReportBean(String catID, String packID, String cus_Name, String ev_date, String pay_date, String total) {
        this.catID = catID;
        this.packID = packID;
        this.cus_Name = cus_Name;
        this.ev_date = ev_date;
        this.pay_date = pay_date;
        this.total = total;
    }

    public String getCatID() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }

    public String getPackID() {
        return packID;
    }

    public void setPackID(String packID) {
        this.packID = packID;
    }

    public String getCus_Name() {
        return cus_Name;
    }

    public void setCus_Name(String cus_Name) {
        this.cus_Name = cus_Name;
    }

    public String getEv_date() {
        return ev_date;
    }

    public void setEv_date(String ev_date) {
        this.ev_date = ev_date;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    
}
