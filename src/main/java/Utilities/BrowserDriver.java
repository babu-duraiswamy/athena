package Utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriver {

	public static WebDriver driver;
	private String browserName;

	public BrowserDriver(String browserName) {
		this.browserName = browserName;
	}

	public void initializeDriver() {
		System.setProperty("webdriver.chrome.driver", "resources\\allBrowserDrivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public void navigateToUrl(String url) {
		driver.get(url);
	}

	public void closeDriver() {
		if (driver != null)
			driver.quit();
	}
}