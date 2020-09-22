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

public class ValidateTitleTest extends base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver(); // accessing method from base class due to inheritance (extends)
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url")); // using prop from base.java class; url is fetched from data.properties
												// file
		log.info("Navigated to HomePage");
	}

	@Test
	public void validateTitle() throws IOException {

		LandingPage lg = new LandingPage(driver);
		// Assert.assertEquals(lg.gettitle().getText(), "Featured Courses");
		Assert.assertEquals(lg.gettitle().getText(), "FEATURED CO1URSES");
		log.info("Validated Title- 'Featured Courses'");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
