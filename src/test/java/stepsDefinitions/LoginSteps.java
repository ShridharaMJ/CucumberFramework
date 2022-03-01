package stepsDefinitions;

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

public class LoginSteps {

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
