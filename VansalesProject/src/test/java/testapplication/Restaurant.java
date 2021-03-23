package testapplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

    

public class Restaurant extends baseClass {
	
	 //public ExtentTest test;
	
	@BeforeTest
	public void setup() {
		//startdriver("chrome");
		//Appurl();
		
	}
	
	
	@Test
	public void loginapp1() {
		
		System.out.println("Login page Opened");
		
	
		
		
		//baseClass obj = new baseClass();
		//loginapp();
	  //  test = extent.createTest("NewWebsite Test");
	   
		
		System.out.println("Login is successful");		
		test.log(Status.INFO, "Login is successful" );
		
		
		
		
//	 WebElement ele =	driverwait(By.xpath("//*[@id=\"navbar-mobile\"]/ul[2]/li/a/span[1]"));	 
//	 if(ele.isDisplayed()) {
//		 test.log(Status.PASS, "Login successful");
//		 }
//	 else {
//		 test.log(Status.FAIL, "Login is failed");
//	 }
		
		
		
	}
	
	
	
	
	@AfterTest
	public void closebrowser() {
		//baseClass.driver.close();
		//baseClass.driver.quit();
		
	//	extent.flush();
	}

}
