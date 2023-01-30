package sage_inteview;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Uitility {
	
	
	public static ArrayList<String> getData() throws IOException{
		
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\test\\resources\\Sr.Automation Engineer.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(1);
		int last = sheet.getLastRowNum();
		ArrayList<String> al = new ArrayList<String>();
	
		for (int i = 1; i < last; i++) {
					al.add(String.valueOf(sheet.getRow(i).getCell(0).getRawValue()));
		}
		return al;
		
	}

}
