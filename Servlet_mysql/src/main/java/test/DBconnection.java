package test;
import java.sql.*;
public class DBconnection 
{
	private static Connection con = null;
	private DBconnection() {}
	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");//step=1
			con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/test","root","");//step=2
		}
		catch(Exception e) {e.printStackTrace();}
	}
	public static Connection getCon()
	{
		return con;
		
	}
}
