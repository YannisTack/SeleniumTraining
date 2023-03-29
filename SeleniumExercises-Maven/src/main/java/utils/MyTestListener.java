package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import TestCases.TestCollection;

public class MyTestListener implements ITestListener {
	private String destinationPath = System.getProperty("user.dir") + "failureScreenshot.png";
	
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println(iTestResult.getName() + ": PASS");
		
		// TODO - Only this event gets triggered whether it's PASS or FAIL.
		// TODO - Investigate how to get PASS / FAIL from iTestResult ?
		
	}
	
	public void onTestFailure(ITestResult iTestResult) {
		// Take screenshot
		System.out.println("Test failure -> taking screenshot");
		File file = ((TakesScreenshot) DriverManager.getEDriver()).getScreenshotAs(OutputType.FILE);
		File snapLocation = new File(destinationPath);
		
		System.out.println("Temp screenshot saved at " + file.getAbsolutePath());
		System.out.println("Final screenshot will be saved at " + snapLocation.getAbsolutePath());
		
		
		try {
			Files.move(file.toPath(), snapLocation.toPath(), StandardCopyOption.REPLACE_EXISTING);
			TestCollection.test.addScreenCapture("SeleniumExercises-Maventest.png");
		} catch (IOException e) {
			System.out.println("Screenshot failed");
			e.printStackTrace();
		}
		
		System.out.println("Screenshot copy complete. New file exists? - " + snapLocation.exists());
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("DOES THIS WORK???");
	}

}
