package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectionsPage {
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Stats']")
	private WebElement btnNavigateToStats;
	
	public ConnectionsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public ConnectionsPage resetConnections()
	{
		((JavascriptExecutor)driver).executeScript("resetAddressBook(false)");
		return this;
	}
	
	public StatsPage navigateToStatsPage()
	{
		btnNavigateToStats.click();
		return new StatsPage(driver);
	}
}
