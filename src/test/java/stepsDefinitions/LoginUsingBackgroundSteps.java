package stepsDefinitions;

import static com.cucumberpractice.drivers.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginUsingBackgroundSteps {
	
	private WebDriver driver=getDriver();

	
	@Given("I access the webdriver university login page")
	public void i_access_the_webdriver_university_login_page() {
		driver.get("https://webdriveruniversity.com/Login-Portal/index.html");
	}
	@When("I enter a username {string}")
	public void i_enter_a_username(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("text")).sendKeys(string);
	}
	@And("I enter a password {string}")
	public void i_enter_a_password(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("password")).sendKeys(string);
	}
	@And("I click on the login button")
	public void i_click_on_the_login_button() {
		driver.findElement(By.id("login-button")).click();
	}
	@Then("I should be presented with the successful login message")
	public void i_should_be_presented_with_the_successful_login_message() {
	
		String actaulText = driver.switchTo().alert().getText();
		Assert.assertEquals(actaulText, "validation succeeded");
		
	}
	
	@Then("I should be presented with the unsuccessful login message")
	public void i_should_be_presented_with_the_unsuccessful_login_message() {
		String actaulText = driver.switchTo().alert().getText();
		Assert.assertEquals(actaulText, "validation failed");
	}

	
	
}
