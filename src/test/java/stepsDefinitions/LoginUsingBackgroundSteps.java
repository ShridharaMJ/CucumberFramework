package stepsDefinitions;

import static com.cucumberpractice.drivers.DriverFactory.getDriver;

import com.cucumberpractice.pageobjects.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginUsingBackgroundSteps {


	private LoginPage loginPage;
	public LoginUsingBackgroundSteps(LoginPage loginPage){
		this.loginPage=loginPage;
	}

	
	@Given("I access the webdriver university login page")
	public void i_access_the_webdriver_university_login_page() {
		loginPage.navigateToLoginPage();
	}
	@When("I enter a username {string}")
	public void i_enter_a_username(String string) {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.enterUserName(string);
	}
	@And("I enter a password {string}")
	public void i_enter_a_password(String string) {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.enterPassword(string);
	}
	@And("I click on the login button")
	public void i_click_on_the_login_button() {
		loginPage.clickOnLogin();
	}
	@Then("I should be presented with the successful login message")
	public void i_should_be_presented_with_the_successful_login_message() {
	

		loginPage.verifyAlertMessage("validation succeeded");
	}
	
	@Then("I should be presented with the unsuccessful login message")
	public void i_should_be_presented_with_the_unsuccessful_login_message() {

		loginPage.verifyAlertMessage("validation failed");
	}

	
	
}
