package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.PageObject_Vivensas_ContactUs;

public class Vivensas_Contact_Us_PageTest_TestNGTest {
	
	private static WebDriver driver = null;
	
	@BeforeTest
	public void setupBrowser () {
		String path = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver",path+"\\Drivers\\Chrome\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public static void ContactUs_Test() {
		
		//create object for Page class;		
		PageObject_Vivensas_ContactUs contactUs = new PageObject_Vivensas_ContactUs(driver);

		//go to website
		driver.get("https://vivensas.com/contact-us");
		
	
		contactUs.set_name("shanmugam"); //call method through page class object   
		contactUs.set_email("shanmugam@vivensas.com");//call method through page class object  
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
	
		System.out.println("Test Executed successfully");
		//driver.close();
		//driver.quit();
		
	}
}
