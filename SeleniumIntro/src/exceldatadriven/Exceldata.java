package exceldatadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exceldata {

	
	
	
	@Test(dataProvider="GetData")
	public void Printdata(String user,String pwd,String id)
	{
		System.out.println(user+pwd+id);
		
	}
	@DataProvider
	public static Object[][] GetData() throws IOException {
		// TODO Auto-generated method stub
		DataFormatter format=new DataFormatter();	
		FileInputStream fis=new  FileInputStream("C:\\Users\\mubeena\\Documents\\Book excel.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		int rowcount=sheet.getPhysicalNumberOfRows();
		java.util.Iterator<Row> rows=sheet.iterator();
		XSSFRow firstrow=sheet.getRow(0);
		
		int columncount=firstrow.getPhysicalNumberOfCells();
		Object data[][]= new Object[rowcount-1][columncount];
		for(int i=0;i<rowcount-1;i++)
		{
			Row row=sheet.getRow(i+1);
			for(int j=0;j<columncount;j++)
			{
				

				data[i][j]=format.formatCellValue(row.getCell(j));
				
			}
		}

		return data;
	
	}

	
	public static ArrayList<String> GetDataFromExcel() throws IOException {
		// TODO Auto-generated method stub
		DataFormatter format=new DataFormatter();
		ArrayList<String> a=new ArrayList<String>();
	
		FileInputStream fis=new  FileInputStream("C:\\Users\\mubeena\\Documents\\Book excel.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		int rowcount=sheet.getPhysicalNumberOfRows();
		java.util.Iterator<Row> rows=sheet.iterator();
		Row firstrow=rows.next();
		int columncount=firstrow.getPhysicalNumberOfCells();
		
		for(int i=0;i<rowcount-1;i++)
		{
			Row row=rows.next();
			for(int j=0;j<columncount;j++)
			{
				
//				System.out.println(row.getCell(j));
//				a.add(format.formatCellValue(row.getCell(j)));
//				System.out.println(format.formatCellValue(row.getCell(j)));
			}
		}
		return a;
	
		

	}
	


}
