package Transactions;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import okio.Options;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class RemoteTest {
	public WebDriver driver;
	String baseurl, huburl;
	
  
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	 baseurl = "www.vivensas.com";
	 huburl = "http://192.168.43.142:4444/wd/hub";
	 
	         

		
	  DesiredCapabilities capability = new DesiredCapabilities();
	  capability.setBrowserName("chrome");
	  capability.setPlatform(Platform.VISTA);
	  ChromeOptions op = new ChromeOptions();
	  //op.setHeadless(true);
	  op.merge(capability);
	  try {
		driver = new RemoteWebDriver(new URL(huburl),op);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}	  
	          // new URL(" http://192.168.43.100:4444/wd/hub");
	           
	           //http://192.168.43.142:4444/wd/hub
  }

  
  @Test
  public void f() {
	  driver.get(baseurl);
	  
	  driver.getTitle();
	  System.out.println(driver.getTitle());
	  
	  
  }
  
  
  
  
  
  
  @AfterTest
  public void afterTest() {
	  
	  
  }

}
