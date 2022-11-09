package exceldatadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestSampleDataDriven {

	public static void main(String[] args) throws InterruptedException, IOException  {
		// TODO Auto-generated method stub
		DataDriven g=new DataDriven();
		ArrayList<String> a=g.GetExcelData();
		System.out.println(a.get(0));
		
	

	

	}
}
