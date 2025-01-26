package pkg;
import java.sql.*;
public class DBConnection 
{
	private static Connection con = null;
	private DBConnection() {}
	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");//step=1
			System.out.println("1");
			con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/test","root@localhost","");//step=2
			System.out.println("2");
			Statement stm = con.createStatement(); //step-3
			ResultSet rs = stm.executeQuery("select * from employee"); //step-4
			System.out.println("3");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			}
			con.close(); //step-5
		}
		catch(Exception e) {e.printStackTrace();}
	}
	public static Connection getCon()
	{
		return con;
		
	}
}
