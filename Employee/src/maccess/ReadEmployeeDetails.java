	package maccess;
	
	import java.io.File;  
	import java.io.FileInputStream;  
	import java.util.Iterator;  
	import org.apache.poi.ss.usermodel.Cell;  
	import org.apache.poi.ss.usermodel.Row;  
	import org.apache.poi.xssf.usermodel.XSSFSheet;  
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import java.sql.*;
	
	public class ReadEmployeeDetails 
	{
		
		public static void main(String[] args)   
		{  
			try  
			{  
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","swapnil","swapnil");
				PreparedStatement ps1 = con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
				int count = 0;
				int batchSize = 20;
				File file = new File("C:\\Users\\swapn\\OneDrive\\Desktop\\Saurav\\Employee_Details.xlsx");   //creating a new file instance  
				FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
				//creating Workbook instance that refers to .xlsx file  
				XSSFWorkbook wb = new XSSFWorkbook(fis);   
				XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
				
				
				Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
				
				while (itr.hasNext())                 
				{  
					Row row = itr.next();  
					
					Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
					
					/*
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();
					*/
					
					while (cellIterator.hasNext())   
					{  
						Cell cell = cellIterator.next();  
						switch (cell.getColumnIndex())               
						{  
							/*
							case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
							System.out.print(cell.getStringCellValue() + "\t\t\t");  
							break;  
							
							case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
							System.out.print(cell.getNumericCellValue() + "\t\t\t");  
							break;  
							
							default:
							*/
						case 0:
							String empID = cell.getStringCellValue();
							ps1.setString(1, empID);
							
							
							
						case 1:
							String empName = cell.getStringCellValue();
							ps1.setString(2, empName);
						
							
						case 2:
							String dateofBirth = cell.getStringCellValue();
							ps1.setString(3, dateofBirth);
							
							
						case 3:
							String desg = cell.getStringCellValue();
							ps1.setString(4, desg);
							
							
						case 4:
							double ms = 100.00;//cell.getStringCellValue();
							ps1.setDouble(5, ms);
						
							
						case 5:
							double as = 200.00;//Double.parseDouble(cell.getStringCellValue());
							ps1.setDouble(6, as);
						
						}
						ps1.execute();
					} 
					
					
					//System.out.println("");  
				}  
			}  
			catch(Exception e)  
			{  
				e.printStackTrace();  
			}  
		}  
	}
