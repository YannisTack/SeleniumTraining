import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.PageFactory;

import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.WelcomePage;
import utils.DriverManager;

public class LoginWithParameterTests {
	
	private static MenuPage menu;
	private static LoginPage login;
	private static WelcomePage welcome;

	@BeforeAll
	public static void setup() {
		DriverManager.getEDriver().get("https://satrngselcypr.z16.web.core.windows.net/");
		menu = new MenuPage();
		PageFactory.initElements(DriverManager.getEDriver(), menu);
		login = new LoginPage();
		PageFactory.initElements(DriverManager.getEDriver(), login);
		welcome = new WelcomePage();
		PageFactory.initElements(DriverManager.getEDriver(), welcome);
	}
	
	@BeforeEach
	public void doSomething() {
		menu.Logout();
	}
	
	@ParameterizedTest
	@CsvSource({
		"admin, invalidPassword",
		"invalidUser, superduper",
		"'/', '/'"
	})
	public void loginWithCorrectUsernameAndPassword(String username, String password) {
		login.loginWith(username, password);
		Assert.assertTrue("Welcome message is displayed for incorrect login data", welcome.isWelcomeMessageShown());
	}
}
