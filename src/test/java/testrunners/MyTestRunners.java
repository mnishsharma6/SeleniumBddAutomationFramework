package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com/features"},
        glue = {"stepdefinitions", "AppHooks"},
        tags = "@AllLogin",
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json",
        		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        		"rerun:target/failedrerun.txt"},
        monochrome = true,
        publish = true
)
public class MyTestRunners {
	

}
