package BlazeDemoTestCase;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import PageObjectModel.LoginPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase_001 {
	LoginPage loginPage;
	WebDriver driver;

	@BeforeClass
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(priority = 1)
	public void getValues() {

		List<WebElement> getDepCity = loginPage.getDepartureCity();
		for (WebElement depCity : getDepCity) {
			System.out.println(depCity.getText());
		}
		List<WebElement> getDesCity = loginPage.getDestinationCity();
		for (WebElement desCity : getDesCity) {
			System.out.println(desCity.getText());
		}
	}

	@Test(priority = 2)
	public void setValues() throws InterruptedException {

		List<WebElement> getDepCity = loginPage.getDepartureCity();

		for (WebElement depCity : getDepCity) {
			Select dpc = new Select(depCity);
			dpc.selectByVisibleText("Portland");
		}
		List<WebElement> getDesCity = loginPage.getDestinationCity();
		for (WebElement desCity : getDesCity) {
			Select dsc = new Select(desCity);
			dsc.selectByVisibleText("Dublin");
		}
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void clickFindFlights() {
		loginPage.clickFindFlights();
	}

	@Test(priority = 4)
	public void findCheapFlights() throws InterruptedException {
		List<WebElement> fPrices = loginPage.findCheapFlight();
		List<Double> prices = new ArrayList<Double>();

		for (WebElement fP : fPrices) {
			String[] fp = fP.getText().split("\\$");
			System.out.println(fp[1]);
			prices.add(Double.parseDouble(fp[1]));

		}
		Collections.sort(prices);
		System.out.println(prices.toString());
		System.out.println("$"+prices.get(0).toString());

		int rows=driver.findElements(By.xpath("//table[@class = 'table']//tbody/tr")).size();
		int cols=driver.findElements(By.xpath("//table[@class = 'table']//th")).size();
		
		System.out.println(rows);
		System.out.println(cols);
		
		String data;
		String p = "$"+prices.get(0).toString();
		System.out.println(p);
		for(int i = 1;i<=rows;i++)
		{
			data=driver.findElement(By.xpath("//table[@class = 'table']//tbody/tr["+i+"]/td[6]")).getText();
			if(data.equals(p))
			{
				driver.findElement(By.xpath("//table[@class = 'table']//tbody/tr["+i+"]/td[1]")).click();
				break;
			
			}
//			for(int j = 1;j<=cols;j++)
//			{
//				data=driver.findElement(By.xpath("//table[@class = 'table']//tbody/tr["+i+"]/td["+j+"]")).getText();
//				System.out.println(data);
//				if(data.equals(p))
//				{
//					driver.findElement(By.xpath("//table[@class = 'table']//tbody/tr["+i+"]/td[1]")).click();
//					break;
//				
//				}
//				
//			}
		}
		Thread.sleep(2000);
	}
	
    @Test(priority = 5)
    public void validate()
    {
    	String pageTitle = driver.getTitle();
    	Assert.assertEquals(pageTitle, "BlazeDemo Purchase");
    }
    @Test(priority = 6)
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
   
    @Test(priority = 7)
    public void validateMessage() throws InterruptedException
    {
    	String status = driver.findElement(By.xpath("//div[@class='container hero-unit']/h1")).getText();
    	Assert.assertEquals(status, "Thank you for your purchase today!");
    	Thread.sleep(2000);
    }
    
   	@AfterClass
   	public void tearDown() {
   		driver.quit();
   	}


}
