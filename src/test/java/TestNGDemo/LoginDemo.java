package TestNGDemo;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
public class LoginDemo {
  WebDriver driver;
  
  
@Test(priority = 1)
  public void openURL() throws InterruptedException 
  {
	driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
	
  }
  
  @Test(priority = 2)
  public void login() throws InterruptedException 
  {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.findElement(By.name("username")).sendKeys("Admin");
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(5000);
	  
  }
  
  @Test(priority = 3)
  public void Validation() 
  {
	  String expectedTitle = "OrangeHRM";
	  String actual_Title = driver.getTitle();
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(actual_Title, expectedTitle);
  }
  
  @Test(priority = 4)
  public void exitApp() 
  {
	  driver.quit();
  }
  
}
