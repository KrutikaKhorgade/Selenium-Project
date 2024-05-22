package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"classpath:Feature/CucumberDemo.feature"}, 
		glue = "StepDefinition"
		
		
		
		
		)
public class TestRun {

}
