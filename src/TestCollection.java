import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.WelcomePage;
import utils.DriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestCollection {
	private static MenuPage menu;
	private static LoginPage login;
	private static WelcomePage welcome;
	
	@BeforeSuite
	public static void setup() {
		  DriverManager.getEDriver().get("https://satrngselcypr.z16.web.core.windows.net/");
		  menu = new MenuPage();
		  PageFactory.initElements(DriverManager.getEDriver(), menu);
		  login = new LoginPage();
		  PageFactory.initElements(DriverManager.getEDriver(), login);
		  welcome = new WelcomePage();
		  PageFactory.initElements(DriverManager.getEDriver(), welcome);
	  }
	  
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("logout");
		  menu.Logout();
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
		login.loginWith(username, password);
		Assert.assertFalse(welcome.isWelcomeMessageShown(), "Welcome message is displayed for incorrect login data");
	}
	
	@Test
	public void loginWithCorrectUsernameAndPassword() {
		login.loginWith("admin", "superduper");
		Assert.assertTrue(welcome.isWelcomeMessageShown(), "Welcome message is not displayed for correct login data");
	}
	  
	
}
