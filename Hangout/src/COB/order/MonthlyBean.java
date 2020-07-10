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
public class MonthlyBean {
    private String Year;
    private String Month;
    private String Total;

    public MonthlyBean(String Year, String Month, String Total) {
        this.Year = Year;
        this.Month = Month;
        this.Total = Total;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String Month) {
        this.Month = Month;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }
    
}
