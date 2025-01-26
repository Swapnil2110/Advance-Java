package test;
import java.sql.*;
import java.util.*;
//program to AddBookDetails and ViewBookDetails using PreparedStatement
public class DBCon_Book_PS 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","swapnil","swapnil");
			Scanner s = new Scanner(System.in);
			System.out.println("Table: BOOK44PS");
			System.out.println("Choose Option:\n1.AddBookDetails\n2.ViewBookDetails");
			System.out.println("Enter the Choise: ");
			int choice = Integer.parseInt(s.nextLine());
			switch(choice)
			{
			case 1:
				PreparedStatement ps1 = con.prepareStatement
				("insert into book44ps values(?,?,?,?,?)");//compilation
				
				System.out.println("Enter the bCode: ");
				String bCode = s.nextLine();
				System.out.println("Enter the bName: ");
				String bName = s.nextLine();
				System.out.println("Enter the bAuthor: ");
				String bAuthor = s.nextLine();
				System.out.println("Enter the bPrice: ");
				float bPrice = s.nextFloat();
				System.out.println("Enter the bQty: ");
				int bQty = s.nextInt();
				//set data in prepareStatement()
				ps1.setString(1, bCode);
				ps1.setString(2, bName);
				ps1.setString(3, bAuthor);
				ps1.setFloat(4, bPrice);
				ps1.setInt(5, bQty);
				
				int k = ps1.executeUpdate();//Execution
				if(k>0)
				{
					System.out.println("BookDetails inserted successfully...");
				}
				break;
			case 2:
				PreparedStatement ps2 = con.prepareStatement
				("select * from book44ps");//compilation
				ResultSet rs = ps2.executeQuery();//execution
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+
							rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
				}
				break;
			default:
				System.out.println("Invalid Choice...");
				break;
			}//end of switch
			con.close();
			s.close();
		}catch(Exception e) {e.printStackTrace();}
	}
}
