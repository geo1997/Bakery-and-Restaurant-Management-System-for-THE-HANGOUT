/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMU.UtilityFunction;

import RMU.RawMaterialFunction.RawStock;
import RMU.db.Db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class UtilityStock {
    
    private String name;
    private int uid;
    private int quantity;
    private float price;
    private String arrD;
    private String status;
    private float total;
private int availability;
    
    public UtilityStock(){};

    public UtilityStock(String name, int uid, int quantity, float price, String arrD, String status) {
        this.name = name;
        this.uid = uid;
        this.quantity = quantity;
        this.price = price;
        this.arrD = arrD;
        this.status = status;
    }
    
 	
	 public UtilityStock(String name, int uid, int quantity, float price, String status,float total,int availability) {
        this.name = name;
        this.uid = uid;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.total = total;
        this.availability = availability;
         }
    
    public UtilityStock(String name){
        this.name = name;
    }

    	 public void setAvailability(int availability) {
        this.availability = availability;
    }
     
     public int getAvailability() {
        return availability;
    }

    
    public void setTotal(float total) {
        this.total = total;
    }

    public float getTotoal() {
        return total;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int sid) {
        this.uid = sid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getArrD() {
        return arrD;
    }

    public void setArrD(String arrD) {
        this.arrD = arrD;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    Db my_connection = new Db();
    
    //creating a function to add stocks
    public boolean addStock(String name,int quantity,float price,String arrD)
    {
        PreparedStatement st;
        ResultSet rs;
        String addQuery = "INSERT INTO Utilities (uti_name,qty,price,arrD) VALUES (?,?,?,?);";
        
        try {
            st = my_connection.createConnection().prepareStatement(addQuery);
            
            st.setString(1, name);
            st.setInt(2, quantity);
            st.setFloat(3, price);
            st.setString(4, arrD);
       
            
           
            return (st.executeUpdate() > 0);
           
            
        } catch (SQLException ex) {
            Logger.getLogger(RawStock.class.getName()).log(Level.SEVERE, null, ex);
            return false;  
        }
        
        
    }
    //create a functon to update stocks
    public boolean updateStock(String name,int uid,int quantity,float price,String arrD)
    {
        PreparedStatement st;
        String updateQuery = "UPDATE Utilities SET uti_name=?,qty=?,price=?,arrD=? WHERE utilityId=? " ;
        
        try {
            st = my_connection.createConnection().prepareStatement(updateQuery);
            
            st.setString(1, name);
            st.setInt(2, quantity);
            st.setFloat(3, price);
            st.setString(4, arrD);
            st.setInt(5,uid);
            
            
            return (st.executeUpdate() > 0);
          
            
           
            
        } catch (SQLException ex) {
            Logger.getLogger(RawStock.class.getName()).log(Level.SEVERE, null, ex);
            return false;  
        }
    }
    
    
    
    //create a function to populate the jtable with all the stocks in the database
    public void fillStockJTable1(JTable table)
    {
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "SELECT uti_name, utilityId, qty, price, arrD, Status1 FROM Utilities";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row; 
            
            while(rs.next())
            {
                row = new Object[6];
                
                row[0] = rs.getString(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getFloat(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
      
                tableModel.addRow(row);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RawStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
