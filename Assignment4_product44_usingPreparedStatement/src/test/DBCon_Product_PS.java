package test;
import java.util.*;
import java.sql.*;
//program to AddProductDetails and ViewProductDetails using PreparedStatement
public class DBCon_Product_PS 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl", "swapnil", "swapnil");
			Scanner s = new Scanner(System.in);
			System.out.println("TABLE: PRODUCT44PS");
			System.out.println("select:\n1.AddProductDetails\n2.ViewProductDetails");
			System.out.println("enter Choice: ");
			int choice = Integer.parseInt(s.nextLine());
			switch(choice)
			{
			case 1:
				//AddProductDetails as pCode, pName, pPrice, pQty into table product44ps
				PreparedStatement ps1 = con.prepareStatement
					("insert into product44ps values(?,?,?,?)");//compilation
				System.out.println("Enter pCode: ");
				String pCode = s.nextLine();
				System.out.println("Enter pName: ");
				String pName = s.nextLine();
				System.out.println("Enter pPrice: ");
				float pPrice = s.nextFloat();
				System.out.println("Enter pQty: ");
				int pQty = s.nextInt();
				
				ps1.setString(1, pCode);
				ps1.setString(2, pName);
				ps1.setFloat(3, pPrice);
				ps1.setInt(4, pQty);
				
				int k = ps1.executeUpdate();//execution
				if(k>0)
				{
					System.out.println("ProductDetails inserted successfully...");
				}
				break;
			case 2:
				PreparedStatement ps2 = con.prepareStatement
							("select * from product44ps");//compilation
				ResultSet rs = ps2.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+
							"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
				}
				break;
			default:
				System.out.println("Invalid choice...");
				break;
			}//end of switch
			s.close();
			con.close();
		}catch(Exception e) {e.printStackTrace();}
	}
}
