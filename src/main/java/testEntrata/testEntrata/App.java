package testEntrata.testEntrata;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class App 
{
    public static void main( String[] args )
    {
     System.setProperty("webdriver.chrome.driver","C:/Users/shiva/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
     
     WebDriver driver = new ChromeDriver(); 
     
     driver.get("https://www.entrata.com/b");
    }
    
    
    
}
