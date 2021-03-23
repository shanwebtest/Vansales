package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
	
	static WebElement element = null;
	
	
	public static WebElement textbox_search(WebDriver driver) {
		
	   element = driver.findElement(By.name("q"));	
	   return element;
		
	}
	
	public static WebElement searchBtn(WebDriver driver) {
		
		element = driver.findElement(By.cssSelector(".FPdoLc > center:nth-child(1) > input:nth-child(1)"));
		 return element;
		
	}

}
