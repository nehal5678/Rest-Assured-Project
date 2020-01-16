package restassuredAssnt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FinalTest {
	@Test
	public void test() throws EncryptedDocumentException, IOException{
		
		ClassLoader cl=this.getClass().getClassLoader();
		FileInputStream file= new FileInputStream(cl.getResource("nehalExcelSheet.xlsx").getFile());
		
		Workbook wb=WorkbookFactory.create(file);
		
		Sheet sheet =  wb.getSheetAt(0);
		int rs = sheet.getFirstRowNum();
		int re=sheet.getLastRowNum();
		
		for(int i=rs+1;i<=re;i++) {
			
			Row row = sheet.getRow(i);
			
			String request=row.getCell(0).getStringCellValue();
			String Url=row.getCell(1).getStringCellValue();
			int expected=(int) row.getCell(2).getNumericCellValue();
			
			int actual=Helper.help(request,Url);
			Assert.assertEquals(actual, expected);
			
	}
}

}

