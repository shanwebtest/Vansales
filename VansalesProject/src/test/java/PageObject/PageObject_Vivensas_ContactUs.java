package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObject_Vivensas_ContactUs {
	
	WebDriver driver = null;
	
	By Name_Textbox = By.id("generalNameTextBox");
	By email_box = By.id("generalEmailTextBox");
	
	//create a constructor to use this class webdriver in any other test script that you are calling.
    public PageObject_Vivensas_ContactUs(WebDriver driver) {
		
		this.driver = driver;		
 	}
	
	
	// method to enter text into textbox
	public void set_name(String name) {		
		driver.findElement(Name_Textbox).sendKeys(name);
	}
	
	// method to enter emain into email box	
	public void set_email(String mail) {
			
		driver.findElement(email_box).sendKeys(mail);
	}
	
	

}
