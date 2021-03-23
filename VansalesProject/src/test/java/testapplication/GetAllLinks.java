package testapplication;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GetAllLinks  {
	
	public WebDriver driver = null;
	
  @Test
  public void findandlistlinks() {
	  
	 // startdriver("Chrome");
	//  driver.get("https://google.com");
	   baseClass.driverwait(By.name("q"));
	   baseClass.getElementByName("q").sendKeys(Keys.BACK_SPACE);
	   baseClass.getElementByName("q").sendKeys("Learning English in tamil ",Keys.ENTER);
	   
	  
	   List<WebElement> list = baseClass.driver.findElements(By.tagName("a"));
	   
	   
	   
	   int cnt = list.size();
	   
	   System.out.println(cnt +" - Number links found");
	   
	   for(int i=0; i<=cnt-1; i++ ) {
		   		   
		   System.out.println(i+"- "+list.get(i).getText());
	   }
	   
	  
  }
  
  
  @Test
  public void teardown() {
	  
	  // baseClass.driver.close();
	  //baseClass.driver.quit();
  }
  
  
  
}
