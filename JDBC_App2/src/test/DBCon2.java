package test;
import java.util.*;
import java.sql.*;
public class DBCon2 
{
	public static void main(String[] args) 
	{
		try 
		{
			Scanner s = new Scanner(System.in);
			System.out.println("Enter Employee id: ");
			String eid = s.nextLine();
			System.out.println("Enter Employee Name: ");
			String ename = s.nextLine();
			System.out.println("Enter Employee Desg: ");
			String edesg = s.nextLine();
			System.out.println("Enter Employee Sal: ");
			int esal = s.nextInt();
			Class.forName("oracle.jdbc.driver.OracleDriver"); //step-1
			Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","swapnil","swapnil"); //step-2
			Statement stm = con.createStatement(); //step-3
			int k = stm.executeUpdate("insert into Employee44 values('"+eid+"','"+ename+"','"+edesg+"',"+esal+")"); //step-4
			if(k>0)
			{
				System.out.println("Data updated successfully!!!");
			}
			else
			{
				System.out.println("Data is not Updated!!!");
			}
			con.close(); //step-5
			s.close();
		}catch(Exception e) {e.printStackTrace();}

	}
}
