package utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {
	private String destinationPath = System.getProperty("user.dir") + "test.png";
	
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("PASS");
	}
	
	public void onTestFailure(ITestResult iTestResult) {
		// Take screenshot
		File file = ((TakesScreenshot) DriverManager.getEDriver()).getScreenshotAs(OutputType.FILE);
	}

}
