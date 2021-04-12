
package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefiles/Problem1.feature" }, glue = {
		"classpath:stepdefinition",
		"classpath:helperclasses" }, plugin = { "pretty",
		"json:target/Problem1Runner.json" })
public class Problem1Runner extends AbstractTestNGCucumberTests {
}

