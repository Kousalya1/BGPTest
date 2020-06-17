package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverManager;
import utilities.ElementFactory;
import utilities.ScenarioContext;
import utilities.TestContext;

public class BasePage {

	protected TestContext testContext;
	protected WebDriver driver;
	protected DriverManager driverManager;
	protected ElementFactory elementFactory;
	protected ScenarioContext scenarioContext;
	
	public BasePage(TestContext context) {
		this.testContext = context;
		driver = testContext.getWebDriver();
		PageFactory.initElements(driver, this);
		driverManager = testContext.getDriverManager();
		elementFactory = testContext.getElementFactory();
		scenarioContext = testContext.getScenarioContext();
	}

}
