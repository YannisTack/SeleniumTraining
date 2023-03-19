package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import customControls.StatsTable;
import customControls.Table;

public class StatsPage {
	private WebDriver driver;
	private Table statsTable;
	
	@FindBy(id="statsConnections")
	private WebElement divTable;
	
	public StatsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		statsTable = new StatsTable(divTable);
		
	}
	
	public String getTableCellText(int row, int col)
	{
		System.out.println("Returning cell text for stat '" + statsTable.getText(row, 0) + "'= " + statsTable.getText(row, col));
		return statsTable.getText(row, col);
	}
	
	public int getTableRowCount()
	{
		return statsTable.getRowCount();
	}

}
