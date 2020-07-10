
package HallFunc.mycode;


//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class DBconnect {
    
    public static Connection connect(){
        Connection conn=null;
        
        String db="hangout";
        String url="jdbc:mysql://localhost:3306/"+db;
        String username="root";
        String password="root";
        
        try {
            //Class.forName("com.mysql.jdbc.Driver");
           // conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hangout", "root", "");
            conn = DriverManager.getConnection(url,username,password);
            if(conn!=null){
            //System.out.println("DB connented successfully");
            }
        } 
        catch (Exception e) 
        {
        Logger.getLogger(DBconnect.class.getName()).log(Level.SEVERE,null,e);
            //System.out.println(e+"DB not connented");
            return null;
        }
        
        return conn;
    }

   // public static java.sql.Connection Connect() {
   //     throw new UnsupportedOperationException("Not supported yet."); 
   // }
    
}