package test;
import java.sql.*;

public class DeleteBookDAO 
{
	public String checkBookCode(BookBean bb)
	{
		String str = null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select * from book44 where bcode=?");
			//set values to PreparedStatement
			ps.setString(1, bb.getBcode());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				str="available";
			}
			
		}catch(Exception e) {e.printStackTrace();}
		
		return str;
	}
	
	public int deleteBook(BookBean bb)
	{
		int k =0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("delete from book44 where bcode=?");
			//set values to PreparedStatement
			ps.setString(1, bb.getBcode());
			
			k = ps.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
