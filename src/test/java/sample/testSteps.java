package sample;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testSteps {

	WebDriver driver;
	WebDriverWait wait;

	@SuppressWarnings("deprecation")
	public testSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	@FindBy(how = How.ID, using = "landing_email")
	private WebElement email;

	@FindBy(how = How.ID, using = "registration_continue")
	private WebElement registration_continue;

	@FindBy(how = How.ID, using = "register_password")
	private WebElement register_password;

	@FindBy(how = How.ID, using = "registration_submit")
	private WebElement registration_submit;

	@FindBy(how = How.XPATH, using = "//ul[@class='form-errors except-email-opt-in']//li[@data-error-for-field='password']")
	private WebElement error;

	@FindBy(how = How.ID, using = "welcome-mat")
	private WebElement welcomeMat;

	public String validateTitle(String title) {
		if (driver.getTitle().equals(title)) {
			return "Title verified";
		} else {
			return "Title incorrect";
		}
	}

	public void enterEmail(String emailId) {
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		email.sendKeys(emailId);
	}

	public void clickToRegistrationContinue() {
		wait.until(ExpectedConditions.visibilityOf(registration_continue));
		wait.until(ExpectedConditions.elementToBeClickable(registration_continue));
		registration_continue.click();
	}

	public void enterPassword(String pass) {
		wait.until(ExpectedConditions.visibilityOf(register_password));
		register_password.clear();
		register_password.sendKeys(pass);
	}

	public void clickToregistration_submit() {
		wait.until(ExpectedConditions.visibilityOf(registration_submit));
		wait.until(ExpectedConditions.elementToBeClickable(registration_continue));
		registration_submit.click();
	}

	public void validateErrorMessage(String errorMessage) {
		assertEquals(error.getText().equals(errorMessage), null);
	}

	public void validateWelcomeMat() {
		
		assertEquals(welcomeMat.isDisplayed(), true);
	}

}
