package test;

import org.testng.annotations.Test;

public class depndencies {
	
  	
  	
	
  @Test(dependsOnMethods = "Ttest2")
  public void Ttest1() {
	 
	  System.out.println("Functions 1 is executed ");
  
  }
  
  @Test
  public void Ttest2() {
	  
	  System.out.println("Functions 2 is executed ");
	  
  
  }

  
  
}
