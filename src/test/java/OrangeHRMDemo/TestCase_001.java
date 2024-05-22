package OrangeHRMDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjectModel.OrangeHRMWindowHandleDemoPage;

public class TestCase_001 {
WebDriver driver = null;
OrangeHRMWindowHandleDemoPage obj;

@BeforeClass
public void setup()
{
	driver = new ChromeDriver();
	obj = new OrangeHRMWindowHandleDemoPage(driver);
	
	obj.openURL();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Test
public void login()
{
	obj.openURL();
	obj.setUsername("Admin");
	obj.setPassword("admin123");
	obj.clickLogin();
}

@Test(priority = 1)
public void selectOption() throws InterruptedException
{
	List<WebElement> list = obj.selectOption();
	for(WebElement option : list)
	{
		if(option.getText().equals("My Info"))
		{
			option.click();
			break;
			
		}

	}
	Thread.sleep(3000);
}
@Test(priority = 3)
public void validation()
{
	obj.validation();
}

@AfterClass
public void tearDown()
{
	driver.quit();
}
}
