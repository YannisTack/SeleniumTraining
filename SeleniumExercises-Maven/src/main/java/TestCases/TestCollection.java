package TestCases;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataHolders.Person;
import pageObjects.ConnectionsPage;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.NewConnectionPage;
import pageObjects.StatsPage;
import pageObjects.WelcomePage;
import utils.ChildAvailable;
import utils.DriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

@Listeners(utils.MyTestListener.class)

public class TestCollection {
	public static ExtentTest test;
	public static ExtentReports report;
	
	@BeforeSuite
	public static void setup() {
		  DriverManager.getEDriver().get("https://satrngselcypr.z16.web.core.windows.net/");
		  report = new ExtentReports(System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "ExtentReportResults.html", true);
	  }
	
	@AfterSuite
	public static void finalization() {
		DriverManager.killDriver();
		report.flush();
	}
	
	@AfterMethod
	public static void teardown() {
		report.endTest(test);
	}
	  
	@BeforeMethod
	public void beforeMethod(Method method) {
		System.out.println("logout");
		MenuPage menu = new MenuPage(DriverManager.getEDriver());
		menu.logout();
		test = report.startTest(method.getName());
	  }
	
	@DataProvider(name = "LoginTest Error")
	public Object[][] createInvalidLoginData() {
		return new Object[][] {
			{"admin", "invalidPassword"},
			{"invalidUser", "superduper"},
			{"admin", "Superduper"},
			{"/", "/"},
			{"admin", "superduper"},
		};
	}
	@Test(dataProvider = "LoginTest Error")
	public void loginWithUsernameAndPassword(String username, String password) {
		LoginPage login = new LoginPage(DriverManager.getEDriver());
		Assert.assertFalse(login.loginWith(username, password)
				.isWelcomeMessageShown(), "Welcome message is displayed for incorrect login data");
	}
	
	@Test
	public void loginWithCorrectUsernameAndPassword() {
		LoginPage login = new LoginPage(DriverManager.getEDriver());
		Assert.assertTrue(login.loginAsAdmin()
				.isWelcomeMessageShown(), "Welcome message is not displayed for correct login data");
	}
	
	@Test
	public void createNewConnection() {
		LoginPage login = new LoginPage(DriverManager.getEDriver());
		Person p = new Person();
		Assert.assertTrue(login.loginAsAdmin()
				.navigateToNewConnectionPage()
				.addConnection(p)
				.isCreationFeedbackDisplayed(p), "New connection was not successfully created.");
	}
	
	@Test
	public void createNewConnectionAndValidateStats() {
		LoginPage login = new LoginPage(DriverManager.getEDriver());
		Person p = new Person();
		StatsPage stats = login.loginAsAdmin().navigateToNewConnectionPage().addConnection(p).navigateToStatsPage();
		
		test.log(LogStatus.INFO, "Navigate to Stats Page.", "Some navigation info. Maybe a screenshot would be fun here.");
		
		System.out.println("Validating table row count.");
		Assert.assertTrue(stats.getTableRowCount() == 11, "Table row count is incorrect.");
		
		System.out.println("Validating testing stat cell.");
		Assert.assertTrue(stats.getTableCellText(4, 2).equals("2"), "Table cell value is incorrect.");
	}
	
	@Test
	public void javaScriptTest() {
		LoginPage login = new LoginPage(DriverManager.getEDriver());
		
		Assert.assertTrue(login.loginAsAdmin()
				.navigateToConnectionsPage()
				.resetConnections()
				.navigateToStatsPage()
				.getTableCellText(0, 2).equals("N/A"));
	}
	
	@Test
	public void expectedConditionTest() {
		LoginPage login = new LoginPage(DriverManager.getEDriver());
		Person p = new Person();
		Assert.assertTrue(login.loginAsAdmin()
			.navigateToNewConnectionPage()
			.addConnection(p)
			.navigateToConnectionsPage()
			.searchByLastName(p.getName())
			.isConnectionAdded(p), "The new connection was not found");
	}
	
}
