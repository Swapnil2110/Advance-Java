package test;
import java.util.*;
import java.sql.*;
/*
 program to perform following operation
 1.Register
 2.Login
 3.ViewProfile
 */
public class DBCon_UserReg44 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","swapnil","swapnil");
			Scanner s = new Scanner(System.in);
			System.out.println("TABLE: UserReg44");
			System.out.println("Choose operation:\n1.Registration\n2.Login\n3.ViewProfile");
			System.out.println("Enter Choice: ");
			int choice = Integer.parseInt(s.nextLine());
			switch(choice)
			{
			case 1:
				//register user using uName, pWord, fName, lName, addr, mId, phno
				PreparedStatement ps1 = con.prepareStatement
				("insert into userreg44 values(?,?,?,?,?,?,?)");//compilation
				
				System.out.println("Enter uName: ");
				String uName = s.nextLine();
				System.out.println("Enter pWord: ");
				String pWord = s.nextLine();
				System.out.println("Enter fName: ");
				String fName = s.nextLine();
				System.out.println("Enter lName: ");
				String lName = s.nextLine();
				System.out.println("Enter addr: ");
				String addr = s.nextLine();
				System.out.println("Enter mId: ");
				String mId = s.nextLine();
				System.out.println("Enter phno: ");
				long phno = s.nextLong();
				
				//set values
				ps1.setString(1, uName);
				ps1.setString(2, pWord);
				ps1.setString(3, fName);
				ps1.setString(4, lName);
				ps1.setString(5, addr);
				ps1.setString(6, mId);
				ps1.setLong(7, phno);
				
				int k = ps1.executeUpdate();//execution
				if(k>0)
				{
					System.out.println("User Registered successfully...");
				}
				
				break;
			case 2:
				//login using uName and pWord and display "Welcome User: uName"
				PreparedStatement ps2 = con.prepareStatement
				("select * from userreg44 where uname=? and pword=?");//compilation
				
				System.out.println("Enter uName: ");
				uName = s.nextLine();
				System.out.println("Enter pWord: ");
				pWord = s.nextLine();
				
				//set values
				ps2.setString(1, uName);
				ps2.setString(2, pWord);
				
				ResultSet rs1 = ps2.executeQuery();
				if(rs1.next())
				{
					System.out.println("Welcome User: "+rs1.getString(3));
				}
				else
				{
					System.out.println("Invalid uName or pWord...");
				}
				break;
			case 3:
				//ViewProfile
				//read 'uName and pWord' and display fName, lName, addr, mId, phno
				PreparedStatement ps3 = con.prepareStatement
				("select * from userreg44 where uname=? and pword=?");//compilation
				
				System.out.println("Enter uName: ");
				uName = s.nextLine();
				System.out.println("Enter pWord: ");
				pWord = s.nextLine();
				
				//set values
				ps3.setString(1, uName);
				ps3.setString(2, pWord);
				
				ResultSet rs3 = ps3.executeQuery();
				if(rs3.next())
				{
					System.out.println("fName: "+rs3.getString(3));
					System.out.println("lName: "+rs3.getString(4));
					System.out.println("addr: "+rs3.getString(5));
					System.out.println("mId: "+rs3.getString(6));
					System.out.println("phno: "+rs3.getLong(7));
				}
				else
				{
					System.out.println("Invalid uName or pWord...");
				}
				break;
			default:
				System.out.println("Invalid Choice...");
				break;
			}//end of switch
			s.close();
			con.close();
		}catch(Exception e) {e.printStackTrace();}

	}
}
