package tests;

import static org.testng.Assert.assertTrue;
import java.io.IOException;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.BrowserDriver;
import Utilities.Common;
import Utilities.FileReader;

import pages.ChatPageFunctions;
import pages.LoginPageFunctions;

public class ChatPageTests extends TestRunner {
	static Properties configValues = new Properties();
	static Properties chatPageControls = new Properties();
	String datasetToSearch = null; 
	ChatPageFunctions chatPage;
	LoginPageFunctions login;

	ChatPageTests() throws IOException {
		InputStream configStream = FileReader.class.getClassLoader()
				.getResourceAsStream("Config.properties");
		InputStream chatPageStream = FileReader.class.getClassLoader()
				.getResourceAsStream("ChatPageControls.properties");
		configValues.load(configStream);
		chatPageControls.load(chatPageStream);
		chatPage = new ChatPageFunctions();
		login = new LoginPageFunctions();
		datasetToSearch = configValues.getProperty("searchDataset");
	}
	
//	@BeforeTest
//	public void LoginIfNeeded() {
//		if(Common.CheckCurrentPage().contains("dashboard")) {
//			return;
//		}
//		else {
//			login.Login(configValues.getProperty("userEmail"), configValues.getProperty("userPassword"));
//		}
//	}
	
	@BeforeMethod
	public void LoginToTheApplication() {
		login.Login(configValues.getProperty("userEmail"), configValues.getProperty("userPassword"));
	}
	
//	@Test
//	public void testSearchDataset() throws InterruptedException {
//		chatPage.searchDataset(datasetToSearch);
//		assertTrue(chatPage.getDataset().contains(datasetToSearch));
//	}
//	
	@Test
	public void testPinboard() throws InterruptedException {
		chatPage.searchDataset(datasetToSearch);
		String requestForPinBoardTest = chatPageControls.getProperty("requestForPinBoardTest");
		chatPage.runRequest(requestForPinBoardTest);
		chatPage.addToPinBoard();
//		chatPage.gotoPinBoard();
//		chatPage.searchAndChoosePinBoard();
//		System.out.println(chatPage.getLastSavedPinBoardItemTitle());
	}

//	@AfterMethod
//	public void LogoutOfTheApplication() throws InterruptedException {
//		if(BrowserDriver.driver.getCurrentUrl().contains("login")==false)
//		login.Logout();
//	}
}