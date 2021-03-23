package testapplication;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ExceptionHandling {
	
	 @BeforeTest
	  public void beforeTest() {
	  }
	
	
	
  @Test
  public void Handle() {
	  
	  try {
		System.out.println("test Start");
		  
//		   int i = 1/0;  // this is the exception
		  
		  System.out.println("Test Completed");
	} catch (Exception excep) {
	      
		System.out.println("Exception captured");
		
		System.out.println("Message of exception "+excep.getMessage());
		System.out.println("Causes of error"+ excep.getCause());
		excep.printStackTrace();
	
	}
	  //it will execute any error happen
	  finally {
		  
		  System.out.println("In Final function");
	  }
	  
  }
 
  @AfterTest
  public void afterTest() {
  }

}
