package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ChildAvailable implements ExpectedCondition<Boolean> {

	private WebElement parent;
	private By childToLookFor;
	
	public ChildAvailable(WebElement parent, By childToLookFor)
	{
		this.parent = parent;
		this.childToLookFor = childToLookFor;
	}
	
	public Boolean apply(WebDriver driver) 
	{
		if (parent.findElement(childToLookFor) != null) {
			return true;
		}
		return false;
	}

}
