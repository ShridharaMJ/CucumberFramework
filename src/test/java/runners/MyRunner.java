package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features= {"classpath:features"},glue= {"stepsDefinitions"},monochrome = true,dryRun = false,tags="@e2etest",
             plugin= {"pretty","html:target/cucumber.html","json:target/cucumber.json"}
		
		)
public class MyRunner extends AbstractTestNGCucumberTests{

	
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
	
}
