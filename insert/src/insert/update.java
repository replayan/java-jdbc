package insert;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class update
{
    static final String url= "jdbc:mysql://localhost:3306/ayan";
    public static void main(String[] args) throws ClassNotFoundException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate("update javin set L_name='Ayan',F_name='Ch',age='19' where id='102'");
            if (result > 0)
                System.out.println("successfully updated");
            else
                System.out.println("unsucessful updation ");
            conn.close();
        }
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    }
}
