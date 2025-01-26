package test;
import java.sql.*;
import javax.servlet.*;

public class LoginDAO
{
	public String login(ServletRequest req)
	{
		String fname=null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
				("select * from userreg44 where uname=? and pword=?");
			ps.setString(1, req.getParameter("uname"));
			ps.setString(2, req.getParameter("pword"));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				fname = rs.getString(3);
			}
			
		}catch(Exception e) {e.printStackTrace();}
		return fname;
	}
}
