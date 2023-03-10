package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	@FindBy (how = How.CLASS_NAME, using = "content")
	private WebElement btnLogin;
	
	@FindBy (how = How.ID, using = "username")
	private WebElement txtUsername;
	
	@FindBy (how = How.ID, using = "password")
	private WebElement txtPassword;
	
	@FindBy (how = How.ID, using = "language")
	private WebElement drpLanguage;
	
	@FindBy (how = How.XPATH, using = "//p[@class='error']")
	private WebElement txtError;
	
	public void loginWith(String username, String password) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public void loginAsAdmin() {
		loginWith("admin", "superduper");
	}
	
	public void setLanguageTo(String language) {
		Select slctLanguage = new Select(drpLanguage);
		slctLanguage.selectByVisibleText(language);
	}
	
	public String GetErrorMessage() {
		return txtError.getText();
	}
}
