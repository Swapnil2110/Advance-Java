package test;
import java.sql.*;

public class CheckBookDAO 
{
	public String checkBook(BookBean bb)
	{
		String s1 = null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select * from book44 where bcode=?");
			//set values to PreparedStatement
			ps.setString(1, bb.getBcode());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				s1="available";
			}
			
		}catch(Exception e) {e.printStackTrace();}
		
		return s1; 
	}
}
