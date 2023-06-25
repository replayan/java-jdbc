package insert;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

class A
{
    Scanner sc = new Scanner(System.in);
    int age,id;
    String fname,lname;
    public void inputId()
    {
        System.out.print("Enter Id : ");
        id = sc.nextInt();
    }
    public void inputData()
    {
        System.out.print("Enter Last Name : ");
        lname = sc.next();
        System.out.print("Enter First Name : ");
        fname = sc.next();
        System.out.print("Enter Age : ");
        age = sc.nextInt();
    }
}
class B extends A
{
    static final String url= "jdbc:mysql://localhost:3306/ayan";
    public void insert() throws ClassNotFoundException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate("INSERT INTO javin VALUES ("+id+",'"+fname+"','"+lname+"',"+age+")");
            if (result > 0)
                System.out.println(" INSERTED ");
            else
                System.out.println("unsucessful insertion ");
            conn.close();
        }
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    }
    public void delete() throws ClassNotFoundException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate("delete from javin where id = "+id+"");
            if (result > 0)
                System.out.println(" DELETED ");
            else
                System.out.println("unsucessful deletion ");
            conn.close();
        }
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    }
    public void update() throws ClassNotFoundException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate("update javin set f_name ='"+fname+"', l_name ='"+lname+"', age ="+age+" where id="+id+"");
            if (result > 0)
                System.out.println(" UPDATED ");
            else
                System.out.println("unsucessful updation ");
            conn.close();
        }
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    }
    public void dbTable() throws ClassNotFoundException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM javin");
            System.out.println("Id\t\tFirst name\tLast name\tAge");
            System.out.print("\n----------------------------------------------------");
           
            while(rs.next())
            {  
                System.out.println("\n"+rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getInt("age"));  
                System.out.print("----------------------------------------------------");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}

public class crud 
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        Scanner r = new Scanner(System.in);
        B obj = new B();
        int choice;
        System.out.print("\t  CRUD MENU : ");
        System.out.print("\n\t------------------------");
        System.out.print("\n\t 1. INSERT\n\t 2. DELETE\n\t 3. UPDATE\n\t 4. Show table\n\t 5. EXIT");
        do
        {
            System.out.print("\nEnter choice to perform CRUD : ");
            choice = r.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("You have chosen INSERTION!");
                    obj.inputId();
                    obj.inputData();
                    obj.insert();
                    //obj.dbTable();
                    break;
                case 2:
                    System.out.println("You have chosen DELETION!");
                    obj.inputId();
                    obj.delete();
                    //obj.dbTable();
                    break;
                case 3:
                    System.out.println("You have chosen to UPDATE!");
                    obj.inputId();
                    obj.inputData();
                    obj.update();
                    //obj.dbTable();
                    break;
                case 4:
                    System.out.println("SHOWING WHOLE DB TABLE!");
                    obj.dbTable();
                    break;
                case 5:
                    System.out.println("EXITING MENU!");
                    System.exit(0);
                default:
                    System.out.print("\n\t Entered choice beyond 5!!!");
            }
        } while (choice != 5);
        }
    }
    

