package testapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DataDrivenTest {
	public WebDriver driver = null;
	
	
	
	@SuppressWarnings("resource")
	public void readExcelFile(String filePath, String FileName,String SheetName) throws IOException {
		//create object of xl file
		
		
		File file = new File(filePath);
		FileInputStream inpustream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inpustream);
		//Read sheet inside the workbook by its name
		XSSFSheet sh = wb.getSheet("Sheet1");
		
		int rowcnt = sh.getLastRowNum()-sh.getFirstRowNum();
		
		//create loop over all ther rows of excel file
		
		for(int i=1; i<rowcnt+1; i++) {
			
			  Row row = sh.getRow(i);
			  
			  
			   String column1  = row.getCell(0).getStringCellValue();//get first column cell value
			   String column2  = row.getCell(1).getStringCellValue();// get 2nd column cell value
			   
			   
			   
			   System.out.println(column1+"-"+column2);
			   
			   Cell cell = row.createCell(2);
			   cell.setCellValue("pass");
			   
			   
			 // System.out.println(row.getCell(1).getStringCellValue());
			    
			    
			    // create loop to print cell values in a row.			  
			  for(int j=0; j<row.getLastCellNum(); j++) {
				  // Print Excel data in console
				 // System.out.println(row.getCell(j).getStringCellValue()+"|| ");
				  
				  
			  }
			  
			  
			System.out.println();
			
		}
		
		
		 FileOutputStream fout = new FileOutputStream(filePath);
		
		 wb.write(fout); 
		// wb.close();
		 fout.close();
		
		
	}
	
	
	@SuppressWarnings("resource")
	@Test
	public void mainfunction() throws IOException {
		
		DataDrivenTest datas = new DataDrivenTest();
		String filePath = System.getProperty("user.dir")+"\\Excel\\TestData.xlsx";
		
		//call and read file method of class to read data
		datas.readExcelFile(filePath, "TestData.xlsx", "Sheet1");
		
		
		
		
	}
	

}
