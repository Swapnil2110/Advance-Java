package test;
import java.sql.*;

public class AddBookDAO 
{
	public int k=0;
	public int addBook(BookBean bb)
	{
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
				("insert into book44 values(?,?,?,?,?)");
			ps.setString(1, bb.getBcode());
			ps.setString(2, bb.getBname());
			ps.setString(3, bb.getBauthor());
			ps.setFloat(4, bb.getBprice());
			ps.setInt(5, bb.getBqty());
			
			k = ps.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}

}
