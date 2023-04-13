package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Manages webdrivers and stores the active one as singleton.
 * @author ytack
 *
 */
public class DriverManager {
	private static WebDriver driver;
	private static EventFiringWebDriver eDriver;
	
	public static WebDriver getDriver() {
		if (driver == null) {
			setEdgeDriver();
		}
		return driver;
	}
	
	public static EventFiringWebDriver getEDriver() {
		if (eDriver == null) {
			setEdgeEDriver();
		}
		return eDriver;
	}
	
	public static void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\YTACK\\Documents\\SeleniumWebDrivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}

	public static void setFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\YTACK\\Documents\\SeleniumWebDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	public static void setEdgeDriver() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\YTACK\\Documents\\SeleniumWebDrivers\\msedgedriver.exe");
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new EdgeDriver(options);
	}
	
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	public static void setChromeEDriver() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\YTACK\\Documents\\SeleniumWebDrivers\\chromedriver.exe");
		eDriver = new EventFiringWebDriver(getDriver());
		eDriver.register(new EListener());
	}
	
	public static void setEdgeEDriver() {
//		System.setProperty("webdriver.edge.driver", "C:\\Users\\YTACK\\Documents\\SeleniumWebDrivers\\msedgedriver.exe");
		eDriver = new EventFiringWebDriver(getDriver());
		eDriver.register(new EListener());
	}
}
