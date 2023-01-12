// import packages needed
package joysis_ams;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionDB {
    // attributes
    static boolean validation;
    static String uname;
    static String fname;
    static String mname;
    static String lname;
    static String sec;
    static int id;
    
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
                uname = username;
              
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
    
    public void getUsername(String username){
        try{
            String db = "jdbc:mysql://localhost:3306/joysis_ams";
            Connection conn = DriverManager.getConnection(db, "root", null);
            String qry = "SELECT * FROM student WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(qry);
            ps.setString(1, username);
            ResultSet rslt = ps.executeQuery();
            while(rslt.next()){
                id = rslt.getInt("student_id");
                fname = rslt.getString("firstname");
                mname = rslt.getString("middlename");
                lname = rslt.getString("lastname");
                sec = rslt.getString("section");
              
            } 
        }
        catch(Exception a){
            JOptionPane.showMessageDialog(null, a);
            a.printStackTrace();
        }
    }
}
