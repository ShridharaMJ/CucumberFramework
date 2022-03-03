package stepsDefinitions;

import com.cucumberpractice.pageobjects.pages.ContactUsPage;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps  {

	private ContactUsPage contactUsPage;

	public ContactUsSteps(ContactUsPage contactUsPage){
		this.contactUsPage=contactUsPage;
	}


	
	@Given("I access the webdriver univerisity contct us page")
	public void i_access_the_webdriver_univerisity_contct_us_page() {

       contactUsPage.navigateToContactUs();
	}

	@When("I enter a unique first name")
	public void i_enter_a_unique_first_name() {

		contactUsPage.enterFirstName(contactUsPage.generateRandom(5));
	}

	@And("I enter a unique last name")
	public void i_enter_a_unique_last_name() {

		contactUsPage.enterLastName(contactUsPage.generateRandom(5));
	}

	@And("I enter a unique email address")
	public void i_enter_a_unique_email_address() {


		contactUsPage.enterEmail("testingemail" + contactUsPage.generateRandom(5) + "@email.com");
	}

	@And("I enter a unique comment")
	public void i_enter_a_unique_comment() {

		contactUsPage.enterComments(contactUsPage.generateRandom(20));
	}

	@When("I enter a specific first name {word}")
	public void i_enter_a_specific_first_name(String string) {

		contactUsPage.enterFirstName(string);
	}

	@And("I enter a specific last name {word}")
	public void i_enter_a_specific_last_name(String string) {

		contactUsPage.enterLastName(string);
	}

	@And("I enter a specific email address {word}")
	public void i_enter_a_specific_email_address(String string) {
		contactUsPage.enterEmail(string);

	}

	@And("I enter a specific comment {string}")
	public void i_enter_a_specific_comment(String string) {
		// Write code here that turns the phrase above into concrete actions
		contactUsPage.enterComments(string);
	}

	@And("I click on Submit button")
	public void i_click_on_submit_button() {
		// Write code here that turns the phrase above into concrete actions
		contactUsPage.clickOnSubmit();
	}

	@Then("I should be presented with a successful contct us submission message")
	public void i_should_be_presented_with_a_successful_contct_us_submission_message() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(contactUsPage.isSuccessMessageDisplayed(),
				"Successfully logged contact us...");

	}

}
