/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMU.RawMaterialFunction;

import RMU.db.Db;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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
public class RawStock {
    
    private String name;
    private int sid;
    private int quantity;
    private float price;
    private String arrD;
    private String expD;
    private String status;
    private float total;
    private int availability;


    public RawStock(){}
    
    public RawStock(String name, int sid, int quantity, float price, String arrD, String expD,String status) {
        this.name = name;
        this.sid = sid;
        this.quantity = quantity;
        this.price = price;
        this.arrD = arrD;
        this.expD = expD;
        this.status = status;
    }

     public RawStock(String name, int sid, int quantity, float price,String status,float total,int availability) {
        this.name = name;
        this.sid = sid;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.total = total;
        this.availability = availability;
    }
    
    public RawStock(String name)
    {
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
	

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public int getSid() {
        return sid;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public String getArrD() {
        return arrD;
    }

    public String getExpD() {
        return expD;
    }

    public Db getMy_connection() {
        return my_connection;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setArrD(String arrD) {
        this.arrD = arrD;
    }

    public void setExpD(String expD) {
        this.expD = expD;
    }

    public void setMy_connection(Db my_connection) {
        this.my_connection = my_connection;
    }
    
    
    
    
    Db my_connection = new Db();
    Db db = new Db();
    
    
    public Connection getConnection()
    {
        Connection con = null;
        String db="hangout";
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db,"root","root");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
    //creating a function to add stocks
    public boolean addStock(String name,int quantity,float price,String arrD,String expD)
    {
        PreparedStatement st;
        ResultSet rs;
        String addQuery = "INSERT INTO Stock (name,qty,unitPrice,arrivalDate,expDate) VALUES (?,?,?,?,?);";
        
        try {
            st = my_connection.createConnection().prepareStatement(addQuery);
            
            st.setString(1, name);
            st.setInt(2, quantity);
            st.setFloat(3, price);
            st.setString(4, arrD);
            st.setString(5, expD);
       
            
           
            return (st.executeUpdate() > 0);
           
            
        } catch (SQLException ex) {
            Logger.getLogger(RawStock.class.getName()).log(Level.SEVERE, null, ex);
            return false;  
        }
        
        
    }
    //create a functon to update stocks
    public boolean updateStock(String name,int sid,int quantity,float price,String arrD,String expD)
    {
        PreparedStatement st;
        String updateQuery = "UPDATE Stock SET name=?,qty=?,unitPrice=?,arrivalDate=?,expDate=? WHERE stockId=?" ;
        
        try {
            st = my_connection.createConnection().prepareStatement(updateQuery);
            
            st.setString(1, name);
            st.setInt(2, quantity);
            st.setFloat(3, price);
            st.setString(4, arrD);
            st.setString(5, expD);
            st.setInt(6,sid);
            
            
            return (st.executeUpdate() > 0);
          
            
           
            
        } catch (SQLException ex) {
            Logger.getLogger(RawStock.class.getName()).log(Level.SEVERE, null, ex);
            return false;  
        }
    }
    
    
    //create a function to delete stocks
    
    //create a function to populate the jtable with all the clients in the database
    public void fillStockJTable(JTable table)
    {
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "SELECT name,stockId,qty,unitPrice, arrivalDate, expDate,Status1  FROM Stock where unitPrice>0 ";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row; 
            
            while(rs.next())
            {
                row = new Object[7];
                
               
               
                 
                row[0] = rs.getString(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getFloat(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
      
                tableModel.addRow(row);
                
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RawStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        
//         Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.format(date);
//        Date expDate = new Date();
//        dateFormat.format(expDate);
//        
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        int rows = model.getRowCount();
//        
//        Object d;
//        Object o;
//        int id;
//        String editQuery;
//        for(int i=0; i<rows; i++){
//            d = model.getValueAt(i, 3);
//            o = model.getValueAt(i, 0);
//            expDate = (Date) d;
//            id = (int) o;
//            if(expDate.before(date) || expDate.equals(date)){
//                editQuery = "UPDATE Stock SET status1='Expired' WHERE stockId='"+id+"'";
//                PreparedStatement ps1;
//                try {
//                    ps1 = myConnection.createConnection().prepareStatement(editQuery);
//                    ps1.execute();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ViewOrder.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        
//        String refresh = "select stockId as 'Stock ID', leftQty as 'Quantity', arrivalDate as 'Arrival Date', expDate as 'Expiry Date', status1 as 'Status' from Stock where name like '%"+name+"%'";
//        PreparedStatement ps2;
//        ResultSet rs2;
//        try {
//            ps2 = myConnection.createConnection().prepareStatement(refresh);
//            rs2 = ps2.executeQuery();
//            
//            jTable1.setModel(DbUtils.resultSetToTableModel(rs2));
//            Object s;
//            String status;
//            
//            for(int x=0; x<rows; x++){
//                s = model.getValueAt(x, 4);
//                status = (String) s;
//                if(status.equals("Expired"))
//                    setBackground(Color.RED);
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
//        }

try {
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");  
            java.util.Date date = new java.util.Date();  
            String currentD = dateFormat.format(date); 
            
            String expDate = "select expDate as exp from Stock where Status1 like 'Expired'";
            
            PreparedStatement ps1;
            ResultSet rs1;
  
            ps1 = db.createConnection().prepareStatement(expDate);
            rs1 = ps1.executeQuery();
//            String exp = rs1.getString("exp");
            
            while(rs1.next())
            {
                
                     String exp = rs1.getString("exp");

                     if(currentD.compareTo(exp)>0){
                         Connection conn = getConnection();
                         ps1 = conn.prepareStatement("UPDATE Stock SET Status1 = 'Expired' WHERE expDate = '"+exp+"' ");
                         ps1.executeUpdate();
                     } 
            }
                
                
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
}
