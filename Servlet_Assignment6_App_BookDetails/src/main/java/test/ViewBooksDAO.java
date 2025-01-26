package test;
import java.sql.*;
import java.util.*;

public class ViewBooksDAO 
{
	public ArrayList<BookBean> al = new ArrayList<BookBean>();
	
	public ArrayList<BookBean> viewBooks()
	{
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
				("select * from book44");
			ResultSet rs = ps.executeQuery();
			BookBean bb= null;
			while(rs.next())
			{
				bb = new BookBean();//Bean Object
				bb.setBcode(rs.getString(1));
				bb.setBname(rs.getString(2));
				bb.setBauthor(rs.getString(3));
				bb.setBprice(rs.getFloat(4));
				bb.setBqty(rs.getInt(5));
				al.add(bb);//adding bean object to ArrayList
			}//end of loop
			bb = null;
		}catch(Exception e) {e.printStackTrace();}
		
		return al;
	}
}
