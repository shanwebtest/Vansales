package test;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class dependenciesOnGroup {
	
	
  @Test
  public void GroupTest1() {
	  System.out.println("Test1 is Executed ");
  }
  
  @Test(dependsOnGroups = "functional" ) // as test 2 dependent on test 3 , then test3 execute 1st and test2 is next to that.
  public void GroupTest2() {
	  System.out.println("Test 2 is Executed ");
  }
  
  
  @Test(groups = {"functional"})
  public void GroupTest3() {
	  System.out.println("Test 3 is Executed ");
  }
  
  @Ignore
  @Test(groups = {"functional"})
  public void GroupTest4() {
	  System.out.println("Test 4 is Executed ");
  }
  
  
  @Test(groups = {"functional"},enabled = false)
  public void GroupTest5() {
	  System.out.println("Test 5 is Executed ");
  }
  
  
  @Test(enabled = true,invocationCount = 5)
  public void GroupTest6() {
	  System.out.println("Test 6 is Executed ");
  }
  
  
}
