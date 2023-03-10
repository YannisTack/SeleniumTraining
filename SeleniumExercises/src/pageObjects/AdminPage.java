package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminPage {

	@FindBy (how = How.XPATH, using = "//div[@id='admin']//label[contains(text(), 'reset user')]/parent::td")
	private WebElement btnResetUsers;
	
	@FindBy (how = How.ID, using = "new_username")
	private WebElement txtUsername;
	
	@FindBy (how = How.ID, using = "new_password")
	private WebElement txtPassword;
	
	@FindBy (how = How.XPATH, using = "//div[@id='admin']//span[contains(text(), 'create')]/parent::td")
	private WebElement btnCreateNewUser;
	
	public void resetUsers() {
		btnResetUsers.click();
	}
	
	public void createNewUserWith(String username, String password) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		btnCreateNewUser.click();
	}
}
