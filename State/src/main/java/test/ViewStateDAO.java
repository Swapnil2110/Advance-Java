package test;
import java.sql.*;
import java.util.*;

public class ViewStateDAO 
{
	public ArrayList<StateBean> al = new ArrayList<StateBean>();
	
	public ArrayList<StateBean> viewState()
	{
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
				("select * from state44");
			ResultSet rs = ps.executeQuery();
			StateBean sb= null;
			while(rs.next())
			{
				sb = new StateBean();//Bean Object
				sb.setScode(rs.getString(1));
				sb.setSname(rs.getString(2));
				al.add(sb);//adding bean object to ArrayList
			}//end of loop
			sb = null;
		}catch(Exception e) {e.printStackTrace();}
		
		return al;
	}
}
