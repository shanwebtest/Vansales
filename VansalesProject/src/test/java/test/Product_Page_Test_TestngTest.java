package test;

import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.jq.ResultsByClass;

import PageObject.PageObject_Vivensas_ContactUs;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Page_Test_TestngTest {
	
	private WebDriver driver =null;
	
	
	@BeforeTest
	public void browerLauch() {
		String path = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver",path+"\\Drivers\\Chrome\\chromedriver.exe");
	    driver = new ChromeDriver();
	    
	  //  WebDriverManager.iedriver().setup();
		//driver = new InternetExplorerDriver();
	    
		driver.manage().window().maximize();	
	
		
	}
	
	
	@Test	
	public void ProductListpage() {
		
	   PageObject_Vivensas_ContactUs pge = new PageObject_Vivensas_ContactUs(driver);
	   
		
	  driver.get("https://vivensas.com/products");
	  
	  WebElement productname = driver.findElement(By.tagName("h1"));
	   
	  System.out.println("Product Name = "+productname.getText());
	 
		
	}
	
	@Test
	public void ProductListpage_Title() {
		
		   PageObject_Vivensas_ContactUs pge = new PageObject_Vivensas_ContactUs(driver);
		   
			
		  driver.get("https://vivensas.com/products");
		  
		  String pgetitle = driver.getTitle();
		   
		  Assert.assertEquals(pgetitle,"Vivensas - Products" );
		  
		  System.out.println("Page title assertion");		 
		  
		}
	
	
	
	@AfterMethod
	public void aftermethod(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"Test Executed successfully");	
	}
	
	@AfterTest
	public void tearDown() {
	
		
		//driver.close();
		//driver.quit();
		
	}

}
