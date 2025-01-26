package maccess;
//correct
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Emp2 
{
	private static final String NAME = "C:/Users/swapn/OneDrive/Desktop/Saurav/Employee_Details.xlsx";
	
	public static void main(String[] args)
	{
		try 
		{
			FileInputStream file = new FileInputStream(new File(NAME));
			Workbook workbook = new XSSFWorkbook(file);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator sheets = workbook.sheetIterator();
			
			while(sheets.hasNext())
			{
				Sheet sh = (Sheet)sheets.next();
				System.out.println("Sheet name is "+sh.getSheetName());
				System.out.println("-----------");
				Iterator<Row> iterator = sh.iterator();
				
				while(iterator.hasNext())
				{
					Row row = iterator.next();
					Iterator<Cell> cellIterator = row.iterator();
					while(cellIterator.hasNext())
					{
						Cell cell = cellIterator.next();
						String cellValue = dataFormatter.formatCellValue(cell);
						System.out.print(cellValue+"\t"/*+cellValue.getClass().getSimpleName()*/);
					}
					System.out.println();
				}
				
			}
			workbook.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
