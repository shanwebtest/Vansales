package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testapplication.baseClass;

public class DataExtraction {
public WebDriver driver = null;
	
String urls = "https://www.sdb.k12.wi.us/Domain/259";
String urls2 = "https://www.janesville.k12.wi.us/about-us/directory";
  String seleclocation = "FRUZEN";
  
  XSSFWorkbook wb;
  FileOutputStream fout;
  Cell cell;
  
  //CONVERSE, EVEN START ,FRUZEN
	@BeforeTest
	public void beforetest() throws IOException {
		
		    baseClass.startdriver("chrome");
			baseClass.driver.get(urls);
		//readData();
	}
 	 
	
  //@Test
  public void getinfo() {
	  
	  List<WebElement> ele = baseClass.driver.findElements(By.className("staffname"));
	  int cnt = ele.size();
	  
	  List<WebElement> jobele = baseClass.driver.findElements(By.className("staffjob"));
	  int cnt1 = jobele.size();
	  
	  List<WebElement> contele = baseClass.driver.findElements(By.className("bb-icon-ultra-mail"));
	  int cnt2 = contele.size();
	  
	  
	  for(int i =1; i<=cnt-1; i++) {
		  
		  for(int j =1; j<=cnt1-1; j++) {
			  
			    for(int k=1; k<=cnt2-1; k++) {
			    	
			    //  WebElement ele1 = baseClass.driver.findElement(By.xpath("/html/body/div[4]/main/section/div/div/div/div[1]/div[2]/div/div/div/div[2]/div[8]/div[1]/ul/li[2]"));
					//  String job = baseClass.driver.findElement(By.className("staffjob")).getText();
					//  String email = baseClass.driver.findElement(By.className("bb-icon-ultra-mail")).getText();
					  
					  String name = ele.get(i).getText();
					  String job1 = jobele.get(j).getText();
					  String email1 = contele.get(k).getText();
					  
					  System.out.println("--> "+name+"-"+job1+"-"+email1);
					 
					//  System.out.println("print all the tag-->"+ele.get(i).getText()+"-"+job+ "-"+email);
			    
			    }
			  
		  }
		  
		
		  
	  }
	  
 
	  
	  
  }
  
  @Test
  public void testapp() throws InterruptedException, IOException {
	  //List<WebElement> ele = baseClass.driver.findElements(By.className("staffname"));
//	  int cnt = ele.size();
	//  List<WebElement> jobele = baseClass.driver.findElements(By.className("staffjob"));
	//  int cnt1 = jobele.size();
	  
	//  List<WebElement> contele = baseClass.driver.findElements(By.className("bb-icon-ultra-mail"));
	 // int cnt2 = contele.size();

	  // get list of page number
	  
	  Thread.sleep(1500);
	  baseClass.driver.findElement(By.id("selectedddlFilterLocation4327")).click();
	  
	  //
	  List<WebElement> loc = baseClass.driver.findElements(By.cssSelector("#ddlFilterLocation4327>li"));
	   int loccnt = loc.size();
	   
	   for(int l=0; l<=loccnt-1; l++) {
		   
		   String lname = loc.get(l).getText();
		   if(lname.contentEquals(seleclocation)) {
			   
			   loc.get(l).click(); // 
			   break;
		   }
		   
		  // baseClass.driver.findElement(By.cssSelector("#ddlFilterLocation4327 > li:nth-child(3)")).click();
	   }
	  
	 
	  
	  Thread.sleep(1000);
	 // Select select = new Select(baseClass.driver.findElement(By.id("selectedddlFilterLocation4327")));
	 // select.selectByValue("BELOIT LEARNING");
	  baseClass.driverwait(By.cssSelector(".bb-butt"));
	  baseClass.driver.findElement(By.cssSelector(".bb-butt")).click();
	  
	  Thread.sleep(1500);
	  
	  String SelecLoc = baseClass.driver.findElement(By.id("selectedddlFilterLocation4327-text")).getText();
	  System.out.println("<----------------Selected Location --------------------->"+SelecLoc);
	  
	  
	  
	  List<WebElement> pagn = baseClass.driver.findElements(By.cssSelector("#ui-paging-container>ul>li"));
	  	  int pgesize = pagn.size();
	  	  
	  	
	  
	  System.out.println("page count "+pgesize);
	
	
	  
	  for(int p=0; p<=pgesize-1;p++) {		  
	  	  //baseClass.driver.navigate().refresh();
		  //click on the page number button
		  
		  
		  
		  baseClass.driver.findElement(By.xpath("//div[4]/div/ul/li["+(p+1)+"]/a")).click();
	  	  Thread.sleep(2000);
		  
		  List<WebElement> ele1 = baseClass.driver.findElements(By.className("staffname"));
		  int cnt = ele1.size();
		  System.out.println("Number of Records in this page Number "+p+"is ="+cnt);
		  List<WebElement> jobele = baseClass.driver.findElements(By.className("staffjob"));
		//  int cnt1 = jobele.size();
		  
		  List<WebElement> contele = baseClass.driver.findElements(By.className("bb-icon-ultra-mail"));
		 // int cnt2 = contele.size();
		  
		  
		  
		  
	  
	     for(int i =0; i<=cnt-1; i++) {
			   
	    	 
					  String name = ele1.get(i).getText();
					  String job1 = jobele.get(i).getText();
					  String email1 = contele.get(i).getText();
					  
					  System.out.println("--> "+name+" ==> "+job1+" ==> "+email1);
					 
				
				
					  writeData(name, job1, email1);
					   
					  
					  //sh.getRow(i).createCell(1).setCellValue(name);
					  
					 
						  
					
					 
	              
	        
	          // scroll down to the bottom of the page(Vertical)
	       JavascriptExecutor js = (JavascriptExecutor) baseClass.driver;
	       js.executeScript("window.scrollBy(0,5000)");
		   Thread.sleep(1000);
	       }
	      
	      
	  }
	  
		// execute this part when single page is available     
	   if(pagn.isEmpty()) {
				  String p  = "Single page only";
				  List<WebElement> ele11 = baseClass.driver.findElements(By.className("staffname"));
				  int cnt1 = ele11.size();
				  System.out.println("Number of Records in this page Number "+p+"is ="+cnt1);
				  List<WebElement> jobele1 = baseClass.driver.findElements(By.className("staffjob"));
				//  int cnt1 = jobele.size();
				  
				  List<WebElement> contele1 = baseClass.driver.findElements(By.className("bb-icon-ultra-mail"));
				 // int cnt2 = contele.size();
				  
				  
				  
				  
			  
			     for(int i1 =0; i1<=cnt1-1; i1++) {
					   
			    	 
							  String name1 = ele11.get(i1).getText();
							  String job11 = jobele1.get(i1).getText();
							  String email11 = contele1.get(i1).getText();
							  
							  
							  
							  System.out.println("--> "+name1+" ==> "+job11+" ==> "+email11);
							 
						
						
							  writeData(name1, job11, email11);
							   									  
							  //sh.getRow(i).createCell(1).setCellValue(name);
		  		  
		  		  
		  	  }	    			  
			  
				    	//  fin.close(); 
				   //	   fout = new FileOutputStream(exlfilepath+"\\Excel\\TestResults.xlsx");
				   	  
	   }
		   
	  
	  
	  
	  
	  
	//  wb.write(fout); 
	//  fout.flush();
	//  fout.close();
  }
  
 // @Test
  public void readData() throws IOException {
	  //getExcel file path and attach to file input stream object; 
	  String exlfilepath = System.getProperty("user.dir");
	  FileInputStream fin = new FileInputStream(exlfilepath+"\\Excel\\TestResults.xlsx");
	  XSSFWorkbook wb = new XSSFWorkbook(fin);
	  XSSFSheet sh = wb.getSheetAt(0);
	  
	  int rowcnt = sh.getLastRowNum();
	  
	  for(int i= 0; i<=rowcnt; i++) {
		  
		  //get the total cell count from the excell sheet
		  int cellcnt = sh.getRow(i).getLastCellNum();		  
		     for(int j=0; j<=cellcnt-1; j++) {
		    	 
		    	 String value = sh.getRow(i).getCell(j).getStringCellValue();
		    	 
		    	 System.out.println(value);
		    	 
		     }		
	  }	  
  }
  

  public void writeData(String name, String loc, String email) throws IOException {
	  
	  String exlfilepath = System.getProperty("user.dir");
	  
	  FileInputStream fin = new FileInputStream(exlfilepath+"\\Excel\\TestResults.xlsx");
	  XSSFWorkbook wb = new XSSFWorkbook(fin);
	  
	 
	  
	  XSSFSheet sh = wb.getSheet("Sheet2");  
	  int rowcnt = sh.getLastRowNum()-sh.getFirstRowNum();
	    // Row row = sh.createRow(0);// get first row of the sheet , it can be used for sequential data read.
	  
	  Row newRow = sh.createRow(rowcnt+1);    //Create a new row and append it at last of sheet
	  
	 //   for(int i=0;i<row.getLastCellNum(); i++) {
	    	
	          
	    	  Cell cell = newRow.createCell(0);
	    	  cell.setCellValue(name);
	    	  
	    	  Cell cell1 = newRow.createCell(1);
	    	  cell1.setCellValue(loc);
	    	  
	    	  Cell cell2 = newRow.createCell(2);
	    	  cell2.setCellValue(email);
	    	//  row.createCell(0).setCellValue(name);
	     	//  row.createCell(1).setCellValue(loc);
	   	     
	    	
	  //  }
	    
	    
	  
	  
	  
	 
	  
	  
	 // sh.getRow(1).createCell(1).setCellValue("data to check");
	  
	//define the position in the excel sheet where write operation needs to perform
	//  Row rw = sh.createRow(2);
	//  Cell cl =rw.createCell(1);
	  //define input type
	 // cl.setCellType(CellType.STRING);
	//  cl.setCellValue("shan test");
	  
	 
	  try {
		    FileOutputStream fout = new FileOutputStream(exlfilepath+"\\Excel\\TestResults.xlsx");
			wb.write(fout);			
			fout.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	 
  }
  
  
  
  @AfterTest
  public void quit() throws IOException {
	  

	 
	 baseClass.driver.close();
	 baseClass.driver.quit();
  }
  
  
  
}
