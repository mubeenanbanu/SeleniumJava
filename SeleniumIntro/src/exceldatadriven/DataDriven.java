package exceldatadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	public static ArrayList<String> GetExcelData() throws InterruptedException, IOException 
	{
		ArrayList<String> a=new ArrayList<String> ();

		FileInputStream file=new FileInputStream("C:\\Users\\mubeena\\Documents\\Book 1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		int sheets=workbook.getNumberOfSheets();
		System.out.println(sheets);
		for(int i=0;i<sheets-1;i++)
		{
			if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("tabledata"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				Row firstrow=rows.next();
				Iterator<Cell> cell=firstrow.cellIterator();
				int column=0;
				while(cell.hasNext())
				{
					Cell value=cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("testcases"))
					{
						break;
					}
					column++;
					
				}
				System.out.println(column);
				while(rows.hasNext())
				{
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Home"))
					{
						Iterator<Cell> value=r.cellIterator();
						while(value.hasNext())
						{
							a.add(value.next().getStringCellValue());
//							System.out.println(value.next().getStringCellValue());
						}
					}
							
				}
				
				
				
			}
		}
		return a;

	
	}
	
}
//Identify Testcases coloum by scanning the entire 1st row
//once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
//after you grab purchase testcase row = pull all the data of that row and feed into test
