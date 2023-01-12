/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joysis_ams;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class javaconnect {
    Connection conn = null;
    public static Connection ConnectDB(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://"
                    + "localhost/joysis_ams", "root", "");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
}
