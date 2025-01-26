package maccess;

import java.util.*;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;



public class Emp3 
{
	private static final String NAME = "C:/Users/swapn/OneDrive/Desktop/Saurav/Employee_Details.xlsx";
	
	public static void main(String[] args)
	{
		Employee emp;
		try
		{
			FileInputStream file = new FileInputStream(new File(NAME));
			Workbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);
			
			Row row;
			for(int i=1; i<sheet.getLastRowNum(); i++)
			{
				row = sheet.getRow(i);
				
				String empNo;
				if(row.getCell(0) == null) {empNo = "0";}
				else {empNo = row.getCell(0).toString();}
				
				String empName;
				if(row.getCell(1) == null) {empName = "0";}
				else {empName = row.getCell(1).toString();}
				
				String dob;
				if(row.getCell(2) == null) {dob = "0";}
				else {dob = row.getCell(2).toString();}
				
				String desg;
				if(row.getCell(3) == null) {desg = "0";}
				else {desg = row.getCell(3).toString();}
				
				double mSal;
				if(row.getCell(4) == null) {mSal = 0;}
				else {mSal = Double.parseDouble(row.getCell(4).toString());}
				
				double aSal;
				if(row.getCell(5) == null) {aSal = 0;}
				else {aSal = Double.parseDouble(row.getCell(5).toString());}
				
				emp = new Employee();
				emp.setEmpNo(empNo);
				emp.setEmpName(empName);
				emp.setDob(dob);
				emp.setDesg(desg);
				emp.setmSal(mSal);
				emp.setaSal(aSal);
				
				int k = DBCon.insert(emp);
				if(k>0)
				{
					System.out.println("Successfully inserted...");
				}
				else
				{
					System.out.println("Not inserted...");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
