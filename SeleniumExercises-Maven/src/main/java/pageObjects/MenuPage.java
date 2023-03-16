package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
	private WebDriver driver;
	
	@FindBy (id = "logout")
	private WebElement btnLogout;
	
	public MenuPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage logout() {
		btnLogout.click();
		return new LoginPage(driver);
	}
}
