package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import dataHolders.Person;

public class NewConnectionPage {
	private WebDriver driver;
	
	@FindBy(id="firstName")
	private WebElement fldFirstName;
	@FindBy(id="lastName")
	private WebElement fldLastName;
	@FindBy(id="sex")
	private WebElement selSex;
	@FindBy(id="email")
	private WebElement fldEmail;
	@FindBy(id="telephone")
	private WebElement fldTelephone;
	@FindBy(id="company")
	private WebElement fldCompany;
	@FindBy(id="SSU")
	private WebElement selSSU;
	@FindBy(id="seniority")
	private WebElement selSeniority;
	@FindBy(id="add")
	private WebElement btnAdd;
	@FindBy(xpath="//div[@id='errors']//p[@class='feedback']")
	private WebElement txtFeedback;
	@FindBy(xpath="//a[text()='Stats']")
	private WebElement btnNavigateToStats;
	
	public NewConnectionPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public NewConnectionPage addConnection(Person p)
	{
		fldFirstName.sendKeys(p.getFirstName());
		fldLastName.sendKeys(p.getName());
		// Set sex
		Select drpSex = new Select(selSex);
		drpSex.selectByVisibleText(p.getSex());
		fldEmail.sendKeys(p.getEmail());
		fldTelephone.sendKeys(p.getTelephone());
		fldCompany.sendKeys(p.getCompany());
		// Set SSU
		Select drpSSU = new Select(selSSU);
		drpSSU.selectByVisibleText(p.getSSU());
		// Set seniority
		Select drpSeniority = new Select(selSeniority);
		drpSeniority.selectByVisibleText(p.getSeniority());
		btnAdd.click();
		
		return this;
	}
	
	public boolean isCreationFeedbackDisplayed(Person p)
	{
		//return true;
		// TODO - Find out why txtFeedback cannot be found!
		return txtFeedback.getText().equals("Connection '" + p.getFirstName() + " " + p.getName() + " added.");
	}
	
	public StatsPage navigateToStatsPage()
	{
		btnNavigateToStats.click();
		return new StatsPage(driver);
	}
}
