package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	private WebDriver driver;

	@FindBy (className = "content")
	private WebElement btnLogin;
	
	@FindBy (id = "username")
	private WebElement txtUsername;
	
	@FindBy (id = "password")
	private WebElement txtPassword;
	
	@FindBy (id = "language")
	private WebElement drpLanguage;
	
	@FindBy (xpath = "//p[@class='error']")
	private WebElement txtError;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Logs in with the given username and password
	 * @param username The username as text
	 * @param password The password as text
	 */
	public WelcomePage loginWith(String username, String password) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		btnLogin.click();
		return new WelcomePage(driver);
	}
	
	/**
	 * Logs in as a valid admin user.
	 */
	public WelcomePage loginAsAdmin() {
		return loginWith("admin", "superduper");
	}
	
	public LoginPage setLanguageTo(String language) {
		Select slctLanguage = new Select(drpLanguage);
		slctLanguage.selectByVisibleText(language);
		return this;
	}
	
	/**
	 * Gets the error message from the login page.
	 * @return Returns the error message if available.
	 */
	public String getErrorMessage() {
		return txtError.getText();
	}
}
