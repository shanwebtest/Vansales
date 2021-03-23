package Transactions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import test.Xls_Reader1;





public class TransferAsset extends testapplication.baseClass {
	
	public static String fasoftappurl = "http://103.102.97.210:8165/";
	
	 Transaction_Base trans = new Transaction_Base();
	
  @BeforeTest
  public void beforeTest() {
	  startdriver("chrome");
	  driver.get(fasoftappurl);
	 
	  test = extent.createTest("Transaction module menu check");
  }
	
  @Test(priority = 0)
  public void login() {
	  
	  getElementByID("username").sendKeys("admin");
	  getElementByID("password").sendKeys("admin");
	  getElementByXpath("logbtn").click();
	  
       // wait for the home button to display
	   driverwait(getElementByXpath("homeicon"));
	   
	   
	  
	  
	  
	      String home = getPagetitle();
		  System.out.println(home);
		  
		  if(home.contains("Home")) {
			  logger.info("Loging is successful and rediredted page is -> "+home);
			  
			  test.log(Status.PASS,"Login is successfull , Dashboard page displayed" );
		  }
		  else {
			  test.log(Status.FAIL," Login Failed");
		  }

	  
	
  }
  
  
 @Test(priority = 1) 
  public void MasterModuleNavigation() throws InterruptedException, IOException {
	  
	
	 try {
		 
		trans.main_Sub_menu_click("Master","Category");
		asserts.assertEquals(getPagetitle(), "Fasoft - Category List");

		 trans.main_Sub_menu_click("Master","Device");
		 
		 
		 trans.main_Sub_menu_click("Master","Location");
		 asserts.assertEquals(getPagetitle(),"Fasoft - Location List");
		 
		 trans.main_Sub_menu_click("Master","Section");
		 asserts.assertEquals(getPagetitle(),"Fasoft - Location List");
		 
		 trans.main_Sub_menu_click("Master","Barcode Label");
		 asserts.assertEquals(getPagetitle(),"Fasoft - Barcode Formats List");
		 
		 trans.main_Sub_menu_click("Master","Company");
		 asserts.assertEquals(getPagetitle(),"Fasoft - Company Lists");
		 
		 trans.main_Sub_menu_click("Master","Designation");
		 asserts.assertEquals(getPagetitle(),"Fasoft - Designation List");
		 
		 trans.main_Sub_menu_click("Master","Disposal Type");
		 asserts.assertEquals(getPagetitle(),"Fasoft - Disposal Type Lists");
		 
		 
		 trans.main_Sub_menu_click("Master","Section Head Mapping");
		 asserts.assertEquals(getPagetitle(),"Fasoft - Section Head Mapping List");
	} catch (InterruptedException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	                
	 
	
	  // getPagetitle();
	 
	
	  
	
	                            
	
	  
	  //Transaction_Base.mainmenu("Transaction");
	  test.log(Status.PASS, "menu hover successful");
	  
	  
  }
  
// @Test(priority = 2) 
  public void TransactionModuleNavigation() throws InterruptedException, IOException {
	  
	  trans.main_Sub_menu_click("Transaction","Transfer Asset");
  }
  
 //@Test (priority = 3) 
 public void TemplateModuleNavigation() throws InterruptedException, IOException {
	  
	//  trans.main_Sub_menu_click("Templates","Import Template");
	  test.info("Templates menu click start");
	  trans.main_Sub_menu_click("Templates","");	  
	  test.info("templates menu click Completed ");
	  
	  test.info("Test completed for "+this.getClass().getTypeName());
  }
  
  
  //@Test (priority = 4) 
  public void ApprovalModuleNavigation() throws InterruptedException, IOException {
 	  
	  test.info("Approval menu click start");
	  trans.main_Sub_menu_click("Transaction","");	  
	  test.info("Approval menu click Completed ");
	  
   }
   
// @Test(priority = 5) 
 public void BarcodePrinting() throws InterruptedException, IOException {
	 
     test.info("Barcode Printing menu click start");
 	 
	 trans.main_Sub_menu_click("Barcode Printitng","");
	 
	 test.info("Barcode menu click Completed");
	 
 }
 
// @Test(priority = 6) 
 public void Tools() throws InterruptedException, IOException {
	 
     test.info("Tools menu click start");
 	 
	 trans.main_Sub_menu_click("Tools","");
	 
	 test.info("Tools menu click Completed");
 }
   
  

 

  
  
  //@AfterTest
	  
	  public void getResult()
	    {
	       
	        extent.flush();
	        asserts.assertAll();
	    }
	  
	

 
  
}
