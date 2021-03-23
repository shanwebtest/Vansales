package Transactions;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAccounts extends TestBase {

	SoftAssert asserts = new SoftAssert();
	String companyname = "NaveenTestCompany";
	String CompanyPerson = "Mamatha M";

	String contactname = "TestContact";
	String contactemail = "TestContact@gmail.com";
	
	
	

	//TestCompany  Mamatha M
	@Test(priority = 0)
	public void Login() {
		LaunchDriver("Chrome");
		loginapp();

	}

	@Test(priority = 2)
	public void createCompany() throws Exception {


		driver.get(url+"/new-accounts");	  
		driver.findElement(By.xpath("//div[@data-target=\"#addNewCompany\"]")).click();	  
		driver.findElement(By.id("company")).sendKeys(companyname);
		Thread.sleep(2000);

		selectperson(CompanyPerson);

		driver.findElement(By.cssSelector("#addNewCompany > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)")).click();


	}


	//@Test(priority = 1)  
	public void createCompanyNegativevalidation() throws Exception {  

		driver.get(url+"/new-accounts");	  
		driver.findElement(By.xpath("//div[@data-target=\"#addNewCompany\"]")).click(); //click on add company button

		driver.findElement(By.cssSelector("#addNewCompany > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)")).click();

		WebElement companyvalidattionmsg = driver.findElement(By.xpath("//app-add-company/div/div/div/div[2]/form/div"));
		asserts.assertEquals(companyvalidattionmsg.getText().trim(), "* Company name is required");


		// driver.findElement(By.id("company")).sendKeys(companyname);
		//  Thread.sleep(2000);
		driver.findElement(By.cssSelector("#addNewCompany > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(1)")).click();
		//  selectperson(CompanyPerson);


	}


	@Test(priority = 3)
	public  void CreateaContact_Validation() {
		//click on Contact plus icon
		driver.findElement(By.xpath("//i[@class=\"icon material-icons hov-color\"]")).click();

		//click on save button
		driver.findElement(By.id("contactSave")).click();

		//assert name is required 
		asserts.assertEquals(driver.findElement(By.xpath("//div[@class='errormsg ng-star-inserted']")).getText(),"* Name is required ");



	}

	@Test(priority = 4)
	public  void CreateaContact() {
		//click on Contact plus icon

		try {
			WebElement minus = driver.findElement(By.xpath("//i[@class=\"icon material-icons minus-icon minus-active\"]"));
			if(minus.isDisplayed()) {
				minus.click();
			}
		} catch (Exception e1) {
			driver.findElement(By.xpath("//i[@class=\"icon material-icons hov-color\"]")).click();
			e1.printStackTrace();
		}


		//Enter Contact Details
		driver.findElement(By.id("names")).sendKeys(contactname);  // enter name
		driver.findElement(By.id("emails")).sendKeys(contactemail); // enter contact email


		//click on save button
		driver.findElement(By.id("contactSave")).click();

		List<WebElement> conlist = driver.findElements(By.xpath("//div[@class=\"col-md-5 col-sm-6 col-xs-6 text-pos\"]"));

		List<String> actualResult = new ArrayList<String>();
		try {
			for(int i=0; i<=conlist.size()-1; i++) {
				actualResult.add(conlist.get(i).getText());
				// String txt = conlist.get(i).getText();			 		   
			}

			//Check the array list for given values
			for(String expected : actualResult) {			  
				if(expected.contains(contactname)){				  
					asserts.assertEquals(expected, actualResult);				  				  
				}
			}


		} catch (Exception e) {
			Assert.assertEquals(false,"No Contact matches");

			e.printStackTrace();
		}



	}



	public void createTask() {

		driver.findElement(By.xpath("//i[@class=\"icon material-icons plus-icon\"]")).click();
		driver.findElement(By.xpath("//i[@class=\"icon material-icons minus-icon minus-active\"]")).click();
          
		//enter task description
		driver.findElement(By.xpath("//textarea[@id=\"description\"]")).sendKeys("Call customer");
		
		//click on calendar icon 
		driver.findElement(By.xpath("//app-custom-calendar/form/div/mat-form-field/div/div[1]/div[3]/div/div/mat-icon")).click();
		
		//select date by passing day number
		selectdate(11);
		
		


	}



	//@Test
	public void compareCreatedCompany() {

		String name ="Aven"; 
		driver.get(url+"/new-accounts");
		String path1 = "[";		 
		String path2 = "]/td[";
		String path3 = "]/span[";
		String path4 = "]";


		try {
			WebElement ele = driver.findElement(By.xpath("//tbody[@class=\"table-content\"]"));
			List<WebElement> row = ele.findElements(By.tagName("tr"));		
			int rcnt = row.size();



			for(int i=1; i<=rcnt-1; i++) {

				List<WebElement> col = row.get(i).findElements(By.tagName("td"));
				int ccnt =col.size();

				String name1 = driver.findElement(By.xpath("//tbody[@class=\"table-content\"]/tr["+i+"]/td[2]")).getText();


				if(name1.contentEquals(companyname)) {
					String name11 = driver.findElement(By.xpath("//tbody[@class=\"table-content\"]/tr["+i+"]/td[2]")).getText();
					asserts.assertEquals(name11, companyname);
					Assert.assertEquals(name11, companyname);

					String owneract = driver.findElement(By.xpath("//tbody[@class=\"table-content\"]/tr["+i+"]/td[8]")).getText();
					asserts.assertEquals(owneract, CompanyPerson);
					Assert.assertEquals(owneract, CompanyPerson);
					System.out.println("Company name -> "+name11 +" >Owner Name "+owneract );

					break;
				} 


				/*
				 * for(int j=1; j<=ccnt-1; j++) {
				 * 
				 * String txt = col.get(j).getText();
				 * 
				 * System.out.println(" --->" +txt); }
				 */

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.assertEquals(false, companyname);
			e.printStackTrace();
		}



	}



	@AfterTest
	public void teardow() {
		// driver.close();
		// driver.quit();
	}
}