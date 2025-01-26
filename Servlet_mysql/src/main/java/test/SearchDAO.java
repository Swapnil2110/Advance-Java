package test;
import java.sql.*;
import java.util.*;
public class SearchDAO
{ 
	ArrayList<empbean> al = new ArrayList<empbean>();
	public ArrayList<empbean> search(String str)
	{
		try
		{
			Connection con = DBconnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from employee where empname=?");
			ps.setString(1,str);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{ 
				empbean eb = new empbean();
				eb.setEmpid(rs.getString(1));
				eb.setEmpname(rs.getString(2));
				eb.setDesg(rs.getString(4));
				eb.setYerofexp(rs.getInt(3));
				al.add(eb);
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}
