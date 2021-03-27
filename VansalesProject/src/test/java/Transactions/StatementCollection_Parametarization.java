package Transactions;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.Arguments;

import com.aventstack.extentreports.Status;

import test.Xls_Reader1;
import test.utility;
import testapplication.TestNGListeners;
import testapplication.baseClass;


//@Listeners(TestNGListeners.class)
public class StatementCollection_Parametarization extends Transaction_Base {

	private static int value;
	String SheetName = "StatementCollect";
	//Transaction_Base trans = new Transaction_Base(); // create object for Transaction base.
	public static int expvalue = value;

	@BeforeMethod
	public void beforeMethod(Method method) {
		test = extent.createTest("Statement creation"+method.getName());
	}

	@BeforeTest
	public void BeforeTest() throws IOException {


		//init(); // initialize all property files from base class
		startdriver("Chrome"); 
		loginapp();

	}

	@Test(priority = 0)
	public void statement_Collection_Click() throws InterruptedException, IOException {


		// code to click on the given menu
		main_Sub_menu_click("Transaction","Statement Collection");
		test.log(Status.INFO,"Transaction submenu is clicked");
		Thread.sleep(1000); 
		getElementByID("addnewbtn").click();
		test.log(Status.INFO,"Add new button is clicked");  



	}



	@Test(dataProvider="statementCollect",priority = 1)
	public void statementCollectionCreate(String outlet, String StatementNo, String CollectAmt) {
		System.out.println(outlet+":"+StatementNo);

		//String Expectedmsg = "please select Outlet";
		// String value = CollectAmt;


		try {


			listboxtext(outlet);

			Thread.sleep(1000);
			statementNo(StatementNo);
			Thread.sleep(1000);
			TransactionType("Return");
			Thread.sleep(1000);
			paymentType("Cash");
			Thread.sleep(500);

			try {
				//	String ss1 = Keys.chord(Keys.RETURN);
				Actions act = new Actions(driver);
				//div[class="form-group"] span[class="k-widget k-numerictextbox"] input[id="CollectedAmount"]
				//div[@class=\"form-group\"]/span[1]/span[1]/input[@name=\"CollectedAmount\"]
				WebElement ele1 = driver.findElement(By.xpath("//div/div/form/table/tbody/tr[3]/td[2]/div/span/span/input[1]"));
				act.moveToElement(ele1).click();			
				String s=String.valueOf(CollectAmt);
				ele1.sendKeys(Keys.SHIFT,Keys.ARROW_LEFT,Keys.DELETE,s);
				//act.moveToElement(ele1).click();


				Actions action = new Actions(driver);
				action.moveByOffset(0, 20).click().build().perform();
				System.out.println("Clicked out of the field");


				//driver.findElement(By.name("CollectedAmount")).click();


				///	WebElement ele = driver.findElement(By.xpath("//div/div/form/table/tbody/tr[3]/td[2]/div/span/span/input[1]"));
				//	 driverwait(ele); 
				//   	JavascriptExecutor js = (JavascriptExecutor)driver;
				//	js.executeScript("arguments[0].scrollIntoView(true);", ele);
				//	ele.click();
				//	ele.clear();
				//	ele.sendKeys("10");


			} catch (Exception e) {

				e.printStackTrace();
			}

			getElementByXpath("submitbtn").click();
			Thread.sleep(2000);
			test.log(Status.INFO,"Submit Button clicked");



			//	Alert alert1 = driver.switchTo().alert();
			//	String validmsg = alert1.getText();
			//	alert1.accept();


			//	List<WebElement> elea = driver.findElements(By.tagName("iframe"));
			//	System.out.println("Frameelements  : "+elea.size());




			driverwait(By.xpath("//div[2]/div/table/tbody/tr/td[2]/div"));			
			String validmsg = getElementByXpath("succmsg").getText();			


			//String validmsg = driver.findElement(By.xpath("//span[@class=\"field-validation-error\"]")).getText();
			String expmsg = "Record Saved Successfully."; 
			if(validmsg.contains(expmsg)) {
				System.out.println("Pass :"+validmsg );

				Assert.assertTrue(true, "Test Passsed"+validmsg);
				test.log(Status.PASS,"validation message verified"+validmsg);
				//click on success message popup
				getElementByXpath("succmsgokbtn").click();
				verifyCollectedAmt(CollectAmt); // verify Collected amount from the Grid
				getElementByID("addnewbtn").click();
			}else {
				System.out.println("Mismatching :"+validmsg );
				test.log(Status.FAIL,"Expected msg : "+expmsg+" Actual validatin message :"+validmsg+ " :is not equal"  );
				Assert.assertTrue(false, "Test failed : "+expmsg+" :Actual validatin message :"+validmsg+ " :is not equal");
				//click on success message popup
				getElementByXpath("succmsgokbtn").click();
			}
		} catch (Exception e) {

			e.printStackTrace();
			Alert alet = driver.switchTo().alert();
			System.out.println("Alert Message : "+alet.getText());
			alet.accept();
		}

	}



	public void verifyCollectedAmt(String collectAmt) {
		test.log(Status.INFO, "collected amount validation startedd");
		driverwait(By.xpath(object.getProperty("amountingrid")));		
		String gridvalue = getElementByXpath("amountingrid").getText();
		System.out.println("Grid value : "+gridvalue);
		int va = Integer.parseInt(gridvalue);  // convert string as int
		int expvalue = Integer.parseInt(collectAmt);  // convert string as int  



		if(va==expvalue) {
			System.out.println("value matching :"+va+":"+expvalue);
			test.log(Status.PASS,"value are equal :"+va+":"+expvalue);
		} else {

			test.log(Status.FAIL,"value mismatching :"+va+":"+expvalue);

			System.out.println("value mismatching :"+va+":"+expvalue);
		}

	}


	@DataProvider(name="statementCollect")
	public Object[][] data() throws IOException{
		String filepath = filepaths();
		Object[][] data = Xls_Reader1.getData(filepath, SheetName);

		return data;

	}


	//@AfterMethod
	public void test() {
		//	utility.WriteResultUtility(xls, sheetName, ColName, rowNum, Result)
	}

	//@AfterTest
	public void teardown() {

		extent.flush();
		driver.close();
		driver.quit();

	}

}
