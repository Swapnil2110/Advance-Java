package test;
import java.sql.*;
import java.util.*;

public class RetrieveDAO 
{
	public ArrayList<ProductBean> al = new ArrayList<ProductBean>();
	public ArrayList<ProductBean> retrieve()
	{
		try {
			Connection con = DBConnection.getCon();//Accessing Connection
			PreparedStatement ps = con.prepareStatement
				("select * from product44");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ProductBean pb = new ProductBean();//Bean Object
				pb.setCode(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getFloat(3));
				pb.setQty(rs.getInt(4));
				al.add(pb);//Adding bean object to ArrayList
			}//end of loop
		}catch(Exception e) {e.printStackTrace();}
		return al;
	}
}
