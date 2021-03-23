package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.GoogleSearchPage;


public class Google_Search_and_Get {
	
	static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		
		searchandget();
				
	}
	
	
	public static void searchandget() {
		
		String path = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver",path+"\\Drivers\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//go to website
		driver.get("https://google.com");
		
		//enter url to search
		// driver.findElement(By.name("q")).sendKeys("allisforourhealh panchagavya");
		 GoogleSearchPage.textbox_search(driver).sendKeys("allisforourhealh panchagavya");;
		 
		//click on search button				
		//driver.findElement(By.cssSelector(".FPdoLc > center:nth-child(1) > input:nth-child(1)")).click();
		GoogleSearchPage.searchBtn(driver).click();
		System.out.println("Test Executed fine");
		
		
		//close the browser
		driver.close();
		
		//close the driver
		driver.quit();
		
				
		
	}
 
}
