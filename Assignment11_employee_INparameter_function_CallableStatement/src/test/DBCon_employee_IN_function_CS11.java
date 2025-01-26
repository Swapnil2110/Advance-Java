package test;
import java.util.*;
import java.sql.*;
/*
 construct JDBC application to execute function to display
 result of student based on rollno
 
 ****FUNCTION****
 create or replace function DisplayResult44
    (a number) return varchar2 as rslt varchar2(242);
    begin
       select result into rslt from student44 where rollno=a;
       return rslt;
    end;
    /
 */

public class DBCon_employee_IN_function_CS11 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","swapnil","swapnil");
			Scanner s = new Scanner(System.in);
			System.out.println("Enter student roll no.: ");
			int rollNo = s.nextInt();
			CallableStatement cs = con.prepareCall("{call ?:=DisplayResult44(?)}");
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, rollNo);
			
			cs.execute();//execution
			System.out.println("Student RollNo: "+rollNo);
			System.out.println("Result: "+cs.getString(1));
			s.close();
			con.close();
		}catch(Exception e){e.printStackTrace();}
	}
}
