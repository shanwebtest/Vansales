package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.PageObject_Vivensas_ContactUs;

public class Vivensas_Contact_Us_PageTest {
	
	 static WebDriver driver = null;
	
	public static void main(String[] args) {
		ContactUs_Test();
	}
	
	public static void ContactUs_Test() {
		
		String path = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver",path+"\\Drivers\\Chrome\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//create object for Page class;		
		PageObject_Vivensas_ContactUs contactUs = new PageObject_Vivensas_ContactUs(driver);

		//go to website
		driver.get("https://vivensas.com/contact-us");
		
	
		contactUs.set_name("shanmugam"); //call method through page class object   
		contactUs.set_email("shanmugam@vivensas.com");//call method through page class object  
		
		System.out.println("contact data entered");
		driver.close();
		
		
		
		
	}

}
