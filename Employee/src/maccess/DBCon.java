package maccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import maccess.Emp3;

public class DBCon 
{
	static int insert(Employee emp)
	{
		int k = 0; 
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","swapnil","swapnil");
			PreparedStatement ps1 = con.prepareStatement
					("insert into employee values(?,?,?,?,?,?)");
			 
			ps1.setString(1, emp.getEmpNo());
			ps1.setString(2, emp.getEmpName());
			ps1.setString(3, emp.getDob());
			ps1.setString(4, emp.getDesg());
			ps1.setDouble(5, emp.getmSal());
			ps1.setDouble(6, emp.getaSal());
			
			k = ps1.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
