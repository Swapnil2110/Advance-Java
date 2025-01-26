package test;
import java.util.*;
import java.sql.*;
/*
 Construct JDBC application to execute function to retrieve
 totSal of employee based on eId.
 ****Function****
 create or replace function RetrieveTotSal44
    (a number) return number as totsal number;
    begin
       select totsal into totsal from empsalary44 where eid=a;
       return totsal;
    end;
    /
 
 ****TABLE****
 select * from empsalary44;

       EID       BSAL     TOTSAL
---------- ---------- ----------
       101      12000      30720
       102      15000      38400
       103      13500      34560
 */

public class DBCon_employee_IN_function_CS10 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","swapnil","swapnil");
			Scanner s = new Scanner(System.in);
			System.out.println("Enter eId: ");
			int eId = s.nextInt();
			CallableStatement cs = con.prepareCall
					("{call ?:=RetrieveTotSal44(?)}");
			cs.registerOutParameter(1, Types.FLOAT);
			cs.setInt(2, eId);
			
			cs.execute();
			System.out.println("Employee ID: "+eId);
			System.out.println("Total Salary: "+cs.getFloat(1));
			
			s.close();
			con.close();
		}catch(Exception e) {e.printStackTrace();}
	}
}
