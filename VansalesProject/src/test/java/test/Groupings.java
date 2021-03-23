package test;

import org.testng.annotations.Test;

public class Groupings {
  @Test(groups = {"functionalTest","systemTest","sanityTest"})
  public void Test1() {
	  System.out.println("Test 1 printed : ");
  }
  
  @Test(groups = {"functionalTest","sanityTest"})
  public void Test2() {
	  System.out.println("Test 2 printed : ");
  }
  
  @Test(groups = {"functionalTest","systemTest"})
  public void Test3() {
	  
	  System.out.println("Test 3 printed : ");
	  
  }
  
  @Test(groups = {"functionalTest","systemTest"})
  public void Test4() {
	  
	  System.out.println("Test 4 printed : ");
  }
  
  @Test(groups = {"functionalTest","systemTest"})
  public void Test5() {
	  System.out.println("Test 5 printed : ");
  }
  
  @Test(groups = {"functionalTest","sanityTest"})
  public void Test6() {
	  System.out.println("Test 6 printed : ");
  }
 

  
}
