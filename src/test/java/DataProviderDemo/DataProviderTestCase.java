package DataProviderDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTestCase {
	
	WebDriver driver;
	DataProviderPage obj1;
	
	@BeforeClass
	private void setup()
	{
		driver = new ChromeDriver();
		obj1 = new DataProviderPage(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@DataProvider(name="data")
	private String [][] loginData()
	{
		String data [][] = {{"jndkjvds","djndsk"},{"kjdsl","jhcbjh"},{"newer","wrong123"},{"Admin", "admin123"}};
	    return data;
	}
	
	@Test(dataProvider="data")
	public void login(String username, String password) throws InterruptedException
	{
		
		obj1.setUsername(username);
		Thread.sleep(2000);
		obj1.setPassword(password);
		Thread.sleep(1000);
		obj1.clickLogin();
		Thread.sleep(2000);
	}
	@AfterClass
	private void tearDown()
	{
	   driver.quit();	
	}

}
