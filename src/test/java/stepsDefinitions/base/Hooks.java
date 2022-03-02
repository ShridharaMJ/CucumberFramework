package stepsDefinitions.base;

import static com.cucumberpractice.drivers.DriverFactory.cleanupDriver;
import static com.cucumberpractice.drivers.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	public WebDriver driver;

	@Before
	public void setUp() {
		getDriver();
	}

	@After
	public void tearDown() {
		cleanupDriver();
	}

	@AfterStep
	public void captureExceptionImage(Scenario scenario) throws IOException {
       
		if(scenario.isFailed()) {
		
		LocalDateTime time = LocalDateTime.now();
		String timeString = time.toString();
		byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", timeString);
		
		}
	}
}