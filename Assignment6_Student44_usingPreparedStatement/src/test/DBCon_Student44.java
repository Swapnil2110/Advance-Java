package test;
import java.util.*;
import java.sql.*;
/*
 Construct JDBC application to perform the following operations
 based on user choice:
 1.AddStudent
 	read:
 		rollNo
 		stuName
 		branch
 		Six Subject marks
 	calculate:
 		totMarks
 		per
 		result
 2.ViewStudentByRollNo
 3.ViewAllStudents 
 */
public class DBCon_Student44 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl", "swapnil", "swapnil");
			Scanner s = new Scanner(System.in);
			System.out.println("Select from Following:\n1.AddStudentDetails\n2.ViewStudentByRollNo\n3.ViewAllStudents");
			int choice = Integer.parseInt(s.nextLine());
			switch(choice)
			{
			case 1:
				/*1.AddStudentDetails
					read:
 						rollNo
 						stuName
 						branch
 						Six Subject marks
				*/
				System.out.println("Enter Student Details: ");
				System.out.println("Enter rollNo: ");
				int rollNo = Integer.parseInt(s.nextLine());
				System.out.println("Enter stuName: ");
				String stuName = s.nextLine();
				System.out.println("Enter branch: ");
				String branch = s.nextLine();
				System.out.println("Enter 6 Subject Marks:");
				System.out.println("Enter marks of sub1: ");
				int sub1 = Integer.parseInt(s.nextLine());
				System.out.println("Enter marks of sub2: ");
				int sub2 = Integer.parseInt(s.nextLine());
				System.out.println("Enter marks of sub3: ");
				int sub3 = Integer.parseInt(s.nextLine());
				System.out.println("Enter marks of sub4: ");
				int sub4 = Integer.parseInt(s.nextLine());
				System.out.println("Enter marks of sub5: ");
				int sub5 = Integer.parseInt(s.nextLine());
				System.out.println("Enter marks of sub6: ");
				int sub6 = Integer.parseInt(s.nextLine());
				//calculate:totMarks, per, result
		 		if(	(sub1>=0&&sub1<=100) && (sub2>=0&&sub2<=100) && (sub3>=0&&sub3<=100) &&
		 			(sub4>=0&&sub4<=100) && (sub5>=0&&sub5<=100) && (sub6>=0&&sub6<=100)	)
		 		{
		 			int totMarks = sub1+sub2+sub3+sub4+sub5+sub6;
		 			float per = (float)totMarks/6;
		 			String result;
		 			if(per>=70 && per<=100)
		 			{
		 				result = "Distinction";
		 			}else if(per>=60 && per<70) {
		 				result = "First Class";
		 			}else if(per>=50 && per<60) {
		 				result = "Second Class";
		 			}else if(per>=35 && per<50) {
		 				result = "Third Class";
		 			}else {
		 				result = "Failed";
		 			}
		 			
		 			PreparedStatement ps1 = con.prepareStatement
		 				("insert into student44 values(?,?,?,?,?,?)");//compilation
		 			ps1.setInt(1, rollNo);
		 			ps1.setString(2, stuName);
		 			ps1.setString(3, branch);
		 			ps1.setInt(4, totMarks);
		 			ps1.setFloat(5, per);
		 			ps1.setString(6, result);
		 			
		 			int k = ps1.executeUpdate();
		 			if(k>0)
		 			{
		 				System.out.println("StudentDetails added successfully");
		 			}
		 		}
		 		else
		 		{
		 			System.out.println("Invalid Subject marks...");
		 		}
				
				break;
			case 2:
				//2.ViewStudentByRollNo
				PreparedStatement ps2 = con.prepareStatement
					("select * from student44 where rollno=?");
				
				System.out.println("Enter Student RollNo: ");
				rollNo = Integer.parseInt(s.nextLine());
				ps2.setInt(1, rollNo);
				ResultSet rs1 = ps2.executeQuery();
				if(rs1.next())
				{
					System.out.println("RollNo: "+rs1.getInt(1)+
								"\nStudentName: "+rs1.getString(2)+
								"\nBranch: "+rs1.getString(3)+
								"\nTotalMarks: "+rs1.getInt(4)+
								"\npercentage: "+rs1.getFloat(5)+
								"\nResult: "+rs1.getString(6));
				}
				break;
			case 3:
				//3.ViewAllStudent
				PreparedStatement ps3 = con.prepareStatement("select * from student44");
				ResultSet rs2 = ps3.executeQuery();
				System.out.println("ROLLNO \t STUNAME \t BRANCH \t TOTMARKS \t PER \t RESULT");
				while(rs2.next())
				{
					System.out.println(rs2.getInt(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t\t"+
									   rs2.getInt(4)+"\t\t"+rs2.getFloat(5)+"\t"+rs2.getString(6));
				}
				break;
			default:
				System.out.println("Invalid Choice...");
				break;
			}//end of switch
			
			s.close();
			con.close();
			
		}catch(Exception e) {e.printStackTrace();}
	}
}
