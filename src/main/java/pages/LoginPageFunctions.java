package pages;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import UiComponents.Button;
import UiComponents.MenuItem;
import UiComponents.Textbox;
import Utilities.Common;
import Utilities.FileReader;

public class LoginPageFunctions {
	static Properties loginPageControls = new Properties();
	
	public LoginPageFunctions() throws IOException{
		InputStream loginWindowStream = FileReader.class.getClassLoader().getResourceAsStream("LoginPageControls.properties");
		loginPageControls.load(loginWindowStream);	
	}

	public void Login(String username, String password) {
		Textbox emailTextBox = new Textbox("Name", loginPageControls.getProperty("emailTextBox"));
		Textbox passwordTextBox = new Textbox("Name", loginPageControls.getProperty("passwordTextBox"));
		Button submitButton = new Button("XPath", loginPageControls.getProperty("submitButton"));
		emailTextBox.clearText();
		passwordTextBox.clearText();
		emailTextBox.setText(username);
		passwordTextBox.setText(password);		
		submitButton.click();		
	}
	
	public void Logout() throws InterruptedException {
		MenuItem loggedInUserMenuItem = new MenuItem("XPath",loginPageControls.getProperty("loggedInUserMenuItem"));
		MenuItem logoutMenuItem = new MenuItem("XPath",loginPageControls.getProperty("logoutMenuItem"));
		Common.MediumWait();
		loggedInUserMenuItem.click();
		logoutMenuItem.click();		
	}
}