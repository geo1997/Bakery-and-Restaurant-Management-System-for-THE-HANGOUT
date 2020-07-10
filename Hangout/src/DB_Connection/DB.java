/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DB {
    
    
    public Connection createConnection(){
        Connection conn = null;
        
        MysqlDataSource mds = new MysqlDataSource();
        
        mds.setServerName("localhost");
        mds.setPortNumber(3306);
        mds.setUser("root");
        mds.setPassword("root");
        mds.setDatabaseName("hangout");
        
        try {
            conn = mds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
    
//        public static void main(String[] args){
////        Connection conn = null;
////        
////        String db = "hangout";
////        String url = "jdbc:mysql://localhost:3306/"+db;
////        String username = "root";
////        String password = "root";
//        
//        try {
//            conn = DriverManager.getConnection(url,username,password);
//            if(conn!=null)
//                System.out.println("Connection successful");
//        } catch (Exception e) {
//            System.out.println("Connection unsuccessful");
//        }
//        
//     }
}
