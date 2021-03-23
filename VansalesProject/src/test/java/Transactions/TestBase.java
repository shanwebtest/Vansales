package Transactions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestBase {

	public static WebDriver driver;
	public static String url = "https://staging.tryoncourse.com/"; 
	public static String username ="mamatha@zibtek.in",password="1234567890";

	public static WebDriver LaunchDriver(String name) {

		if(name.equalsIgnoreCase(name)) {

			DesiredCapabilities chrom = new DesiredCapabilities();
			chrom.acceptInsecureCerts();
			String path = System.getProperty("user.dir");		
			System.setProperty("webdriver.chrome.driver",path+"\\Drivers\\Chrome\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			driver.manage().window().maximize();

		}

		return driver;  	 
	}


	public static void loginapp() {
		driver.get(url);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pwd")).sendKeys(password);
		driver.findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();	 

		WebElement home = driver.findElement(By.xpath("//label[contains(.,'Accounts')]"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(home));

		if(home.isDisplayed()) {
			Assert.assertTrue(true,"Login is successful");
		}	  

	}

	public static void selectperson(String CompanyPerson ) {
		driver.findElement(By.xpath("/html/body/app-root/app-header/div/app-newheader/app-add-company/div/div/div/div[2]/form/mat-select/div/div[1]")).click();
		String path1 = "//mat-option[";
		String path2 = "]/span";

		List<WebElement> selection = driver.findElements(By.xpath("//mat-option"));

		for(int i=1; i<=selection.size()-1; i++) {
			String txt = driver.findElement(By.xpath(path1+i+path2)).getText();
			if(txt.contentEquals(CompanyPerson)) {
				driver.findElement(By.xpath(path1+i+path2)).click();
				System.out.println("Selected person ->"+txt);
				break; 			  
			}

		}


	}
	
	
	public static void selectdate(int k) {
		try {
		
			WebElement ele = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div/div/mat-calendar/div/mat-month-view/table/tbody"));
			List<WebElement> row = ele.findElements(By.tagName("tr"));		
			int rcnt = row.size();

			for(int i=1; i<=rcnt-1; i++) {

				List<WebElement> col = row.get(i).findElements(By.tagName("td"));
				int ccnt =col.size();
		
				 for(int j=2; j<=ccnt-1; j++) {
					 
					 WebElement datese = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div/div/mat-calendar/div/mat-month-view/table/tbody/tr["+i+"]/td["+j+"]"));
					 String txt  = datese.getText();
					   int txt1 = Integer.parseInt(txt);
					 if(txt1==k) {						 
						 datese.click();		
						 System.out.println("Date selected " +txt); 
						 Assert.assertEquals(true, k);
						 }						 
					 }
				   
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.assertEquals(false, k);
			e.printStackTrace();
		}

	}
	
	

}