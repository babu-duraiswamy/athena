package pages;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import Utilities.FileReader;

public class DataAdminPageFunctions {
	static Properties dataAdminPageControls = new Properties();

	public DataAdminPageFunctions() throws IOException {
		InputStream chatPageStream = FileReader.class.getClassLoader()
				.getResourceAsStream("DataManagerPageControls.properties");
		dataAdminPageControls.load(chatPageStream);
	}
	
	public void createDataConnector() {
		
	}
	
//
//	public void searchDataset(String datasetToSearch) {
//		Textbox searchDatasetTextBox = new Textbox("XPath", chatPageControls.getProperty("searchDatasetTextBox"));
//		Button searchDatasetIcon = new Button("XPath", chatPageControls.getProperty("searchDatasetIcon"));
//		searchDatasetTextBox.setText(datasetToSearch);
//		searchDatasetIcon.click();
//	}
}