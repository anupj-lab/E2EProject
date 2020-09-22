package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By signin = By.xpath("//div[@class='tools']//li[4]//a[1]");
	By title = By.xpath("//div[@class='container']//div[@class='text-center']");
	By navBar = By.xpath("//a[contains(text(),'Contact')]");

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getlogin() {
		return driver.findElement(signin);
	}

	public WebElement gettitle() {
		return driver.findElement(title);
	}

	public WebElement navigationBar() {
		return driver.findElement(navBar);
	}
}
