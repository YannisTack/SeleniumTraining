package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import dataHolders.Person;

public class NewConnectionPage {
	private WebDriver driver;
	
	@FindBy(id="firstname")
	private WebElement fldFirstName;
	@FindBy(id="lastname")
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
	
	public NewConnectionPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
		// Set seniority
		btnAdd.click();
		
		return this;
	}
}
