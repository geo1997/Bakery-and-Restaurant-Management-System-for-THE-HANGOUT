/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee.Dashboard;

import DB_Connection.DB;
//import com.sun.istack.internal.NotNull;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Employee {
    
    DB db = new DB();
   
    private int empId;
    private String fname;
    private String lname;
    private String nic;
    private String dob;
    private String gender;
    private String dep;
    private String position;
    private String type;
    private String status;

    public Employee() {
    }

    public Employee(int empId, String fname, String lname, String type,String status) {
        this.empId = empId;
        this.fname = fname;
        this.lname = lname;
        this.type = type;
        this.status = status;
    }
    
    
    

    public Employee(int empId, String fname, String lname, String nic, String dob, String gender, String dep, String position, String type,String status) {
        this.empId = empId;
        this.fname = fname;
        this.lname = lname;
        this.nic = nic;
        this.dob = dob;
        this.gender = gender;
        this.dep = dep;
        this.position = position;
        this.type = type;
        this.status = status;
    }

    public Employee(int empId, String fname, String lname, String nic, String dob, String gender, String dep, String position, String type) {
        this.empId = empId;
        this.fname = fname;
        this.lname = lname;
        this.nic = nic;
        this.dob = dob;
        this.gender = gender;
        this.dep = dep;
        this.position = position;
        this.type = type;
    }

    

    public int getEmpId() {
        return empId;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getNic() {
        return nic;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getDep() {
        return dep;
    }

    public String getPosition() {
        return position;
    }

    public String getType() {
        return type;
    }


    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
     
//    //Function to add employees to the system
//    public boolean addEmployee(String fname,String lname,String nic,String dob,String gender,String dep,String position,String type,double basicSal,double otRate){
//        
//        
//        PreparedStatement st;
//        ResultSet rs;
//        String addQuery = "";
//        
//        return true;
//    }
    
//    //Function to populate the jtable with employee details
//    public void fillEmployeeTable(JTable table){
//        
//        PreparedStatement ps;
//        ResultSet rs;
//        String selectQuery = "SELECT id,fname,lname,nic FROM employee";
//        
//        try {
//            ps = db.createConnection().prepareStatement(selectQuery);
//            rs = ps.executeQuery();
//            
//            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
//            
//            Object[] row;
//            
//            while(rs.next()){
//                row = new Object[5];
//                row[0] = rs.getInt(1);
//                row[1] = rs.getString(2);
//                row[2] = rs.getString(3);
//                row[3] = rs.getString(4);
//             
//                tableModel.addRow(row);
//            }
//        } catch (SQLException ex) {
//             Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  
}
