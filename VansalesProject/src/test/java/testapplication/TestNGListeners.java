package testapplication;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class TestNGListeners implements ITestListener {
	
	String ITestResult = null;
	String result = null;
	baseClass bs = new baseClass();
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("*****Test is started : "+result.getName());
				
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*****Test is Passed : "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		
		System.out.println("*****Test is Failed : "+result.getName());
		
		try {
			baseClass.getScreenshot();
			
			 String screenShotPath = baseClass.getScreenshot();
			
			 baseClass.test.log(Status.FAIL,result.getThrowable());
			 baseClass.test.generateLog(Status.FAIL, "Snapshot below"+baseClass.test.addScreenCaptureFromPath(screenShotPath));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("*****Test is Skipped : "+result.getName());
	}
	
	
	public void onFinish(ITestResult result) {
		System.out.println("*****Test is Finished : "+result.getName());
		
	}
}
