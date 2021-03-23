package test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import testapplication.baseClass;


public class Xls_Reader1 {
	public String path;
	public static FileInputStream fis = null;
	public static FileOutputStream fileOut = null;
	public static XSSFWorkbook workbook = null;
	static XSSFSheet sh = null;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;

	/*
	 * public Xls_Reader() throws IOException {
	 * 
	 * //write data to excell // row1=0; // name ="Test Shan";
	 * 
	 * 
	 * String exlfilepath = System.getProperty("user.dir"); FileInputStream fin =
	 * new FileInputStream(exlfilepath+"\\Excel\\TestResults.xlsx"); workbook = new
	 * XSSFWorkbook(fin); XSSFSheet sh = workbook.getSheetAt(0);
	 * 
	 * 
	 * 
	 * int rowcnt = sh.getLastRowNum(); //-sh.getFirstRowNum(); // int rowcnt =
	 * sh.getLastRowNum(); row = sh.getRow(0);
	 * 
	 * try { //Row newRow = sh.createRow(rowcnt+1); for(int k=0; k<rowcnt+1; k++) {
	 * // Fill data in row // cell = row.createCell(0); // cell.setCellValue(name);
	 * 
	 * // row = sh.getRow(k);
	 * 
	 * for(int j=0; j<row.getLastCellNum(); ) {
	 * 
	 * DataFormatter formatter = new DataFormatter();
	 * 
	 * String text = formatter.formatCellValue(sh.getRow(k).getCell(0)); String
	 * text1 = formatter.formatCellValue(sh.getRow(k).getCell(1));
	 * 
	 * Cell cell = row.createCell(2); cell.setCellValue("ok");
	 * 
	 * System.out.println("1st Row "+text); System.out.println("2st Row "+text1);
	 * break; // String tex = row.getCell(j).getStringCellValue(); // String tex1 =
	 * row.getCell(j).getStringCellValue(); //
	 * System.out.println("Print value of excel "+ tex + tex1);
	 * 
	 * 
	 * }
	 * 
	 * //fin.close(); }
	 * 
	 * 
	 * fileOut = new FileOutputStream(exlfilepath+"\\Excel\\TestResults.xlsx");
	 * workbook = new XSSFWorkbook(); // sh = workbook.createSheet("output");
	 * 
	 * // row =sh.createRow(0); // Cell name = row.createCell(0); //
	 * name.setCellValue("Pass");
	 * 
	 * 
	 * 
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * workbook.write(fileOut); // workbook.close(); // fileOut.close(); }
	 * 
	 */
	
	public  Xls_Reader1(String filepath, String SheetName) throws IOException {
				 
		  FileInputStream fin = new FileInputStream(filepath);
		  workbook = new XSSFWorkbook(fin);
		  sh = workbook.getSheet(SheetName);	
	}
	
	
	public static int getRowcount() {
		
		int rowcnt=0;
		try {
			rowcnt = sh.getPhysicalNumberOfRows();
			System.out.println("Number of Rows :"+rowcnt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowcnt;
		
	}
	public static int getColcount() {
		
		int colcnt=0;
		try {
			colcnt = sh.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of Columns :"+colcnt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return colcnt;
		
	}
	
	
	@Test
	public Object readData(int CellNum) throws IOException {	
	    
          int rcnt = sh.getPhysicalNumberOfRows();
       
          getRowcount();
          getColcount();
            
			
			for(int i=1; i<=rcnt; i++) {
			        
			XSSFRow rcnt1 = sh.getRow(i); 
			if(rcnt1==null)
			{ break; }
			System.out.println(rcnt1.getCell(CellNum).getStringCellValue());
			System.out.println(rcnt1.getCell(CellNum).getStringCellValue());
			
			
			 }
			  
		return rcnt ;
		
	}
	
	
	
	
	
	  
	  public static String getCellData(int rowNumber,int cellNumber){ //getting the cell
	    // value from rowNumber and cell Number 
	    cell =sh.getRow(rowNumber).getCell(cellNumber);
	  
	   // returning the cell value as string 
	    return cell.getStringCellValue();
	 
	  }
	  
	  public int getRowCountInSheet() { 
		  int rowcount = sh.getLastRowNum()-sh.getFirstRowNum();
	      return rowcount; 	  
	  }
	  
		/*
		 * public static Object setCellData(int rnum,int clnum) {
		 * 
		 * cell = sh.getRow(rnum).createCell(clnum); cell.setCellValue("pass"); // row =
		 * sh.getRow(rowNumber); // cell = row.createCell(cellNumber); //
		 * cell.setCellValue("pass"); return clnum;
		 * 
		 * 
		 * 
		 * // setCellValue(0, 0, path, path); }
		 */
	  
		/*
		 * @SuppressWarnings("null") public static void setCellValue(String
		 * filepath,String SheetName ) throws IOException { //creating a new cell in row
		 * and setting value to it Xls_Reader1 callcon = new
		 * Xls_Reader1(filepath,SheetName);
		 * 
		 * int r = getRowcount(); int cl = getColcount();
		 * 
		 * 
		 * // sh.getRow(rowNum).createCell(cellNum).setCellValue("pass");
		 * 
		 * FileOutputStream outputStream = new FileOutputStream(filepath);
		 * workbook.write(outputStream);
		 * 
		 * return; }
		 */
	  
	 // array object to get row and column number and  store cell value in array object and return it.  
	 public static Object[][] getData(String filepath, String SheetName) throws IOException {
		 
		  Xls_Reader1 data = new Xls_Reader1(filepath, SheetName);
		 
		 int r = getRowcount();
		 int cl = getColcount();
		 
		 Object data1[][] = new Object[r-1][cl];
		 
		 for(int i=1; i<r; i++ ) {
			 
			 for(int j =0; j<cl; j++) {
				 
				// DataFormatter formatter = new DataFormatter();
				 String value = getCellData(i, j);
				// String text = formatter.formatCellValue(value);
				
				 data1[i-1][j] = value;
				 System.out.println("cell value "+value);
				 
			 }
			 
		 }	
		return data1; 		 
  }

	 
	 
	public boolean WriteResult(String Sheet,  int Row, String Col, String Results) throws IOException {
		
		int rowNum = getRowcount();
					
		int colNum = getColcount();

		XSSFRow Suiterow = sh.getRow(0);
		
		for(int j=0; j<=colNum-1; j++) {
			
			if(Suiterow.getCell(j).getStringCellValue().contains(Results)) {
				
				colNum =j;
			}
			
		}
		
		XSSFRow rw = sh.getRow(rowNum);
		XSSFCell cell = rw.getCell(colNum);
		if(cell==null) {
			cell = rw.createCell(colNum);
			cell.setCellValue(Results);
		}
		
		
		fileOut  = new FileOutputStream(baseClass.filepaths());
		workbook.write(fileOut);
		fileOut.close();
		
		return false;
		
		
	}
	 
	 
	 
	/*
	 * // array object to get row and column number and store cell value in array
	 * object and return it. public static Object[][] setData(String filepath,
	 * String SheetName ) throws IOException {
	 * 
	 * 
	 * 
	 * int r = getRowcount(); int cl = getColcount();
	 * 
	 * Object data[][] = new Object[r-1][cl];
	 * 
	 * for(int i=1; i<r; i++ ) {
	 * 
	 * for(int j =0; j<cl; j++) {
	 * 
	 * 
	 * data[i-1][j] = setCellData(i, j); // System.out.println("cell value "+value);
	 * 
	 * }
	 * 
	 * } return data; }
	 */
	 
	 
	 
	 
	 
	 

}

