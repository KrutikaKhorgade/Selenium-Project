package PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	 WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	By departureCityField = By.xpath("//select[@name='fromPort']");
	By destinationCityField = By.xpath("//select[@name='toPort']");
	By find_Flights = By.xpath("//input[@type='submit']");
	By flightPrices = By.xpath("//table[@class = 'table']//tbody/tr/td[6]");
	By firstLastTxtField = By.xpath("//input[@id='inputName']");
	By addressField = By.xpath("//input[@name='address']");
	By cityField = By.xpath("//input[@name='city']");
	By state = By.xpath("//input[@name='state']");
	By zipCode = By.xpath("//input[@name='zipCode']");
	By cardType = By.xpath("//select[@id='cardType']/option");
	By cardNumber = By.xpath("//input[@id='creditCardNumber']");
	By creditCardMonth = By.xpath("//input[@id='creditCardMonth']");
	By creditCardYear = By.xpath("//input[@id='creditCardYear']");
	By nameOnCard = By.xpath("//input[@id='nameOnCard']");
	By checkbox = By.xpath("//input[@id='rememberMe']");
	By button = By.xpath("//input[@value='Purchase Flight']");
	
	public List<WebElement>getDepartureCity()
	{
		List <WebElement> depCity= driver.findElements(departureCityField);
		
		return depCity;
	}
	public List<WebElement>getDestinationCity()
	{
		List <WebElement> desCity= driver.findElements(destinationCityField);
		return desCity;
	}
	public void clickFindFlights()
	{
		driver.findElement(find_Flights).click();
	}
	public List <WebElement> findCheapFlight()
	{
		List<WebElement>fPrices = driver.findElements(flightPrices);
		return fPrices;
	}
	public List cardType ()
	{
		List<WebElement>cardType = driver.findElements(By.xpath("//select[@id='cardType']"));
		return cardType;
	}
	
	
		}


