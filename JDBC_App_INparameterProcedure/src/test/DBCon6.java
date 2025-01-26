package test;
import java.util.*;
import java.sql.*;
//CallableStatement
public class DBCon6 
{
	public static void main(String []args)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","swapnil","swapnil");
			Scanner s = new Scanner(System.in);
			System.out.println("Enter accNo: ");
			long accNo = Long.parseLong(s.nextLine());
			System.out.println("Enter custName: ");
			String custName = s.nextLine();
			System.out.println("Enter balance: ");
			float balance = Float.parseFloat(s.nextLine());
			System.out.println("Enter accType: ");
			String accType = s.nextLine();
			System.out.println("Enter addr: ");
			String addr = s.nextLine();
			System.out.println("Enter mId: ");
			String mId = s.nextLine();
			System.out.println("Enter phNo: ");
			long phNo = Long.parseLong(s.nextLine());
			
			CallableStatement cs = con.prepareCall
					("{call CreateAccount44(?,?,?,?,?,?,?)}"); //compilation
			cs.setLong(1, accNo);
			cs.setString(2, custName);
			cs.setFloat(3, balance);
			cs.setString(4, accType);
			cs.setString(5, addr);
			cs.setString(6, mId);
			cs.setLong(7, phNo);
			
			cs.execute();//execution
			System.out.println("Procedure executed successfully...");
			s.close();
			
		}catch(Exception e) {e.printStackTrace();}
	}
}
