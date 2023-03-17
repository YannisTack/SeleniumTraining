package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	private WebDriver driver;

	@FindBy (xpath = "//div[@id='welcome']/h1")
	private WebElement txtWelcomeMessageTitle;
	
	@FindBy (xpath = "//div[@id='welcome']/h1/following-sibling::p")
	private WebElement txtWelcomeMessageContent1;
	
	@FindBy (xpath = "//input[@onclick='showBear()']")
	private WebElement btnShowBear;
	
	@FindBy (id = "bear")
	private WebElement imgBear;
	
	@FindBy (xpath = "//a[@href='admin.html']")
	private WebElement btnAdmin;
	
	@FindBy (id = "crudConnection")
	private WebElement btnNewConnection;
	
	public WelcomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String[] getWelcomeMessage( ) {
		String[] welcomeMsg = new String[] {
				txtWelcomeMessageTitle.getText(),
				txtWelcomeMessageContent1.getText()
		};
		return welcomeMsg;
	}
	
	public WelcomePage displayTheBear() {
		btnShowBear.click();
		return this;
	}
	
	public boolean isTheBearDisplayed() {
		return imgBear.isDisplayed();
	}
	
	public AdminPage navigateToAdminPage() {
		btnAdmin.click();
		return new AdminPage(driver);
	}
	
	public boolean isWelcomeMessageShown() {
		System.out.println("Bool: " + txtWelcomeMessageContent1.isDisplayed());
		return txtWelcomeMessageContent1.isDisplayed();
	}
	
	public NewConnectionPage navigateToNewConnectionPage() {
		btnNewConnection.click();
		return new NewConnectionPage(driver);
	}
}
