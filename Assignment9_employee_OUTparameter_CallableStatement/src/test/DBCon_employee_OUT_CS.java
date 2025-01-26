package test;
import java.util.*;
import java.sql.*;
/*
 Construct JDBC application to execute OUT-parameter procedure
 to display employee details based on eId
 *****Procedure*****
 	create or replace procedure retrieveEmployee44
    (a number,b OUT varchar2,c OUT varchar2,d OUT number,e OUT varchar2,f OUT varchar2,g OUT number,h OUT varchar2,i OUT number,j OUT number,k OUT number) is
    begin
       select ename, edesg into b,c from empdata44 where eid=a;
       select hno, sname, city, pincode into d,e,f,g from empaddress44 where eid=a;
       select mid,phno into h,i from empcontact44 where eid=a;
       select bsal,totsal into j,k from empsalary44 where eid=a;
    end;
    /
 */
public class DBCon_employee_OUT_CS 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","swapnil","swapnil");
			Scanner s = new Scanner(System.in);
			System.out.println("Enter eId: ");
			int eId = Integer.parseInt(s.nextLine());
			
			CallableStatement cs = con.prepareCall
					("{call RetrieveEmployee44(?,?,?,?,?,?,?,?,?,?,?)}");//compilation
			cs.setInt(1, eId);//a
			cs.registerOutParameter(2, Types.VARCHAR);//b
			cs.registerOutParameter(3, Types.VARCHAR);//c
			cs.registerOutParameter(4, Types.INTEGER);//d
			cs.registerOutParameter(5, Types.VARCHAR);//e
			cs.registerOutParameter(6, Types.VARCHAR);//f
			cs.registerOutParameter(7, Types.INTEGER);//g
			cs.registerOutParameter(8, Types.VARCHAR);//h
			cs.registerOutParameter(9, Types.BIGINT);//i
			cs.registerOutParameter(10, Types.INTEGER);//j
			cs.registerOutParameter(11, Types.DOUBLE);//k
			
			cs.execute();//execution
			System.out.println("Procedure executed successfully...");
			System.out.println("eId: "+eId);
			System.out.println("eName: "+cs.getString(2));
			System.out.println("eDesg: "+cs.getString(3));
			System.out.println("hNo: "+cs.getInt(4));
			System.out.println("sName: "+cs.getString(5));
			System.out.println("city: "+cs.getString(6));
			System.out.println("pinCode: "+cs.getLong(7));
			System.out.println("mailId: "+cs.getString(8));
			System.out.println("phoneNo: "+cs.getLong(9));
			System.out.println("Basic Salary: "+cs.getInt(10));
			System.out.println("Total Salary: "+cs.getDouble(11));
			s.close();
			con.close();
		}catch(Exception e) {e.printStackTrace();}
	}
}
