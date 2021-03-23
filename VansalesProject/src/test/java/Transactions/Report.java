package Transactions;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Report extends testapplication.baseClass {
	
	 Transaction_Base trans = new Transaction_Base();
	// public static String tesapp = "http://103.102.97.210:8165/";  
	 
	 @BeforeTest
	 public void beforetest() {
		
		 startdriver("chrome");
		 loginapp();
		 test = extent.createTest("Report");
		
	 }
	 
	 @Test
	  public void JournyPlanReport() throws InterruptedException, IOException {		 
		 
	
	 	 test.info("Report menu click start");
	 	 trans.main_Sub_menu_click("Report","Journey Plan Report");
	 	
		// trans.Main_Sub_menu_click("Report");
		 String title = "VanSales - Journey Plan Report";
		 System.out.println("page : "+getPagetitle());
		 if(title.contains(getPagetitle())) {
			 test.pass(this.getClass().getName());
			 Assert.assertEquals(title, getPagetitle());
		 }
		 else {
			 test.fail(this.getClass().getName());
			 Assert.assertEquals(title, getPagetitle());
		 }
		 
	 	 
		 test.info("Report menu click Completed");
		 
	   }
	 
	 @Test
	 public void InvoiceReport() throws InterruptedException, IOException {
		trans.Main_Sub_Sub_menu_click("Report", "Sales Reports", "Invoice Report");
	 
	 String title = "VanSales - Invoice Report";
	 
	 if(title.contentEquals(getPagetitle())) {
		 test.pass(this.getClass().getSimpleName());
		 Assert.assertEquals(title, getPagetitle());
		 	 }
	 else {
		 test.fail(this.getClass().getSimpleName());
		 Assert.assertEquals(title, getPagetitle());
	 }
	 
 	 
	 test.info("Report menu click Completed");
	 
	 }
	 
	 
	// @AfterMethod
	 public void getResult(ITestResult result) throws IOException {
		 
		 if(result.getStatus() == ITestResult.FAILURE) {
			 
			 String screenShotPath = getScreenshot();
			 test.log(Status.FAIL,result.getThrowable());
			 test.generateLog(Status.FAIL, "Snapshot below"+test.addScreenCaptureFromPath(screenShotPath));
		 }
		 
		
			 
	 }
	 
	 
	 @AfterTest
	 public void Close()
	    {
	
	        
	  //      extent.flush();
	  //      driver.close();
	  //      driver.quit();
	    }
	 
	
	 
  
   
}
