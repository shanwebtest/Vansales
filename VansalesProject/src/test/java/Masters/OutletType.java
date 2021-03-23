package Masters;

import org.testng.annotations.Test;

import Transactions.Transaction_Base;
import testapplication.baseClass;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;

public class OutletType extends baseClass  {
	Transaction_Base menu = new Transaction_Base();
	
 @BeforeTest
 public void beforeTest() throws IOException {
	 
	  init();
	  startdriver("chrome");
	  loginapp();
	  
  }
	
	
  @Test
  public void CreateOutletType() throws InterruptedException, IOException {
	  
	   menu.main_Sub_menu_click("Master","Device");
	   menu.Main_Sub_Sub_menu_click("Master","Outlet Details","Outlet Type");
	 
	 
	  
  }
 

  @AfterTest
  public void afterTest() {
  }

}
