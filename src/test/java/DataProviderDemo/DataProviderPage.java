package DataProviderDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataProviderPage {

	WebDriver driver;
	
	public DataProviderPage(WebDriver driver) {
	this.driver = driver;
	}
	
	By txt_username = By.xpath("//input[@name='username']");
	By txt_password = By.xpath("//input[@name='password']");
	By btn_login = By.xpath("//button[@type='submit']");
	
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

}
