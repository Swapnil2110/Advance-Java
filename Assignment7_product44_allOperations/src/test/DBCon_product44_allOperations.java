package test;
import java.util.*;
import java.sql.*;
/*
 JDBC application to perform the following operations on DB table Product44
 based on UserChoice:
 1.AddProduct
 2.ViewAllProduct
 3.ViewProductByCode
 4.UpdateProduct(Price & Qty)
 5.DeleteProduct
 */

public class DBCon_product44_allOperations 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl", "swapnil", "swapnil");
			Scanner s = new Scanner(System.in);
			System.out.println("TABLE: PRODUCT44PS");
			System.out.println("select:\n1.AddProductDetails\n2.ViewAllProducts"
					+ "\n3.ViewProductByCode \n4.UpdateProduct \n5.DeleteProduct");
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
				//ViewAllProducts
				PreparedStatement ps2 = con.prepareStatement
							("select * from product44ps");//compilation
				ResultSet rs = ps2.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+
							"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
				}
				break;
			case 3:
				//ViewProductByCode
				PreparedStatement ps3 = con.prepareStatement
				("select * from product44ps where pcode=?");//compilation
				System.out.println("Enter pCode: ");
				pCode = s.nextLine();
				
				ps3.setString(1, pCode);
				
				ResultSet rs2 = ps3.executeQuery();//execution
				while(rs2.next())
				{
					System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+
							"\t"+rs2.getFloat(3)+"\t"+rs2.getInt(4));
				}
				break;
			case 4:
				//UpdateProduct(price & qty)
				PreparedStatement ps4 = con.prepareStatement
				("select * from product44ps where pcode=?");//compilation
				System.out.println("Enter pCode: ");
				pCode = s.nextLine();
				ps4.setString(1,pCode);
				ResultSet rs4 = ps4.executeQuery();//execution
				if(rs4.next())
				{
					System.out.println("Old Price of "+pCode+": "+rs4.getFloat(3));
					System.out.println("Old Qty of "+pCode+": "+rs4.getInt(4));
					System.out.println("Enter new Price of "+pCode+": ");
					pPrice = Float.parseFloat(s.nextLine());
					System.out.println("Enter new Qty of "+pCode+": ");
					pQty = Integer.parseInt(s.nextLine());
					PreparedStatement ps41 = con.prepareStatement
					("update product44ps set pprice=?, pqty=pqty+? where pcode=?");//compilation
					ps41.setFloat(1, pPrice);
					ps41.setInt(2, pQty);
					ps41.setString(3, pCode);
					int k2 = ps41.executeUpdate();//execution
					if(k2>0)
					{
						System.out.println("Product Details Updated for "+pCode+" successfully...");
					}
					else
					{
						System.out.println("Failed to update product details...");
					}
				}
				else
				{
					System.out.println("Invalid pCode");
				}
				break;
			case 5:
				//DeleteProduct
				System.out.println("Enter pCode you wants to delete");
				pCode = s.nextLine();
				PreparedStatement ps5 = con.prepareStatement
					("select * from product44ps where pCode=?");//compilation
				ps5.setString(1, pCode);
				ResultSet rs5 = ps5.executeQuery();//execution
				if(rs5.next())
				{
					PreparedStatement ps51 = con.prepareStatement
						("delete from product44ps where pcode=?");
					ps51.setString(1, pCode);
					int k5 = ps51.executeUpdate();//execution
					if(k5>0)
					{
						System.out.println("Product "+pCode+" deleted successfully...");
					}
					else
					{
						System.out.println("Failed to delete product...");
					}
				}
				else
				{
					System.out.println("Product "+pCode+" does not exist in product44ps");
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
