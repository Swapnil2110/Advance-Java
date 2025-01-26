package test;
import java.sql.*;
public class InsertDAO 
{
	public int k = 0;
	public int insert(empbean eb)
	{
		try
		{
			Connection con = DBconnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into employee(empid,empname,yearofexp,desg) values (?,?,?,?)");
			ps.setString(1, eb.getEmpid());
			ps.setString(2, eb.getEmpname());
			ps.setInt(3, eb.getYerofexp());
			ps.setString(4, eb. getDesg());
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
