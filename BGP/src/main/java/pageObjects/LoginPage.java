package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import dataProviders.EnvPropertyManager;
import utilities.TestContext;

public class LoginPage extends BasePage {

	@FindBy(how = How.ID, using = "login-button")
	private WebElement loginButton;

	@FindBy(how = How.CSS, using = "input[name='CPUID']")
	private WebElement nricTextbox;

	@FindBy(how = How.CSS, using = "input[name='CPUID_FullName']")
	private WebElement fullName;

	@FindBy(how = How.CSS, using = "input[name='CPEntID']")
	private WebElement uenTextbox;

	@FindBy(how = How.CSS, using = "select[name='CPRole']")
	private WebElement roleDropdown;

	@FindBy(how = How.XPATH, using = "//select[@name='CPRole']/following::button[@type='submit']")
	private WebElement login;

	public LoginPage(TestContext context) {
		super(context);
	}

	public void launchUrl(String username, String password, String url) {
		driver.get("https://" + username + ":" + password + "@" + url);
	}

	public void login(String nric, String name, String uen, String role) {
		elementFactory.javaScriptExecutorClick(loginButton);
		elementFactory.enterTextBox(nricTextbox, nric);
		elementFactory.enterTextBox(fullName, name);
		elementFactory.enterTextBox(uenTextbox, uen);
		elementFactory.elementSelectDropDown(roleDropdown, role);
		elementFactory.elementClick(login);
		driver.manage().timeouts().pageLoadTimeout(EnvPropertyManager.getImplicitWaitInMilliSeconds(),
				TimeUnit.MILLISECONDS);
	}

}
