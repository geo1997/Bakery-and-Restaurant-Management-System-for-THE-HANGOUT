package FinishedProducts.Prod;

import FinishedProducts.Connection.MyConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Avishka
 */
public class ManageProducts {
    
    MyConnection myConnection =new MyConnection();
    
    
    //create a function to add products
    public boolean addProductStock(String name, int quantity, int leftQty, String arrivalDate, String expiryDate){
        PreparedStatement st;
        String addQuery = "INSERT INTO Stock (name,qty,leftQty,arrivalDate,expDate) VALUES(?,?,?,?,?)";
        
        try {
            st = myConnection.createConnection().prepareStatement(addQuery);
            
            st.setString(1, name);
            st.setInt(2, quantity);
            st.setInt(3, leftQty);
            st.setString(4, arrivalDate);
            st.setString(5, expiryDate);
            
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //create a function to update a selected product
    public boolean updateProductStock(String name, int leftQty, String expiryDate, int stockId){
        PreparedStatement st;
        String editQuery = "UPDATE Stock SET name=?, leftQty=?, expDate=? WHERE stockId=?";
        
        try {
            st = myConnection.createConnection().prepareStatement(editQuery);
            
            st.setString(1, name);
            st.setInt(2, leftQty);
            st.setString(3, expiryDate);
            st.setInt(4, stockId);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //create a function to delete a selected product
    public boolean deleteProductStock(int stockId){
        PreparedStatement st;
        String deleteQuery = "DELETE FROM Stock WHERE stockId=?";
        
        try {
            st = myConnection.createConnection().prepareStatement(deleteQuery);
            st.setInt(1, stockId);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
}
