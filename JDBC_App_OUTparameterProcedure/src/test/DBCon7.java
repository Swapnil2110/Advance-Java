package test;
import java.util.*;
import java.sql.*;
//CallableStatement
public class DBCon7 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","swapnil","swapnil");
			Scanner s = new Scanner(System.in);
			System.out.println("Enter accNo: ");
			long accNo = s.nextLong();
			CallableStatement cs = con.prepareCall
					("{call retrievedetails44(?,?,?,?,?,?,?)}");//compilation
			cs.setLong(1, accNo);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.FLOAT);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.BIGINT);
			
			cs.execute();//execution
			System.out.println("Procedure executed successfully...");
			System.out.println("accNo: "+accNo);
			System.out.println("custName: "+cs.getString(2));
			System.out.println("Balance: "+cs.getFloat(3));
			System.out.println("AccType: "+cs.getString(4));
			System.out.println("Address: "+cs.getString(5));
			System.out.println("Mail-ID: "+cs.getString(6));
			System.out.println("PhoneNo: "+cs.getLong(7));
			
			s.close();
		}catch(Exception e) {e.printStackTrace();}
	}
}
