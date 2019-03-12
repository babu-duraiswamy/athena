package tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.BrowserDriver;
import Utilities.Common;
import Utilities.FileReader;
import pages.LoginPageFunctions;

public class LoginPageTests extends TestRunner {
	static Properties configValues = new Properties();
	static Properties loginPageControls = new Properties();
	public static ChromeDriver driver = null;
	LoginPageFunctions login;

	LoginPageTests() throws IOException {
		InputStream configStream = FileReader.class.getClassLoader().getResourceAsStream("Config.properties");
		InputStream loginWindowStream = FileReader.class.getClassLoader()
				.getResourceAsStream("LoginPageControls.properties");
		configValues.load(configStream);
		loginPageControls.load(loginWindowStream);
		login = new LoginPageFunctions();
	}

	@BeforeMethod
	public void LoginToTheApplication() {
		String userEmail = configValues.getProperty("userEmail");
		String userPassword = configValues.getProperty("userPassword");
		login.Login(userEmail, userPassword);
	}
	
	@Test
	public void testUserLogin() throws InterruptedException {
		Common.ShortWait();
		AssertJUnit.assertTrue(BrowserDriver.driver.getCurrentUrl().contains("dashboard"));
	}	
	
	@AfterMethod
	public void LogoutOfTheApplication() throws InterruptedException {
		login.Logout();
	}
}