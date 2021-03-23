package Transactions;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class InvoiceCollection extends Transaction_Base {



	@BeforeMethod
	public void beforeMethod(Method method) {
		test = extent.createTest("Invoice Collection"+method.getName());
	}

	@Test
	public void Invoicemenuclick() throws InterruptedException {

		try {
			main_Sub_menu_click("Transaction", "Invoice Collection");
			test.log(Status.INFO, getPagetitle()+ "-> is Opened ");

			//driverwait(getElementByID("addnewbtn")); // click on add new record button
			
			getElementByID("addnewbtn").click();
			test.log(Status.INFO, getPagetitle()+ " ->  is Opened ");


		} catch (IOException e) {
			test.log(Status.FAIL, getPagetitle()+ "-> is failed "+e.getMessage());
			e.printStackTrace();
		}

	}
	
	 @Test
	 public void fieldValidation() throws InterruptedException {
		 
		    listboxtext("MZ-0004");			
			Thread.sleep(1000);
			statementNo("STA00006");
			Thread.sleep(1000);
			TransactionType("Return");
			Thread.sleep(1000);
			paymentType("Cash");
			Thread.sleep(500);
		 
		 getElementByXpath("submitbtn").click(); // click on save buttton
		 test.log(Status.INFO, getPagetitle()+ " ->  is Opened ");
	 }



	@AfterTest
	public void teardown() {

		extent.flush();


	}


}
