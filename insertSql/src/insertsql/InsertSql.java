package insert;
import java.io.*;
import java.sql.*;
  
public class InsertSql 
{
    static final String url= "jdbc:mysql://localhost:3306/ayan";
    public static void main(String[] args)
        throws ClassNotFoundException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
  
            Connection conn = DriverManager.getConnection(url, "root", "");
  
            Statement stmt = conn.createStatement();
  
            int result = stmt.executeUpdate("INSERT INTO javin VALUES (102, 'Atanu', 'Kundu', 20)");
  
            if (result > 0)
                System.out.println("successfully inserted");
            else
                System.out.println("unsucessful insertion ");
            conn.close();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}
