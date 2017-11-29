package Project.ClearTrip;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightbookingTest 
{
	WebDriver driver;
	 
	    @Test
	    public void testThatResultsAppearForAOneWayJourney() 
	    {
	         System.setProperty("webdriver.chrome.driver", "C:\\Users\\venka\\Documents\\EGDownloads\\chromedriver.exe");
	         driver=new ChromeDriver();
	         System.out.println("Succesfully Browser is launched");
	         driver.get("https://www.cleartrip.com/");
	         waitFor(2000);
	         driver.findElement(By.id("OneWay")).click();
	 
	         driver.findElement(By.id("FromTag")).clear();
	         driver.findElement(By.id("FromTag")).sendKeys("Bangalore");
	         System.out.println("Bangalore was entered at Origin");
	         
	         //wait for the auto complete options to appear for the origin
	         waitFor(2000);
	         
	         List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
	         originOptions.get(0).click();
	        
	         driver.findElement(By.xpath("//*[@id='ToTag']")).clear();
	         driver.findElement(By.xpath("//*[@id='ToTag']")).sendKeys("Delhi");
	         System.out.println("Delhi was entered at Destination");
	         
	         //wait for the auto complete options to appear for the destination
	         waitFor(2000);
	         
	         //select the first item from the destination auto complete list
	         List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
	         destinationOptions.get(0).click();
	 
	         
	         driver.findElement(By.xpath("//*[@id='DepartDate']")).sendKeys("28/11/2017");
	         System.out.println("Date was entered");
	 
	         //all fields filled in. Now click on search
	         driver.findElement(By.id("SearchBtn")).click();
	         System.out.println("search button was clicked ");
	         waitFor(5000);
	         
	         //verify that result appears for the provided journey search
	         Assert.assertTrue(isElementPresent(By.className("searchSummary")));
	         System.out.println("Flights details were displayed");
	 
	         //close the browser
	         driver.quit();
	         System.out.println("Succesfully browser is closed");
	 
	     }
	 
	 
	     private void waitFor(int durationInMilliSeconds) 
	     {
	         try 
	         {
	             Thread.sleep(durationInMilliSeconds);
	         } 
	         catch (InterruptedException e) 
	         {
	             e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
	         }
	     }
	 
	 
	     private boolean isElementPresent(By by) 
	     {
	         try 
	         {
	             driver.findElement(by);
	             return true;
	         } 
	         catch (NoSuchElementException e) 
	         {
	             return false;
	         }
	     }

}
