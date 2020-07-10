/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMU.CostAvailabiltyFunction;

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
public class Stock {
    
     Db my_connection = new Db();
     
     //create a functon to update stocks
    public boolean updateStock(int sid,float total,int availability)
    {
        PreparedStatement st;
        String updateQuery = "UPDATE Stock SET total=?,availability=? WHERE stockId=?" ;
        
        try {
            st = my_connection.createConnection().prepareStatement(updateQuery);
           
            st.setFloat(1, total);
            st.setInt(2, availability);
            st.setInt(3, sid);
            
            
            return (st.executeUpdate() > 0);
          
            
           
            
        } catch (SQLException ex) {
            Logger.getLogger(RawStock.class.getName()).log(Level.SEVERE, null, ex);
            return false;  
        }
    }
    
    //create a functon to update stocks
    public boolean updateUtiStock(int uid,float total,int availability)
    {
        PreparedStatement st;
        String updateQuery = "UPDATE utilities SET total=?,availability=? WHERE utilityId=?" ;
        
        try {
            st = my_connection.createConnection().prepareStatement(updateQuery);
            
            st.setFloat(1, total);
            st.setInt(2, availability);
            st.setInt(3, uid);
            
            
            return (st.executeUpdate() > 0);
          
            
           
            
        } catch (SQLException ex) {
            Logger.getLogger(RawStock.class.getName()).log(Level.SEVERE, null, ex);
            return false;  
        }
    }
    
    //create a function to populate the jtable with all the clients in the database
    public void fillStockJTable(JTable table)
    {
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "SELECT name,stockId,qty,unitPrice,Status1,availability,total  FROM Stock  where unitPrice>0 ";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row; 
            
            while(rs.next())
            {
                row = new Object[8];
                
                row[0] = rs.getString(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getFloat(4);
                row[4] = rs.getString(5);
                row[6] = rs.getInt(6);
                row[7] = rs.getFloat(7);
                row[5] = "Raw Material";
                
                
      
                tableModel.addRow(row);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RawStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //create a function to populate the jtable with all the clients in the database
    public void fillStockUtiJTable(JTable table)
    {
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "SELECT uti_name,utilityId,qty,price,Status1,availability,total  FROM utilities  where price>0 ";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row; 
            
            while(rs.next())
            {
                row = new Object[8];
                
                row[0] = rs.getString(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getFloat(4);
                row[4] = rs.getString(5);
                row[6] = rs.getInt(6);
                row[7] = rs.getFloat(7);
                row[5] = "Utility";

      
                tableModel.addRow(row);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RawStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
