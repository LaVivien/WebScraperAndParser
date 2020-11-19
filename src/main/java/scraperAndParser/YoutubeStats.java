package scraperAndParser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YoutubeStats {
	 public static void main(String[] args) throws Exception {
		 String username = "taylor swift";
		 String url = "https://www.youtube.com/results?search_query=" + username;
    	
		 //set selenium web driver with chrome headless 
		 System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--headless","--user-agent=Chrome 86.0.4240/Windows");
		 WebDriver driver = new ChromeDriver(options);			
		 driver.get(url);
		 Thread.sleep(1000);
		
		 //selenium method to find element 
		 WebElement findElement = driver.findElement(By.id("subscribers"));
		 String text = findElement.getText();
		 System.out.println(text);
	    
		 WebElement findElement1 = driver.findElement(By.id("video-count"));
		 text = findElement1.getText();
		 System.out.println(text);
	     
		 WebElement findElement2 = driver.findElement(By.id("description"));
		 text = findElement2.getText();
		 System.out.println(text);    
    }
}
