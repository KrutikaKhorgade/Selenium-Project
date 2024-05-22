package BlazeDemoTestCase;
import PageObjectModel.LoginPage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class TestCase_002 {
	
	WebDriver driver;
	LoginPage loginPage;
	
  @Test
  public void enterData() {
	  driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Krutika Khorgade");
	  driver.findElement(By.xpath("//input[@name='address']")).sendKeys("29 Gold Coast");
	  driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Pune");
	  driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Maharashtra");
	  driver.findElement(By.xpath("//input[@name='zipCode']")).sendKeys("411015");
	  
	  List <WebElement>cT = loginPage.cardType();
	  for(WebElement cardtype : cT)
	  {
	  Select card = new Select(cardtype);
	  card.selectByVisibleText("American Express");
	  }  
	  
	  
	  
	  driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("987612304678");
	  driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("11");
	  driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2029");
	  driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Krutika Khorgade");
	  driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
	  driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
  }
 
  
 	@AfterClass
 	public void tearDown() {
 		driver.quit();
 	}

}
