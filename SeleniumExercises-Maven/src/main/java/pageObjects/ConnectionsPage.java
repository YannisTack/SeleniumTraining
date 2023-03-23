package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataHolders.Person;
import utils.ChildAvailable;
import utils.DriverManager;

public class ConnectionsPage {
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Stats']")
	private WebElement btnNavigateToStats;
	@FindBy(id="searchTerm")
	private WebElement fldSearchTerm;
	@FindBy(id="searchBy")
	private WebElement selSearchBy;
	@FindBy(id="records")
	private WebElement divMyConnections;
	
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
	
	public ConnectionsPage searchByLastName(String lastName)
	{
		new Select(selSearchBy).selectByVisibleText("last name");
		fldSearchTerm.sendKeys(lastName);
		return this;
	}
	
	public Boolean isConnectionAdded(Person p)
	{
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(2000));
		wait.until(new ChildAvailable(divMyConnections, By.className("name")));
		
		if (divMyConnections.findElement(By.className("name")).getText().contains(p.getName()) &&
				divMyConnections.findElement(By.className("name")).getText().contains(p.getFirstName())){
			return true;
		}
		return false;
	}
}
