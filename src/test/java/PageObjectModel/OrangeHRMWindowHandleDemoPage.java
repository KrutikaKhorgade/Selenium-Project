package PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OrangeHRMWindowHandleDemoPage {
	WebDriver driver = null;
	public OrangeHRMWindowHandleDemoPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By txt_username = By.xpath("//input[@name='username']");
	By txt_password = By.xpath("//input[@name='password']");
	By btn_login = By.xpath("//button[@type='submit']");
	By list_option = By.xpath("//ul[@class='oxd-main-menu']/li");
	By valid_txt = By.xpath("//h6[text()='Personal Details']");
	By logo_img = By.xpath("//img[@alt = 'client brand banner']");
	By status_txt = By.xpath("//p[text()='Invalid credentials']");
	//By invalid_status = By.xpath("//p[text()='Invalid credentials']");)
	
	public void openURL()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	public void setUsername(String username)
	{
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		driver.findElement(txt_password).sendKeys(password);
	}
	public void clickLogin()
	{
		driver.findElement(btn_login).click();
	}
	public List<WebElement> selectOption()
	{
		List<WebElement>list = driver.findElements(list_option);
		return list;
	}
	public String validation()
	{
		String text = driver.findElement(valid_txt).getText();
		return text;
	}
	public boolean dashboardValidate()
	{
		boolean status = driver.findElement(logo_img).isDisplayed();
		return status;
		
	}
	public String invalidValidation()
	{
		String status = driver.findElement(status_txt).getText();
		return status;
	}
	}


