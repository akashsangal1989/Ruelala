package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleClass {
	WebDriver driver;

	@Test
	public void InitateDriver() {

		try {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			option.addArguments("start-maximized");
			option.addArguments("--incognito");
			driver = new ChromeDriver(option);
			String url = ConfigFactorysample.getconfig().app().toString();
			driver.get(url);
			ExecuteScenarios(driver);
			driver.close();
			driver.quit();
		} catch (Exception e) {
			catchExceptionClass(e);
			driver.close();
			driver.quit();
		}

	}

	public void ExecuteScenarios(WebDriver driver) {
		testSteps test = new testSteps(driver);
		preCondition(test);
		// Scenario 1 --> enter pass as null character
		validateScenarios(test, null, "Password must be at least 10 characters.");
		// Scenario 2 --> enter pass as 1 character
		validateScenarios(test, "1", "Password must be at least 10 characters.");
		// Scenario 4 --> enter pass as 7 character
		validateScenarios(test, "1234567", "Password must be at least 10 characters.");
		// Scenario 5 --> enter pass as 9 character
		validateScenarios(test, "123456789", "Password must be at least 10 characters.");
		// Scenario 6 --> enter pass as 10 character
		validateSuccessLogin(test, "0123456789");
	}

	public void catchExceptionClass(Exception e) {
		System.out.println(e.getMessage());

	}

	public void preCondition(testSteps steps) {
		steps.validateTitle("Rue La La — Boutiques");
		steps.enterEmail("akash.sangal1989@gmail.com");
		steps.clickToRegistrationContinue();
	}

	public void validateScenarios(testSteps steps, String pass, String errorMeesage) {
		steps.enterPassword(pass);
		steps.clickToregistration_submit();
		steps.validateErrorMessage(errorMeesage);
	}

	public void validateSuccessLogin(testSteps steps, String pass) {
		steps.enterPassword(pass);
		steps.clickToregistration_submit();
		steps.validateWelcomeMat();
	}
}
