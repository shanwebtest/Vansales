package testapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;



public class baseClass {
	public static WebDriver driver =null;
	public static Properties param =null;
	public static Properties object = null;


	public static String url = null;

	public static ExtentSparkReporter htmlreporter; 
	public static ExtentReports extent;
	public static ExtentTest test;

	public static String filepath;	
	public static String TestCaseName;
	public static Logger logger;
	public static SoftAssert asserts;
	public static FileInputStream fileinput =null;


   
	@BeforeSuite
	public void beforeSuite() throws IOException {

		init(); // initialize all property files from base class
		//startdriver(Browser); 
		//loginapp();

	}
	
	
  @AfterSuite
  public void closeBrosers() {
	  extent.flush(); 
	  driver.close();
	  driver.quit();
	  
  }


	public  baseClass() {

		
		filepath = System.getProperty("user.dir");	
		htmlreporter  = new ExtentSparkReporter(filepath+"\\ExtentReport\\TestReport2.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlreporter); 

		test = extent.createTest(" Application Test Reports");

		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Host Name", "Shanmugam");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Shanmugam@vivensas.com");

		// htmlreporter.config().setChartVisibilityOnOpen(true);
		htmlreporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
		htmlreporter.config().setReportName("My Own Report");
		//  htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreporter.config().setTheme(Theme.DARK);


		// console log objects
		logger = LogManager.getLogger(); 

		//soft assertion object
		asserts = new SoftAssert();

		return;
	}

	public void init() throws IOException {


		//create parameter object and initialise it
		param = new Properties();
		String filepath = System.getProperty("user.dir")+"\\src\\main\\resources\\Param.properties";
		fileinput = new FileInputStream(filepath);
		param.load(fileinput);
		logger.info("Parameter file loaded properly");

		object = new Properties();
		String filepath1 = System.getProperty("user.dir")+"\\src\\main\\resources\\ObjectProperty.properties";
		fileinput = new FileInputStream(filepath1);
		object.load(fileinput);
		logger.info("Object Property file loaded successfully");		

	}




	public static WebDriver startdriver(String browser){


		if(browser.equalsIgnoreCase("Chrome")){
			DesiredCapabilities chrom = new DesiredCapabilities();
			chrom.acceptInsecureCerts();
			String path = System.getProperty("user.dir");		
			System.setProperty("webdriver.chrome.driver",path+"\\Drivers\\Chrome\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS) ;
			driver.manage().window().maximize();

		}else if(browser.equals("Firefox")){

			
			String path = System.getProperty("user.dir");		
			System.setProperty("webdriver.gecko.driver",path+"\\Drivers\\Firefox\\geckodriver.exe");
			driver=new FirefoxDriver();
		
			driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS) ;
			driver.manage().window().maximize();
		}
		
		
		
		return driver;

	}

	public baseClass(WebDriver driver) {		
		baseClass.driver = driver;
	}


	public static String filepaths() {
		String path1 = System.getProperty("user.dir")+("\\Excel\\TestData.xlsx");
		return path1;
	}

	public static void loginapp() {
		String url = 	param.getProperty("siteUrl");
		driver.get(url);
		getElementByID("username").sendKeys(param.getProperty("username"));
		getElementByID("password").sendKeys(param.getProperty("password"));

		getElementByXpath("logbtn").click();

		// wait for the home button to display
		// driverwait(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/a"));




		String home = getPagetitle();
		System.out.println(home);

		if(home.contains("Home")) {
			logger.info("Login is successful and navigated to -> "+getPagetitle()+ " : this page "  );
			test.log(Status.PASS,"Login is successfull , Dashboard page displayed" );
		}
		else {
			test.log(Status.FAIL," Login Failed");
		}


		return;
	}


	public static String getScreenshot() throws IOException {

		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/Screenshots/"+getPagetitle()+"_"+System.currentTimeMillis()+".png"; 
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);        

		return dest;
	}

	public static void getscreenshotAftermenthod(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {

			String screenShotPath = getScreenshot();
			test.log(Status.FAIL,result.getThrowable());
			test.generateLog(Status.FAIL, "Snapshot below"+test.addScreenCaptureFromPath(screenShotPath));
		}

	}



	public static void searchname(String sname) {

		driver.findElement(By.name("q")).sendKeys(sname,Keys.ENTER);
		// TODO Auto-generated method stub

	}

	public static WebElement getElementByName(String by) {		

		return driver.findElement(By.name(by));		

	}

	public static WebElement getElementByXpath(String key) {	

		return driver.findElement(By.xpath(object.getProperty(key)));		

	}




	public static WebElement getElementByXpath(String key, String key1, int RN , String Key2) {	

		return driver.findElement(By.xpath(object.getProperty(key)+object.getProperty(key1)+RN+object.getProperty(Key2)));		

	}

	public static WebElement getElementByXpath(String key, int RN,String key1,String Key2,int RN1, String key3) {	

		return driver.findElement(By.xpath(object.getProperty(key)+RN+

				object.getProperty(key1)+object.getProperty(Key2)+RN1+object.getProperty(key3)));		

	}

	public static WebElement getElementByXpath(String key, int RN,String key1,int RN1,String Key2) {	

		return driver.findElement(By.xpath(object.getProperty(key)+RN+

				object.getProperty(key1)+RN1+object.getProperty(Key2)));		

	}
	
	public static Actions actionsclick(String key ) {
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id(key) ));
		act.click();		
		return act;
	} 





	public static WebElement getElementByXpath(String key,int RN,String key1 ,int RN1, String Key2,String key3,int RN2,String Key4) {	

		return driver.findElement(By.xpath(object.getProperty(key)+RN+object.getProperty(key1)+RN1+
				object.getProperty(Key2)+object.getProperty(key3)+RN2+object.getProperty(Key4)));		

	}

	public static WebElement getElementByXpath(String key, int RN ,String Key1) {	

		return driver.findElement(By.xpath(object.getProperty(key)+RN+object.getProperty(Key1)));

	}





	public static List<WebElement> getElementsByXpath(String key) {		

		return driver.findElements(By.xpath(object.getProperty(key)));		

	}


	public static List<WebElement> getElementsByXpath(String key,int RN,String Key1 ) {		

		return driver.findElements(By.xpath(object.getProperty(key)+RN+object.getProperty(Key1)));						
	}


	public static List<WebElement> getElementsByXpath(String key,int RN,String Key1,int RN1,String Key2 ) {		

		return driver.findElements(By.xpath(object.getProperty(key)+RN+
				object.getProperty(Key1)+RN1+object.getProperty(Key2)));

	}




	public static WebElement getElementByID(String key) {		

		return driver.findElement(By.id(object.getProperty(key)));	



	}


	public static WebElement getElementByClass(String classname) {		

		return driver.findElement(By.className(classname));

	}
	
    public static WebElement getElementByCssSelector(String name) {
    	
     return	driver.findElement(By.cssSelector(object.getProperty(name)));
     
    }

    public static List<WebElement> getElementByCssSelectorList(String name) {
    	
        return	driver.findElements(By.cssSelector(object.getProperty(name)));
        
       }
 

	public static WebElement getElementBytext(String text) {		

		return driver.findElement(By.linkText(text));

	}


	public static String getPagetitle() {

		return driver.getTitle();
	}




	// methods to return to another method in another class     
	public static WebElement driverwait(WebElement key) {
		WebDriverWait wait = new WebDriverWait(driver,20);

		return	wait.until(ExpectedConditions.elementToBeClickable(key));		

	}

	public static WebElement driverwait(By by) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		return	wait.until(ExpectedConditions.elementToBeClickable(by));

	}


	public static String Appurl() {

		//  String url = "https://admin.eatzilla.info/";
		driver.get(url);

		return url ;


	}




}
