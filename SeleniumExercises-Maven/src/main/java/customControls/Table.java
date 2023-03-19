package customControls;
import org.openqa.selenium.WebElement;

public interface Table {
	int getRowCount();
	String getText(int row, int col);
}
