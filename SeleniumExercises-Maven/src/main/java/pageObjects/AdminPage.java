package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	private WebDriver driver;

	@FindBy (xpath = "//div[@id='admin']//label[contains(text(), 'reset user')]/parent::td")
	private WebElement btnResetUsers;
	
	@FindBy (id = "new_username")
	private WebElement txtUsername;
	
	@FindBy (id = "new_password")
	private WebElement txtPassword;
	
	@FindBy (xpath = "//div[@id='admin']//span[contains(text(), 'create')]/parent::td")
	private WebElement btnCreateNewUser;
	
	public AdminPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AdminPage resetUsers() {
		btnResetUsers.click();
		return new AdminPage(driver);
	}
	
	public AdminPage createNewUserWith(String username, String password) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		btnCreateNewUser.click();
		return new AdminPage(driver);
	}
}
