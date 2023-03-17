package customControls;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StatsTable implements Table {
	private WebElement divTable;

	public StatsTable(WebElement table)
	{
		this.divTable=table;
	}
	
	public int getRowCount() {
		// TODO Auto-generated method stub
		return divTable.findElements(By.xpath(".//tr")).size();
	}

	public String getText(int row, int col) {
		// TODO Auto-generated method stub
		List<WebElement> rows = divTable.findElements(By.xpath(".//tr"));
		try {
			List<WebElement> rowCols = rows.get(row).findElements(By.xpath(".//td"));
			return rowCols.get(col).getText();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("The requested table cell does not exist.");
			return null;
		}
	}

}
