package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport_TestNG {
	ExtentSparkReporter htmlreporter; 
	ExtentReports extent;
	String filepath;
	ExtentTest test;
	private static WebDriver driver;
	
	
	@BeforeSuite
	public void setup(){
	 filepath = System.getProperty("user.dir");	
	 htmlreporter  = new ExtentSparkReporter(filepath+"\\ExtentReport\\TestReport2.html");
	 extent = new ExtentReports();
	 extent.attachReporter(htmlreporter); 
	
		String path = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver",path+"\\Drivers\\Chrome\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
	 
	}
	
	@Test
	public void test1() {
		
		test = extent.createTest("Vivensas website Test 1");
        test.log(Status.INFO, "Starting Test Case");
		
	
		  test.pass("Browser launched");
		
		driver.get("https://vivensas.com/careers");
		  test.pass("Career Page Opened");
		
		String jobtitle = driver.findElement(By.tagName("h1")).getText();
		System.out.println("Currest Opening Name => "+jobtitle );		
		  test.pass("Available Job captured");
		
			
		
	}
@Test
public void test2() {
		
		test = extent.createTest("Vivensas website Test 2");
        test.log(Status.INFO, "Starting Test Case");
			
		
	
		//  test.pass("Browser launched");
		
		  driver.get("https://vivensas.com/case-studies");
		  test.pass("Case Studies Page Opened");
		
		String casestudy = driver.findElement(By.tagName("h1")).getText();
		System.out.println("Case Study about the application => "+casestudy );		
		  test.fail("Case Study captured");
		 // test.addScreenCaptureFromPath(filepath);
		  extent.createTest("ScreenCapture")
          .addScreenCaptureFromPath("extent.png")
          .pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());
		
		
		
		
		
		
	}

	
	@AfterSuite
	public void teardown() {
		driver.close();
		driver.quit();
		  test.pass("Closed Browser");
		
		  test.info("Test Completed");
		  extent.flush(); //write all extend log in report
	}
}
