package exceldatadriven;

import java.io.IOException;
import java.util.ArrayList;

public class ExcelTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Exceldata d=new Exceldata();
		ArrayList<String> a=d.GetDataFromExcel();
		for(int i=0;i<a.size();i++)
		{
			System.out.println(a.get(i));
		}
	

	}

}
