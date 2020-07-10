/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMU.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Db {

   
    public Connection createConnection(){
        
       
            Connection conn=null;
        
            MysqlDataSource mds = new MysqlDataSource();
            
           String db = "hangout";
           String url = "jdbc:mysql://localhost:3306/"+db;
           String username = "root";
           String password = "root";
           
           mds.setServerName("localhost");
           mds.setPortNumber(3306);
           mds.setUser("root");
           mds.setPassword("root");
           mds.setDatabaseName("hangout");
           
        try {
            conn = mds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
    
}

