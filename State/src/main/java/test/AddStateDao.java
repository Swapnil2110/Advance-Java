package test;
import java.sql.*;

public class AddStateDao 
{
	public int k=0;
	public int addState(StateBean sb)
	{
		try{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
				("insert into state44 values(?,?)");
			ps.setString(1, sb.getScode());
			ps.setString(2, sb.getSname());
			
			k = ps.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
