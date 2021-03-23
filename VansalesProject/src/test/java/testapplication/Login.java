package testapplication;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import test.Xls_Reader1;


@Listeners(TestNGListeners.class)
public class Login extends baseClass  {
	

	


	public static String TestCaseName = "Login ";


	

	@BeforeTest
	public  void Setup() throws IOException {
		 test = extent.createTest(TestCaseName+ " -->  Test");

	     	init();
		    startdriver("chrome");
			driver.get("http://103.102.97.210:8352/");
		    
		 // loginapp();

		//	baseClass.startdriver("chrome");

		//Login meth = new Login();
	}


	
	@Test(dataProvider="logindata")
	public void login(String username, String password) throws IOException {
		
	 
		 getElementByID("username").clear(); 
	     getElementByID("username").sendKeys(username);
	     getElementByID("password").clear();
		 getElementByID("password").sendKeys(password);
		  
	    getElementByXpath("logbtn").click();
	    
	    test.log(Status.PASS, "Login is successful");
		
	}


	//@Test
	public void test() {


		baseClass.driver.get("https://google.com");

		baseClass.driver.findElement(By.name("q")).sendKeys("allisforourHeal",Keys.
				ENTER);
		System.out.println("applicaiton launched");
		baseClass.driver.findElement(By.name("q")).sendKeys(Keys.BACK_SPACE);

	}


	//@Test
	public void test2() {
		String pgetitle = baseClass.driver.getTitle();
		if(pgetitle.equals("Google")) {

			System.out.println("Page title same as expected ->"+pgetitle );

		} else {
			System.out.println("not equal to "+pgetitle);
			//Assert.assertEquals(pgetitle, "Google"); 
		}

		// pass search value 
		//baseClass.searchname("sname");
		baseClass.getElementByName("q").sendKeys(Keys.BACK_SPACE);

		baseClass.getElementByName("q").sendKeys("learning english in tamil",Keys.ENTER);

		baseClass.getElementByName("q").clear();
	}


	@DataProvider(name="logindata")
	public static Object[][] getData() throws IOException{		
		String filepath = filepaths();		
		Object data[][] = Xls_Reader1.getData(filepath, "Sheet2");
		return data;		
	}
	
	
	
	
	
	
	

	@AfterMethod
	public void aftermethod() throws IOException {
		String filepath = filepaths();
		
	
		
	//	Xls_Reader1.setCellValue(filepath,"Sheet2" );
		
	}
	
	
	//@AfterTest
	public  void exit() {	

		extent.flush(); 	

		driver.close();
		driver.quit();
	}

}
