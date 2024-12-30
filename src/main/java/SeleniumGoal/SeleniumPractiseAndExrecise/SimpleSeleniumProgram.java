package SeleniumGoal.SeleniumPractiseAndExrecise;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SimpleSeleniumProgram 
{
    public static void main(String[] args) 
    {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();


             
        
    }
}