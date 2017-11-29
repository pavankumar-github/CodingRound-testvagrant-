package Project.ClearTrip;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest 
{
	WebDriver driver;
	
	static By hotellink=By.linkText("Hotels");
	static By localityTextBox=By.id("Tags");
	static By searchButton=By.id("SearchHotelsButton");
	static By travellerSelection=By.id("travellersOnhome");
	@Test
	public void shouldBeAbleToSearchForHotels() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\venka\\Documents\\EGDownloads\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.findElement(hotellink).click();	
		driver.findElement(localityTextBox).sendKeys("Indiranagar, Bangalore");
		new Select(driver.findElement(travellerSelection)).selectByVisibleText("2 rooms, 4 adults");
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElement(searchButton));
		waitFor(3000);
		driver.close();

	}

	public void waitFor(int milliSeconds) throws Exception
	{
		Thread.sleep(milliSeconds);
	}

}
