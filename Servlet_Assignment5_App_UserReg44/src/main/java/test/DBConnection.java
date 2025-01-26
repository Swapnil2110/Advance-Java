/*SingleTon class*/
package test;
import java.sql.*;

public class DBConnection 
{
	private static Connection con = null;
	
	private DBConnection() {}//private Constructor
	
	static
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","swapnil","swapnil");
			
		}catch(Exception e) {e.printStackTrace();}
	}//end of block
	
	public static Connection getCon()
	{
		return con;
	}
}
