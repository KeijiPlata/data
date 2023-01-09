package try3;
import java.util.Scanner;
import java.sql.*;

public class Try3 {
    public static void main(String[] args) {
            // new object
      inputAndConnection ic = new inputAndConnection();
      ic.start();
      ic.connectionDB();
    }
    
}
class inputAndConnection{
    String username, password, role;
    public void start(){
        // Userinput
        Scanner input = new Scanner(System.in); 
        System.out.println("Enter Data: ");
        System.out.print("Username: ");
        username = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();
        role = "student";
    }
    
    public void connectionDB(){
       try{
            String db = "jdbc:mysql://localhost:3306/joysis_ams";
            Connection conn = DriverManager.getConnection(db, "root", null);
            String qry = "INSERT INTO login values (?, ?, ?)";
            PreparedStatement pstmnt = conn.prepareStatement(qry);
            pstmnt.setString(1, username);
            pstmnt.setString(2, password);
            pstmnt.setString(3, role);
            pstmnt.executeUpdate();
            System.out.println("Data Inserted");
       
        }
        catch(SQLException a){
            System.out.println("Error");
            a.printStackTrace();
        }
    }
}