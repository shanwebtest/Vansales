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

public class DataDrivenRead_Write {
	public WebDriver driver = null;
	
	
	
	public void writeExcelFile(String filePath, String FileName,String SheetName, String[] dataTowrite) throws IOException {
		//create object of xl file
		
		
		File file = new File(filePath);
		FileInputStream inpustream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inpustream);
		//Read sheet inside the workbook by its name
		XSSFSheet sh = wb.getSheet("Sheet1");
		
		int rowcnt = sh.getLastRowNum()-sh.getFirstRowNum();
		
		 Row row = sh.getRow(0);// get first row of the sheet.
		
		 Row newRow = sh.createRow(rowcnt+1);  //Create a new row and append it at last of sheet
		//create loop over the cell of newly created row.		
		for(int i=1; i<row.getLastCellNum(); i++) {
			// fill data into cell
			  Cell cell = newRow.createCell(2);
			  cell.setCellValue(dataTowrite[1]);
			  
			  
			  
			
			//  Row row = sh.getRow(i);
			   String column1  = row.getCell(0).getStringCellValue();//get first column cell value
			   String column2  = row.getCell(1).getStringCellValue();// get 2nd column cell value
			   
			   System.out.println(column1+"-"+column2);
			   
			 // System.out.println(row.getCell(1).getStringCellValue());
			    
			    
			    // create loop to print cell values in a row.			  
			//  for(int j=0; j<row.getLastCellNum(); j++) {
				  // Print Excel data in console
				 // System.out.println(row.getCell(j).getStringCellValue()+"|| ");
				  
				  
			//  }			  
			  
			System.out.println();		
		}
		
		
		inpustream.close();//close Input stream
		
		// File output stream
		FileOutputStream fout = new FileOutputStream(file);
		wb.write(fout);  // write data into excel
		fout.close(); // close outputstream
		
	}
	
	
	@Test
	public void mainfunction() throws IOException {
		
		
		
		DataDrivenRead_Write datas = new DataDrivenRead_Write();
		
		String filePath = System.getProperty("user.dir")+"\\Excel\\TestData.xlsx";
		
		//Create an array with the data in the same order in which you expect to be filled in excel file

        String[] valueToWrite = {"Mr. T","Shanmugam"};
		
		//call and read file method of class to read data
		datas.writeExcelFile(filePath, "TestData.xlsx", "Sheet1", valueToWrite);
		
		
	}
	

}
