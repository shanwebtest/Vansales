package Masters;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testapplication.baseClass;
import Transactions.Transaction_Base;

public class MenuNavigations extends baseClass {
	
	Transaction_Base menu = new Transaction_Base();
	String TestCaseName = null;
	

  @BeforeTest
  public void beferetest() throws IOException {
	  
	  init();
	 // test = extent.createTest("Menu Navigation");
	  startdriver("Chrome");
	  loginapp();
	  TestCaseName = this.getClass().getSimpleName();
	  
  }
	
 // @Test
  public void Mastermenuclick() throws InterruptedException, IOException {
	  
	  try {
		WebElement ele = getElementByXpath("//*[@id=\"loadingmask\"]/img");
		  if(ele.isDisplayed()) {
			 // driverwait(By.tagName("title")).getText().contains("Home");
			  
			 // test = extent.createTest(TestCaseName.getClass().getName(),"Executed");
			  test = extent.createTest("Master Menu Navigation");
		          menu.main_Sub_menu_click("Master", "Van");
	
		          driver.findElement(By.id("createNewRecordButton")).click();
		
		          asserts.assertEquals("VanSales - Van List", getPagetitle());
		          
		         menu.main_Sub_menu_click("Master","Device");
		    
		         menu.main_Sub_menu_click("Master", "Salesman Outlet Mapping");
		
		         menu.main_Sub_menu_click("Master", "Team");
			
			      menu.main_Sub_menu_click("Master", "Approval Workflow");
		
				  menu.main_Sub_menu_click("Master", "Shelf Rent");
				    
				  menu.main_Sub_menu_click("Master", "Customer Code");
				   
				  
				  Actions act = new Actions(driver);
				  WebElement ele1 = driver.findElement(By.xpath("//button[@class='k-button']"));
				  act.moveToElement(ele1).build();		
				   Thread.sleep(500);
				  act.click();
				  
				  JavascriptExecutor js = (JavascriptExecutor)driver;
				  js.executeScript("arguments[0].click();", ele1);
				  
				  //  Alert alert = driver.switchTo().alert();
				  
				//	alert.accept();
				//  baseClass.driver.get("http://103.102.97.210:8352/Home/Index");
			
			   //  menu.Main_Sub_menu_click("Master");
				  Thread.sleep(2000);
			     menu.Main_Sub_Sub_menu_click("Master","Item Details","Item");
			     asserts.assertEquals("VanSales - Item List", getPagetitle());
			     menu.Main_Sub_Sub_menu_click("Master","Item Details","Outlet Discount");
			     menu.Main_Sub_Sub_menu_click("Master","Item Details","Free Item");			     
			     menu.Main_Sub_Sub_menu_click("Master","Item Details","Brand");
			     menu.Main_Sub_Sub_menu_click("Master","Item Details","Category");
			     menu.Main_Sub_Sub_menu_click("Master","Item Details","Discount");
				
				menu.Main_Sub_Sub_menu_click("Master","Field Activities","Route");
				menu.Main_Sub_Sub_menu_click("Master","Field Activities","Route Pattern");
				menu.Main_Sub_Sub_menu_click("Master","Asset Details","Asset Brand");
				
				  
					 
				
			    logger.info("menu click executed");			  
			  			  
			  
		  }
		 
	} catch (InterruptedException e) {
		//WebElement ids = getElementByID("extAlertDialog");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		  menu.Main_Sub_Sub_menu_click("Master","Item Details","Brand");
		  logger.info("menu click executed");
	}
	  
	  
	 
	  
  }
  
  @Test
  public void TransactionMenuClick() throws InterruptedException, IOException {
	  
	  test = extent.createTest("Transaction Menu Navigation");
	 // test = extent.createTest(TestCaseName.getClass().getName(),"Executed");
	  baseClass.driver.get("http://103.102.97.210:8352/Home/Index");
	  
	  menu.main_Sub_menu_click("Transaction", "Document Sequence");
	  menu.main_Sub_menu_click("Transaction", "Document Sequence");
	  menu.main_Sub_menu_click("Transaction", "Invoice");	
	  menu.main_Sub_menu_click("Transaction", "Asset Mapping");	
	  menu.main_Sub_menu_click("Transaction", "Van Load Request");	
	  menu.main_Sub_menu_click("Transaction", "Mobile Lock");	
	  menu.main_Sub_menu_click("Transaction", "Van Unload Request");	
	  menu.main_Sub_menu_click("Transaction", "Van Load Request");		  
	  menu.main_Sub_menu_click("Transaction", "Return");	
	  menu.main_Sub_menu_click("Transaction", "Invoice Return");
	  menu.main_Sub_menu_click("Transaction", "Outlet Credit Due Collection");
	  menu.main_Sub_menu_click("Transaction", "Cash Receipt");
	  menu.main_Sub_menu_click("Transaction", "Production");
	  menu.main_Sub_menu_click("Transaction", "Endorsment");
	  
	  
	  
	    
	  menu.Main_Sub_Sub_menu_click("Transaction","Approval","Van Load Approval");
	  
	  menu.main_Sub_menu_click("Report", "Daily Sales Summary Report");	  
	  menu.Main_Sub_Sub_menu_click("Report","Other Reports","Outlet Report");
	  
	  menu.main_Sub_menu_click("Template", "Import Template");
	 
	  menu.main_Sub_menu_click("Tools", "Error Log");
		 
	  
	  
	  
  }
  
  
  
  
  
  
  
  
  @AfterMethod
  public void LogExtentReport(ITestResult result) throws IOException {
	  
	  
	
	  
	  if(result.getStatus()== ITestResult.FAILURE) {
		  
		  String screenShotPath = getScreenshot();
		  test.log(Status.FAIL,result.getThrowable());
		  test.generateLog(Status.FAIL, "Snapshot below"+test.addScreenCaptureFromPath(screenShotPath));		  
	  }
	  
  }
  
  
  @AfterTest
  public void closebrowser() throws IOException {
		/*
		 * ITestResult result if(result.getStatus()== ITestResult.FAILURE) {
		 * 
		 * String screenShotPath = getScreenshot();
		 * test.log(Status.FAIL,result.getThrowable()); test.generateLog(Status.FAIL,
		 * "Snapshot below"+test.addScreenCaptureFromPath(screenShotPath)); }
		 */
	  
	  extent.flush();	
	  baseClass.driver.close();
	  baseClass.driver.quit();
	  
  }
  
  
  
  
}
