package Optellum;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part1 {
public static void main(String[] args) throws InterruptedException {
		
	ChromeDriver driver = new ChromeDriver(); //Create an instance of the ChromeDriver object
	driver.manage().window().maximize(); //Maximise window
	driver.get("https://optellum.com"); //Open Optellum Website
	Thread.sleep(5000); //Wait 5 seconds to allow page to load
	
	 // Find and click on the search toggle element
	WebElement ele_to_click = driver.findElement(By.xpath("//li[@class=\"search-toggle-li\"]"));
	ele_to_click.click();
	
	Thread.sleep(2000); //wait 2 seconds
	
	// Find the search input element and enter the search term "Cambridge"
	WebElement searchInput = driver.findElement(By.id("ocean-search-form-1"));
    String searchTerm = "Cambridge";
    searchInput.sendKeys(searchTerm);
    searchInput.sendKeys(Keys.RETURN);
    
    Thread.sleep(4000); //wait 4 seconds for results to load
     
    // Get the count of search results
    String Count=driver.findElement(By.id("search-results-count")).getText();
    
    // Print the search term and the number of search results found
    System.out.println("You searched for: " + searchTerm);
    System.out.println(Count + " search results found");
   
    // Get the number of articles elements displayed
    List<WebElement> articleElements = driver.findElements(By.tagName("article"));
    //System.out.println("Number of articles displayed: " + articleElements.size());
    //^Didn't ask for this but I would of displayed it
    
   
    // Compare the count of search results with the number of displayed articles
    if (Integer.parseInt(Count.split(" ")[0]) == articleElements.size()) {
        System.out.println("Test PASSED: Number of search results matches the number of results returned.");
    } else {
        System.out.println("Test FAILED: Number of search results does not match the number of results returned.");
    }

    driver.quit(); //close browser
	}      
}

//If I had more time I would of handled the cookies pop up that appears when the page is launched & also I would of expanded the test coverage and ensure compatibility across different web browsers (Safari & FireFox etc). 