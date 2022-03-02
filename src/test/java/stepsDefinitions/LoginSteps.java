package stepsDefinitions;

import static com.cucumberpractice.drivers.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps  {

	
	private WebDriver driver=getDriver();
	
	
	@Given("I navigate to login page")
	public void i_navigate_to_login_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://webdriveruniversity.com/Login-Portal/index.html");
	}

	@When("I enter valid username  {string}")
	public void i_enter_valid_username(String string) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("text")).sendKeys(string);
	}

	@And("I enter valid   password {string}")
	public void i_enter_valid_password(String string) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("password")).sendKeys(string);

	}

	@And("I should get validation alert with  {string}")
	public void i_should_get_validation_alert_with(String string) {
		// Write code here that turns the phrase above into concrete actions
		String actaulText = driver.switchTo().alert().getText();
		Assert.assertEquals(actaulText, string);
	}

	
	@And("I click on login") 
	public void i_click_on_login() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("login-button")).click();
	}
	
	
	@Then("I should get validation falied alert")
	public void i_should_get_validation_falied_alert() {
		// Write code here that turns the phrase above into concrete actions
		String actaulText = driver.switchTo().alert().getText();
		Assert.assertEquals(actaulText, "validation failed");
	}

}
