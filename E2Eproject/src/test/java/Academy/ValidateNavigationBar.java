package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateNavigationBar extends base {
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver(); // accessing method from base class due to inheritance (extends)
		driver.get(prop.getProperty("url")); // using prop from base.java class; url is fetched from data.properties file
												

	}

	@Test
	public void validateNavbar() throws IOException {

		LandingPage lg = new LandingPage(driver);
		Assert.assertTrue(lg.navigationBar().isDisplayed());
		log.info("Navigationbar is displayed");

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
