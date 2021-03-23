package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtendReportBasic {
	
      private static WebDriver driver = null;
      
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CareerSearch();
		
	}
	
	public static void CareerSearch() {
		
		String filepath = System.getProperty("user.dir");
	

		 // Object to store data in html file
		ExtentSparkReporter spark = new ExtentSparkReporter(filepath+"\\ExtentReport\\TestReport.html")
	       		  .viewConfigurer()
				    .viewOrder()
				    .as(new ViewName[] { 
					   ViewName.DASHBOARD, 
					   ViewName.TEST, 
					   ViewName.AUTHOR, 
					   ViewName.DEVICE, 
					   ViewName.EXCEPTION, 
					   ViewName.LOG 
					})
				  .apply();
		
		
		ExtentReports extent = new ExtentReports();  //create extent report object 
		System.out.println("get path "+ filepath+"\\ExtentReport\\TestReport.html");
		extent.attachReporter(spark);
		
	
		
		
		//create a toggle for the given test. add all log events under the test
		ExtentTest test = extent.createTest("Vivensas Website Test", "Career opening checks");
		test.log(Status.INFO, "Starting Test Case");
			
		
		String path = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver",path+"\\Drivers\\Chrome\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		  test.pass("Browser launched");
		
		driver.get("https://vivensas.com/careers");
		  test.pass("Career Page Opened");
		
		String jobtitle = driver.findElement(By.tagName("h1")).getText();
		System.out.println("Currest Opening Name => "+jobtitle );		
		  test.pass("Available Job captured");
		
		
		driver.close();
		driver.quit();
		  test.pass("Closed Browser");
		
		  test.info("Test Completed");
		
		extent.flush(); //write all extend log in report
		
	}
	
	
	

}
