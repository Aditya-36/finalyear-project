/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rating.prediction.based;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author java1
 */
public class dobc {
     public static Connection getConne(){
         Connection conn = null;
        try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ratingspreductionbased", "root", "root");
                System.out.println("connection to the database");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(dobc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dobc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
        
       
        
    }
    
}
