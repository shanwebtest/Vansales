package Masters;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testapplication.baseClass;

public  class MasterBase extends baseClass {
	
	
	
  @BeforeTest
  public void setup() throws IOException {
	  init();
	  startdriver("chrome");
	  loginapp();
	  
  }
	
  
  public  void Test(){
	  
	  
  }

  
  
}
