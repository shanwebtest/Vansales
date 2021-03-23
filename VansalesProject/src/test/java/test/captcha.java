package test;

import org.testng.annotations.Test;

import testapplication.baseClass;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class captcha {
	public WebDriver driver = null;
	
	String urls = "https://www.walmart.com/blocked?url=L2lwL1BsYXktRG9oLVBhcnR5LUJhZy1JbmNsdWRlcy0xNS1Db2xvcmZ1bC1DYW5zLW9mLVBsYXktRG9oLTEtT3VuY2UtQ2Fucy8xOTcwODgxNTA=&uuid=8ef89ed0-66c9-11eb-a01c-2d15fd7c1efb&vid=&g=a";
		
	
	
  @Test
  public void CaptchaChecboxclick() {
	     int size = baseClass.driver.findElements(By.tagName("iframe")).size();
		 baseClass.driver.switchTo().frame(0).findElement(By.id("recaptcha-anchor")).sendKeys(Keys.ENTER);
		 
		 
		 
		 
		 System.out.println(size);
	  
  }
  @BeforeTest
  public void beforeTest() {
	  baseClass.startdriver("chrome");
	 baseClass.driver.get(urls);

	
 	// Actions action = new Actions(baseClass.driver);
    // WebElement ele =  baseClass.getElementByXpath("//div[@class='recaptcha-checkbox-border']");     
	// action.moveToElement(ele).build().perform();
	// ele.click();
	 
	
	 
	 
//	baseClass.getElementByXpath("//div[@class='recaptcha-checkbox-border']").click();
	  
  }

  @AfterTest
  public void afterTest() {
	  baseClass.driver.close();
	  baseClass.driver.quit();
  }

}
