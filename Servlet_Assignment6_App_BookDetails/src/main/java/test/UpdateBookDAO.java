package test;
import java.sql.*;

public class UpdateBookDAO 
{
	public int k=0;
	public int updateBook(BookBean bb)
	{
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
				("update book44 set bname=?, bauthor=?, bprice=?, bqty=? where bcode=?");
			
			ps.setString(1, bb.getBname());
			ps.setString(2, bb.getBauthor());
			ps.setFloat(3, bb.getBprice());
			ps.setInt(4, bb.getBqty());
			ps.setString(5, bb.getBcode());
			
			k = ps.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
