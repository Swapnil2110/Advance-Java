package test;
import java.util.*;
import java.sql.*;
/*
 Transaction Management program
 Transaction => Transfer amt 3000/- from accNo:6123456 to accNo:9876549
SubT1 => Subtract amt 3000/- from accNo:6123456
SubT2 => Add amt 3000/- to accNo:9876549
 */

public class DBCon_bank44_TM 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","swapnil","swapnil");
			Scanner s = new Scanner(System.in);
			/*
				System.out.println("status: "+con.getAutoCommit());
				con.setAutoCommit(false);
				System.out.println("status: "+con.getAutoCommit());
			*/
			con.setAutoCommit(false);
			PreparedStatement ps1 = con.prepareStatement
					("select * from bank44 where accno=?");//compilation
			PreparedStatement ps2 = con.prepareStatement
					("update bank44 set balance=balance+? where accno=?");//compilation
			
			Savepoint sp = con.setSavepoint();
			
			//enter sender's bank accno
			System.out.println("Enter Sender's accno: ");
			long saccno = s.nextLong();
			ps1.setLong(1, saccno);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next())
			{
				float bal = rs1.getFloat(3);
				
				//enter receiver's bank accno
				System.out.println("Enter receiver's accno: ");
				long raccno = s.nextLong();
				ps1.setLong(1, raccno);
				ResultSet rs2 = ps1.executeQuery();
				if(rs2.next())
				{
					System.out.println("Enter amount to be transferred: ");
					int amt = s.nextInt();
					if(amt<=bal)
					{
						//deducting money from sender
						ps2.setInt(1,-amt);
						ps2.setLong(2, saccno);
						int p = ps2.executeUpdate();//execution
						
						//crediting money to receiver
						ps2.setInt(1, amt);
						ps2.setLong(2, raccno);
						int q = ps2.executeUpdate();//execution
						
						if(p==1 && q==1)
						{
							con.commit();//update from buffers to database
							System.out.println("Transaction successfull...");
						}
						else
						{
							System.out.println("Transaction failed...");
							//con.rollback(sp);
						}
						
					}
					else
					{
						System.out.println("Not enough balance...");
					}
				}
				else
				{
					System.out.println("Invalid Receiver's accno...");
				}
			}
			else
			{
				System.out.println("Invalid Sender's accno...");
				con.rollback(sp);
			}
			s.close();
			con.close();
		}catch(Exception e) {e.printStackTrace();}
		
	}
}
