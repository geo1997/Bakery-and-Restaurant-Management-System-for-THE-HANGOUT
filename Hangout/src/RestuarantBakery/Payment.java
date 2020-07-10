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
public class Payment {
    private String month;
    private int year;
    private float tot;
    private float fulTot;

    public Payment(String month, int year, float tot) {
        this.month = month;
        this.year = year;
        this.tot = tot;
    }

    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public float getTot() {
        return tot;
    }

    public void setTot(float tot) {
        this.tot = tot;
    }
    
    
}
