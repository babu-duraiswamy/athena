package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.BrowserDriver;
import Utilities.Common;
import Utilities.FileReader;
import pages.LoginPageFunctions;

public class DataAdminPageTests extends TestRunner {
	static Properties configValues = new Properties();
	static Properties loginPageControls = new Properties();
	public static ChromeDriver driver = null;
	LoginPageFunctions login;

	DataAdminPageTests() throws IOException {
		InputStream configStream = FileReader.class.getClassLoader().getResourceAsStream("Config.properties");
		InputStream loginWindowStream = FileReader.class.getClassLoader()
				.getResourceAsStream("LoginPageControls.properties");
		configValues.load(configStream);
		loginPageControls.load(loginWindowStream);
		login = new LoginPageFunctions();
	}
	
	@BeforeMethod
	public void LoginToTheApplication() {
		login.Login(configValues.getProperty("dataAdminEmail"), configValues.getProperty("dataAdminPassword"));
	}
	
	@Test
	public void testDataAdminLogin() throws InterruptedException {
		String dataAdminEmail = configValues.getProperty("dataAdminEmail");
		String dataAdminPassword = configValues.getProperty("dataAdminPassword");
		login.Login(dataAdminEmail, dataAdminPassword);
		Common.ShortWait();
		assertTrue(BrowserDriver.driver.getCurrentUrl().contains("dashboard"));
	}
	
	@AfterMethod
	public void LogoutOfTheApplication() throws InterruptedException {
//		if(BrowserDriver.driver.getCurrentUrl().contains("login")==false)
//		login.Logout();
	}
}