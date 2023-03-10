package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomePage {

	@FindBy (how = How.XPATH, using = "//div[@id='welcome']/h1")
	private WebElement txtWelcomeMessageTitle;
	
	@FindBy (how = How.XPATH, using = "//div[@id='welcome']/h1/following-sibling::p")
	private WebElement txtWelcomeMessageContent1;
	
	@FindBy (how = How.XPATH, using = "//input[@onclick='showBear()']")
	private WebElement btnShowBear;
	
	@FindBy (how = How.ID, using = "bear")
	private WebElement imgBear;
	
	@FindBy (how = How.XPATH, using = "//a[@href='admin.html']")
	private WebElement btnAdmin;
	
	public String[] getWelcomeMessage( ) {
		String[] welcomeMsg = new String[] {
				txtWelcomeMessageTitle.getText(),
				txtWelcomeMessageContent1.getText()
		};
		return welcomeMsg;
	}
	
	public void displayTheBear() {
		btnShowBear.click();
	}
	
	public boolean isTheBearDisplayed() {
		return imgBear.isDisplayed();
	}
	
	public void navigateToAdminPage() {
		btnAdmin.click();
	}
	
	public boolean isWelcomeMessageShown() {
		return txtWelcomeMessageContent1.isDisplayed();
	}
}
