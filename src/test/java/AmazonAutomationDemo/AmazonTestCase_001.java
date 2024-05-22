package AmazonAutomationDemo;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjectModel.AmazonPage;
public class AmazonTestCase_001 {
	
	WebDriver driver;
	AmazonPage amz;
	Actions act;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		 amz = new AmazonPage(driver);
		 act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void signIn() throws InterruptedException
	{
		WebElement signIn  = driver.findElement(By.xpath("//a[@data-nav-ref='nav_signin']"));
		act.moveToElement(amz.signIn_div()).moveToElement(signIn).click().perform();
		Thread.sleep(3000);
	}
	@Test(priority = 2)
	public void login() throws InterruptedException
	{
		driver.findElement(amz.emailInput).clear();
		amz.setEmail("khorgadekrutika26@gmail.com","Manutai26*");
		Thread.sleep(2000);
		
	}
	@Test(priority = 2)
	public void validation()
	{
		String welcome_text = amz.validation();
		Assert.assertEquals(welcome_text,"Hello, Krutika");
	}
	
	@AfterClass
	private void tearDown()
	{
		driver.quit();
	}
}
