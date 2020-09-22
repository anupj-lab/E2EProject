package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver(); // accessing method from base class due to inheritance (extends)
		driver.get(prop.getProperty("url")); // using prop from base.java class; url is fetched from data.properties file
		LandingPage lg = new LandingPage(driver);
		lg.getlogin().click();
												
	}

	@Test(dataProvider = "getData")

	public void basepageNavigation(String username, String psswd) throws IOException {

	
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(psswd);
		lp.HitLogin().click();
		log.info("credentails entered");

	}

	@DataProvider // Using DataProvider to run tests for multiple data sets

	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "user1@gmail.com";
		data[0][1] = "123456";
		data[1][0] = "user2@abc.com";
		data[1][1] = "123456";
		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
