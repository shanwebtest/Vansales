import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	
	public static void main(String[] args) throws InterruptedException {
	
		
		//String driverpath = System.getProperty("user.dir");
		
//		 System.setProperty("webdriver.gecko.driver",driverpath+"/Drivers/Firefox/geckodriver.exe");
//		  WebDriver driver = new FirefoxDriver();
//		  driver.manage().timeouts().implicitlyWait(10,
//		 TimeUnit.SECONDS); driver.get("http://google.com/");
//		 		
		//System.setProperty("webdriver.chrome.driver", driverpath+"/Drivers/Chrome/chromedriver.exe");
		
		//WebDriverManager.chromedriver().browserVersion("2.36").setup();
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		 
		//  WebDriverManager.firefoxdriver().setup();
		//  WebDriver driver = new FirefoxDriver();
		  
//		  WebDriverManager.iedriver().setup();
//		  WebDriver driver = new InternetExplorerDriver();
		  
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://google.com/");
		
		
//		
//		  System.setProperty("webdriver.ie.driver", driverpath+"/Drivers/IE/IEDriverServer.exe"); 
//		  WebDriver driver = new InternetExplorerDriver(); 
//		  driver.manage().timeouts().implicitlyWait(20,
//		  TimeUnit.SECONDS); driver.get("http://google.com/");
	
		Thread.sleep(2000);
		
		driver.findElement(By.name("q")).sendKeys("Panchagavya allisforourhealth",Keys.ENTER);
		
		
		driver.findElement(By.linkText("Panchagavya allisforourhealth")).click();
		
		Thread.sleep(2000);
		List<WebElement> ele = driver.findElements(By.tagName("cite")); 
		
		int ss = ele.size();
		
		System.out.println("number of link in the 1st page --> "+ele.size());
		
		for(int i=0; i<=ss-1; i++ )  {
			
			String ss1 = ele.get(i).getText();	
			if(ss1.contains("allisforourhealth")){
				
				
				
				Thread.sleep(2000);
				System.out.println("Link "+ i + ss1 + "=>");	
				ele.get(i).click();
				break ;
			}
				
						
		}
		
		
	   driver.close();
	   driver.quit();
		
	}

}
