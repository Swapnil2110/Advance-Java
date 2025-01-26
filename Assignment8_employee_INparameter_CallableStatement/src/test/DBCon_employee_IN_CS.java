package test;
import java.util.*;
import java.sql.*;
/*
 Construct JDBC application to execute IN Parameter procedure to 
 update DB Tables.
 DB-Tables:
 	EmpData44(eid, ename, edesg)
 				a   b       c
 	EmpAddress44(eid, hno, sname, city, pincode)
 				  a    d     e      f      g	
 	EmpContact44(eid, mid, phno)
 				  a    h    i
 	EmpSalary44(eid, bsal, totsal)
 				  a    j     k
 	*****procedure*****
 	create or replace procedure createEmployee44
    (a number, b varchar2, c varchar2, d number, e varchar2, f varchar2, g number, h varchar2, i number, j number, k number) is
    begin
       insert into empdata44 values(a,b,c);
       insert into empaddress44 values(a,d,e,f,g);
       insert into empcontact44 values(a,h,i);
       insert into empsalary44 values(a,j,k);
    end;
    /
 */
public class DBCon_employee_IN_CS 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","swapnil","swapnil");
			Scanner s = new Scanner(System.in);
		    //take input from user
			System.out.println("Enter eId: ");
			int eId = Integer.parseInt(s.nextLine());
			System.out.println("Enter eName: ");
			String eName = s.nextLine();
			System.out.println("Enter eDesg: ");
			String eDesg = s.nextLine();
			System.out.println("Enter hNo: ");
			int hNo = Integer.parseInt(s.nextLine());
			System.out.println("Enter sName: ");
			String sName = s.nextLine();
			System.out.println("Enter city: ");
			String city = s.nextLine();
			System.out.println("Enter pinCode: ");
			int pinCode = Integer.parseInt(s.nextLine());
			System.out.println("Enter mId: ");
			String mId = s.nextLine();
			System.out.println("Enter phNo: ");
			long phNo = Long.parseLong(s.nextLine());
			System.out.println("Enter bSal: ");
			int bSal = Integer.parseInt(s.nextLine());
			//calculate totsal=bsal+HRA+DA
			//		HRA=bSal*0.93
			//		DA=bSal*0.63
			double totSal = bSal +(bSal* 0.93) + (bSal* 0.63);
			CallableStatement cs = con.prepareCall
					("{call CreateEmployee44(?,?,?,?,?,?,?,?,?,?,?)}");//compilation
			cs.setInt(1, eId);//a
			cs.setString(2, eName);//b
			cs.setString(3, eDesg);//c
			cs.setInt(4, hNo);//d
			cs.setString(5, sName);//e
			cs.setString(6, city);//f
			cs.setInt(7, pinCode);//g
			cs.setString(8, mId);//h
			cs.setLong(9, phNo);//i
			cs.setInt(10, bSal);//j
			cs.setDouble(11, totSal);//k
			
			cs.execute();
			System.out.println("Employee details entered successfully...");
			s.close();
			con.close();
		}catch(Exception e) {e.printStackTrace();}
	}
}
