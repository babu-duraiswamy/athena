package tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Utilities.BrowserDriver;
import Utilities.FileReader;


public class TestRunner {
	static BrowserDriver driver = new BrowserDriver("Chrome");
	static Properties configValues = new Properties();
	
	TestRunner() throws IOException{
		InputStream configStream = FileReader.class.getClassLoader().getResourceAsStream("Config.properties");
	    configValues.load(configStream);
	}
	
	@BeforeSuite
	public static void initialize() {
		driver.initializeDriver();
		driver.navigateToUrl(configValues.getProperty("url"));
	}

	@AfterSuite
	public static void tearDown() {
		driver.closeDriver();
	}
}