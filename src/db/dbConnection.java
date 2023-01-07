 
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 
public class dbConnection {
     private static Connection con;
    public static Connection getconnection(){
        if(con == null){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/pcgadguestshop?useSSL=false&allowPublicKeyRetrieval=true", "root", "chamodjava.01");
               
           // con = DriverManager.getConnection("jdbc:mysql://localhost:3307/school_managment?useSSL=false", "root", "chamodjava.01"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }
        return con;
    }
    public static void main(String[] args) throws SQLException {
        System.out.println(getconnection().getCatalog());
    }
    
    
}
