package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonPage {
	
	WebDriver driver;
	
	
	public AmazonPage(WebDriver driver) {
		this.driver=driver;
	}

 By signIn_div = By.xpath("//a[@data-nav-ref='nav_ya_signin']");
 public By emailInput = By.xpath("//input[@id = 'ap_email']");
 By submit_btn = By.xpath("//input[@type = 'submit']");
 By text = By.xpath("//div[@class='nav-line-1-container']/span");

public WebElement signIn_div()
{
	WebElement signInElement = driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_ya_signin']"));
	return signInElement;
}
public void setEmail(String email, String pwd)
{
	driver.findElement(emailInput).sendKeys(email);
	driver.findElement(submit_btn).click();
	driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(pwd);
	driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
}


public String validation() {
	String userName = driver.findElement(text).getText();
	return userName;
}
}