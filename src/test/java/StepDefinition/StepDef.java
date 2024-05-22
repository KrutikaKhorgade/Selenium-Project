package StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjectModel.OrangeHRMWindowHandleDemoPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	
	WebDriver driver;
	OrangeHRMWindowHandleDemoPage obj;
	
	
//	@Before
	private void setup() {
		driver = new ChromeDriver();
		this.obj = new OrangeHRMWindowHandleDemoPage(driver);
		System.out.println("This is obj : "+obj);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Given("user is providing valid credentials")
	public void user_is_providing_valid_credentials() {
		setup();
		this.obj.setUsername("Admin");
		obj.setPassword("admin123");
		
	    
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		obj.clickLogin();
	}

	@Then("user is directed to main page")
	public void user_is_directed_to_main_page() {
	   Assert.assertEquals(obj.dashboardValidate(),true);
	   tearDown();
		
	}
	
	
	@Given("user is providing invalid credentials")
	public void user_is_providing_invalid_credentials() {
	   setup();
	   this.obj.setUsername("Admin123");
		obj.setPassword("admin");
	}

	
	@Then("user should not be logged in")
	public void user_should_not_be_logged_in() {
		String status = obj.invalidValidation();
		Assert.assertEquals(status, "Invalid credentials");
		   tearDown();
	}
	
	
	private void tearDown()
	{
		driver.quit();
	}

}
