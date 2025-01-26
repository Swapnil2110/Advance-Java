package test;
import java.util.*;
import java.sql.*;
public class DBCon 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","swapnil","swapnil");
			Statement stm = con.createStatement();
			Scanner s = new Scanner(System.in);
			System.out.println("Table: PRODUCT44");
			System.out.println("Choose from option:\n1. AddProductDetails\n2. ViewProducts");
			int n = Integer.parseInt(s.nextLine());
			switch(n)
			{
			case 1:
				//AddProductDetails as pcode, pname, pprice, pqty
				System.out.println("Enter Product Code: ");
				String pCode = s.nextLine();
				System.out.println("Enter Product Name: ");
				String pName = s.nextLine();
				System.out.println("Enter Product Price: ");
				Float pPrice = s.nextFloat();
				System.out.println("Enter Product Quantity: ");
				int pQty = s.nextInt();
				
				int k = stm.executeUpdate
						("insert into product44(pcode, pname, pprice, pqty) values('"+pCode+"','"+pName+"',"+pPrice+","+pQty+")");
				if(k>0)
				{
					System.out.println("Product Details added successfully...");
				}
				else
				{
					System.out.println("Failed to add product details");
				}
				break;
				
			case 2:
				//ViewProducts from table product44
				ResultSet rs = stm.executeQuery("select * from product44");
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
				}
				break;
			}
			s.close();
			con.close();
		}catch(Exception e) {e.printStackTrace();}
	}
}
