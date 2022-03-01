package stepsDefinitions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactUsSteps {

	private WebDriver driver;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		option.addArguments("--headless");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	public String generateRandom(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	@Given("I access the webdriver univerisity contct us page")
	public void i_access_the_webdriver_univerisity_contct_us_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
	}

	@When("I enter a unique first name")
	public void i_enter_a_unique_first_name() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Testing FirstName " + generateRandom(5));

	}

	@And("I enter a unique last name")
	public void i_enter_a_unique_last_name() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Testing LastName " + generateRandom(5));
	}

	@And("I enter a unique email address")
	public void i_enter_a_unique_email_address() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name='email']"))
				.sendKeys("testingemail" + generateRandom(5) + "@email.com");
	}

	@And("I enter a unique comment")
	public void i_enter_a_unique_comment() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//textarea[@name='message']"))
				.sendKeys("testingemail" + generateRandom(20) + "@email.com");
	}

	@When("I enter a specific first name {word}")
	public void i_enter_a_specific_first_name(String string) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(string);
	}

	@And("I enter a specific last name {word}")
	public void i_enter_a_specific_last_name(String string) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(string);
	}

	@And("I enter a specific email address {word}")
	public void i_enter_a_specific_email_address(String string) {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(string);

	}

	@And("I enter a specific comment {string}")
	public void i_enter_a_specific_comment(String string) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(string);
	}

	@And("I click on Submit button")
	public void i_click_on_submit_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@value='SUBMIT']"))
				.sendKeys("Testing WebDriver University Page" + new Random().nextInt());
	}

	@Then("I should be presented with a successful contct us submission message")
	public void i_should_be_presented_with_a_successful_contct_us_submission_message() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='contact_reply']")).isDisplayed(),
				"Successfully logged contact us...");

	}

}
