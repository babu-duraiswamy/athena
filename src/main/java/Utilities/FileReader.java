package Utilities;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileReader{
    public static void main(String[] args) throws IOException {
        Properties configValues = new Properties();
        Properties loginPageControls = new Properties();
        InputStream config = FileReader.class.getClassLoader().getResourceAsStream("Config.properties");
        InputStream loginPageStream = FileReader.class.getClassLoader().getResourceAsStream("LoginPageControls.properties");
        configValues.load(config);
        loginPageControls.load(loginPageStream);
    }
}