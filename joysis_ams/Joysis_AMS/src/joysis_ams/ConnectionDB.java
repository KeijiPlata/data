// import packages needed
package joysis_ams;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionDB {
    // attributes
    static boolean validation;
    public void connection(String username, String password, String qry){
        try{
            String db = "jdbc:mysql://localhost:3306/joysis_ams";
            Connection conn = DriverManager.getConnection(db, "root", null);
            PreparedStatement ps = conn.prepareStatement(qry);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rslt = ps.executeQuery();
            if(rslt.next()){
                JOptionPane.showMessageDialog(null, "ADMIN DETECTED \n"
                                + "ACCESS GRANTED!");
                validation = true;
              
            } else {
                   JOptionPane.showMessageDialog(null, "Pakyu mali input \n"
                                + "ACCESS NOT GRANTED!");
                 validation = false;
              }
        }
        catch(Exception a){
            JOptionPane.showMessageDialog(null, a);
            a.printStackTrace();
        }
    }
}
