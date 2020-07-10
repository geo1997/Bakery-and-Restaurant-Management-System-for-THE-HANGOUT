package FinishedProducts.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Avishka
 */
public class MyConnection {
    
    public Connection createConnection(){
        Connection connection = null;
        
        //MysqlDataSource mds = new MysqlDataSource();
        
        String db = "hangout";
        String url = "jdbc:mysql://localhost:3306/"+db;
        String username = "root";
        String password = "root";
        
        /*mds.setServerName("localhost");
        mds.setPortNumber(3306);
        mds.setUser("root");
        mds.setPassword("root");
        mds.setDatabaseName("hangout");
        */
        
        try {
            connection = DriverManager.getConnection(url,username,password);
            if(connection != null)
                System.out.println("Connection successful");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection unsuccessful");
        }
        
        return connection;
    
    }
    
}
