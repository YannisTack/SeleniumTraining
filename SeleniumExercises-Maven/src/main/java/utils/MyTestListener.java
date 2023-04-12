package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import TestCases.TestCollection;

public class MyTestListener implements ITestListener {
	private String destinationBasePath = System.getProperty("user.dir") + File.separator + "test-output" +  File.separator;
	
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println(iTestResult.getName() + ": PASS");
		TestCollection.test.log(LogStatus.PASS, "Stepname", "Some text");
	}
	
	public void onTestFailure(ITestResult iTestResult) {
		// Log failure
		String errorMessage = iTestResult.getThrowable().getMessage();
		TestCollection.test.log(LogStatus.FAIL, "Stepname", errorMessage);
		String destinationPath = destinationBasePath + iTestResult.getTestName() + ".png";
		TestCollection.test.log(LogStatus.INFO, "Taking screenshot", TestCollection.test.addScreenCapture(takeScreenshot(destinationPath)));
		
	}
	
	public String takeScreenshot(String path) {
		File file = ((TakesScreenshot) DriverManager.getEDriver()).getScreenshotAs(OutputType.FILE);
		File snapLocation = new File(path);
		
		System.out.println("Temp screenshot saved at " + file.getAbsolutePath());
		System.out.println("Final screenshot will be saved at " + snapLocation.getAbsolutePath());
		
		
		try {
			Files.move(file.toPath(), snapLocation.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("Screenshot failed");
			e.printStackTrace();
		}
		
		return snapLocation.getAbsolutePath();
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("DOES THIS WORK???");
	}

}
