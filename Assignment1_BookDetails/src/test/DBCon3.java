package test;
import java.util.*;
import java.sql.*;

public class DBCon3 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//step-1
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl", "swapnil", "swapnil");//step-2
			Statement stm = con.createStatement();//step-3
			Scanner s = new Scanner(System.in);
			System.out.println("Table Name: Book44");
			System.out.println("Select from following:\n1. AddBookDetails\n2. ViewBooks\n3. DeleteBookDetails");
			int n = Integer.parseInt(s.nextLine());
			switch(n)
			{
			case 1:
				//if selected, AddBookDetails
				System.out.println("Enter Book Code: ");
				String bCode = s.nextLine();
				System.out.println("Enter Book Name: ");
				String bName = s.nextLine();
				System.out.println("Enter Book Author: ");
				String bAuthor = s.nextLine();
				System.out.println("Enter Book Price: ");
				float bPrice = s.nextFloat();
				System.out.println("Enter Book Quantity: ");
				int bQty = s.nextInt();
				
				int k = stm.executeUpdate
					("insert into book44 values('"+bCode+"','"+bName+"','"+bAuthor+"',"+bPrice+","+bQty+")");
				if(k>0)
				{
					System.out.println("Data updated successfully in book44...");
				}
				else
				{
					System.out.println("Data is not updated...");
				}
				break;
			case 2:
				//if select ViewBooks
				ResultSet rs = stm.executeQuery("select * from book44");
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)
					+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
				}
				break;
			case 3:
				//if select DeleteBookDetails
				System.out.println("Enter Book Code: ");
				String bCode1 = s.nextLine();
				int k1 = stm.executeUpdate("delete from book44 where bcode='"+bCode1+"'");
				if(k1>0)
				{
					System.out.println("Data Deleted Successfully...");
				}
				break;
			}
			con.close();
			s.close();
		}catch(Exception e) {e.printStackTrace();}
	}
}
