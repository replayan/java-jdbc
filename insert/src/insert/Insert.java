package insert;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

//class A
//{
//    public void in1()
//}

  
public class Insert 
{
    static final String url= "jdbc:mysql://localhost:3306/ayan";
    public static void main(String[] args) throws ClassNotFoundException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate("INSERT INTO javin VALUES (102, 'Ayan', 'kundu', 20)");
            if (result > 0)
                System.out.println("successfully inserted");
            else
                System.out.println("unsucessful insertion ");
            conn.close();
        }
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    }
}
