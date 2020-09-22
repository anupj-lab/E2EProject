package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver; // declare driver variable globally so all other methods in this class can access it
	public Properties prop;	// declare prop object globally, so other class can access prop and it's methods

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\anupj2\\eclipse-workspace\\E2Eproject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);  //to read data from data.properites file

		String browsername = prop.getProperty("browser");  //fetching browser value from properties file

		if (browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\anupj2\\Documents\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browsername.equals("firefox")) {

			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\anupj2\\Documents\\chromedriver.exe");
			driver = new FirefoxDriver();
		} else if (browsername.equals("IE")) {

			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\anupj2\\Documents\\chromedriver.exe");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void screenshots(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+ "\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
	}
}
