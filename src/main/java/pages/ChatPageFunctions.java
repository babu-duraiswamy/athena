package pages;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import UiComponents.Button;
import UiComponents.MenuItem;
import UiComponents.Textbox;
import Utilities.BrowserDriver;
import Utilities.Common;
import Utilities.FileReader;

public class ChatPageFunctions {
	static Properties chatPageControls = new Properties();
	static MenuItem returnedDatasets = null;

	public ChatPageFunctions() throws IOException {
		InputStream chatPageStream = FileReader.class.getClassLoader()
				.getResourceAsStream("ChatPageControls.properties");
		chatPageControls.load(chatPageStream);
	}

	public void searchDataset(String datasetToSearch) throws InterruptedException {
		Textbox searchDatasetTextBox = new Textbox("XPath", chatPageControls.getProperty("searchDatasetTextBox"));
		Button searchDatasetIcon = new Button("XPath", chatPageControls.getProperty("searchDatasetIcon"));
		searchDatasetTextBox.setText(datasetToSearch);
		Common.MediumWait();
		searchDatasetIcon.click();
		Common.ShortWait();
		MenuItem returnedDatasets = new MenuItem("XPath", chatPageControls.getProperty("returnedDatasets"));
		returnedDatasets.click();
	}

	public String getDataset() {
		return returnedDatasets.getText();
	}

	public int gotoPinBoard() {
		String pinBoardIcon = chatPageControls.getProperty("pinBoardIcon");
		String pinBoardDropDownMenu = chatPageControls.getProperty("pinBoardDropDownMenu");
		Actions actions = new Actions(BrowserDriver.driver);
		actions.moveToElement(BrowserDriver.driver.findElement(By.xpath(pinBoardIcon))).build().perform();
		actions.moveToElement(BrowserDriver.driver.findElement(By.xpath(pinBoardDropDownMenu))).click().build()
				.perform();
		return 0;
	}

	public void runRequest(String requestForPinBoardTest) throws InterruptedException {
		Common.MediumWait();
		Textbox requestSpace = new Textbox("XPath", chatPageControls.getProperty("requestSpaceTextBox"));
		requestSpace.setText(requestForPinBoardTest);
		requestSpace.typeEnter();
		Common.LongWait();
	}

	public void addToPinBoard() throws InterruptedException {
		Actions actions = new Actions(BrowserDriver.driver);
		actions.moveToElement(
				BrowserDriver.driver.findElement
				(By.xpath(chatPageControls.getProperty("lastReturnedChart")))).build().perform();
		actions.moveToElement(
				BrowserDriver.driver.findElement
				(By.xpath(chatPageControls.getProperty("lastReturnedChart")))).click().build().perform();
		Common.ShortWait();
		Button pinBoardMenuItemInPopup = new Button("XPath",chatPageControls.getProperty("pinBoardMenuItemInPopup"));
		pinBoardMenuItemInPopup.click();
		Common.MediumWait();
		
	}

	public void searchAndChoosePinBoard() {
		// TODO Auto-generated method stub
	}

	public String getLastSavedPinBoardItemTitle() {
		return null;
	}
}