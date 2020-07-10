/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee.Dashboard;

/**
 *
 * @author ASUS
 */
public class TemporaryEmployee extends Employee{
    
    private double hours;
    private double hrate;

    public TemporaryEmployee(double hours, double hrate, int empId, String fname, String lname, String nic, String dob, String gender, String dep, String position, String type,String status) {
        super(empId, fname, lname, nic, dob, gender, dep, position, type,status);
        this.hours = hours;
        this.hrate = hrate;
    }

    public TemporaryEmployee(int empId, String fname, String lname, String nic, String dob, String gender, String dep, String position, String type,double hrate) {
        super(empId, fname, lname, nic, dob, gender, dep, position, type);
        this.hrate = hrate;
    }
    
    

    public void setHours(double hours) {
        this.hours = hours;
    }

    public void setHrate(double hrate) {
        this.hrate = hrate;
    }

    public double getHours() {
        return hours;
    }

    public double getHrate() {
        return hrate;
    }
    
    
}
