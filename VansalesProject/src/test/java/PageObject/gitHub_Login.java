package PageObject;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class gitHub_Login extends testapplication.baseClass {
	
	
	static String url = "https://github.com/login";
	static String uname = "shanhorizon@gmail.com";
	static String pwd = "Automationtest@123";
  // https://github.com/shanwebtest/Vansales.git
	
 @BeforeClass
 public void beforeclass() throws IOException {
	 init();
	 startdriver("chrome");
	 driver.get(url);
 }
 
 
 
	
  @Test
  public void login() {
	  logger.info("Login Strated");
	  driver.findElement(By.name("login")).sendKeys(uname);
	  driver.findElement(By.name("password")).sendKeys(pwd);
	  driver.findElement(By.name("commit")).sendKeys(Keys.RETURN);
	  
	  System.out.println("Login is successful");
	  
	  
	  
	  
  }
  
  
  
}
