package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features= {"classpath:features"},glue= {"stepsDefinitions"},monochrome = true,dryRun = false,tags="@smoke",
             plugin= {"pretty","html:target/cucumber.html","json:target/cucumber.json"}
		
		)
public class MyRunner extends AbstractTestNGCucumberTests{

}
