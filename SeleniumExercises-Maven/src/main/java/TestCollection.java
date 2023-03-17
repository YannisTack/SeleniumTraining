import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import dataHolders.Person;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.WelcomePage;
import utils.DriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestCollection {
	
	@BeforeSuite
	public static void setup() {
		  DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net/");
	  }
	
	@AfterSuite
	public static void teardown() {
		DriverManager.killDriver();
	}
	  
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("logout");
		MenuPage menu = new MenuPage(DriverManager.getDriver());
		menu.logout();
	  }
	
	@DataProvider(name = "LoginTest Error")
	public Object[][] createInvalidLoginData() {
		return new Object[][] {
			{"admin", "invalidPassword"},
			{"invalidUser", "superduper"},
			{"admin", "superduper"},
			{"/", "/"},
		};
	}
	@Test(dataProvider = "LoginTest Error")
	public void loginWithUsernameAndPassword(String username, String password) {
		LoginPage login = new LoginPage(DriverManager.getDriver());
		Assert.assertFalse(login.loginWith(username, password)
				.isWelcomeMessageShown(), "Welcome message is displayed for incorrect login data");
	}
	
	@Test
	public void loginWithCorrectUsernameAndPassword() {
		LoginPage login = new LoginPage(DriverManager.getDriver());
		Assert.assertTrue(login.loginAsAdmin()
				.isWelcomeMessageShown(), "Welcome message is not displayed for correct login data");
	}
	
	@Test
	public void createNewConnection() {
		LoginPage login = new LoginPage(DriverManager.getDriver());
		Person p = new Person();
		Assert.assertTrue(login.loginAsAdmin()
				.navigateToNewConnectionPage()
				.addConnection(p)
				.isCreationFeedbackDisplayed(p));
		
	}
	
	@Test
	public void createNewConnectionAndValidateStats() {
		LoginPage login = new LoginPage(DriverManager.getDriver());
		Person p = new Person();
		Assert.assertTrue(login.loginAsAdmin()
				.navigateToNewConnectionPage()
				.addConnection(p)
				.isCreationFeedbackDisplayed(p));
		
	}
	
}
