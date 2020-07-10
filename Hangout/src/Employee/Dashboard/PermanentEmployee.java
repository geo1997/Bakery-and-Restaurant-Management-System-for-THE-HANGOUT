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
public class PermanentEmployee extends Employee{

  private double basicSalary;
  private double epf;
  private double bonus;

    public PermanentEmployee(double basicSalary,double epf, int empId, String fname, String lname, String nic, String dob, String gender, String dep, String position, String type) {
        super(empId, fname, lname, nic, dob, gender, dep, position, type);
        this.basicSalary = basicSalary;
        this.epf = epf;
    }

    public PermanentEmployee(int empId, String fname, String lname, String nic, String dob, String gender, String dep, String position, String type,double basicSalary) {
        super(empId, fname, lname, nic, dob, gender, dep, position, type);
        this.basicSalary = basicSalary;
    }


    
    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void setEpf(double epf) {
        this.epf = epf;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getEpf() {
        return epf;
    }

    public double getBonus() {
        return bonus;
    }
  
}
