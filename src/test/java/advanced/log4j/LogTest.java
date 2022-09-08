package advanced.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LogTest {

    private static Logger Log = Logger.getLogger(LogTest.class.getName());

    public static void main(String[] args) {

        // DOLZNO BIT BEZ ETOGO NO NYZEN SPRING BOOT
        BasicConfigurator.configure();
        ConsoleAppender appender = new ConsoleAppender();
        Log.addAppender(appender);
        // DOLZNO BIT BEZ ETOGO NO NYZEN SPRING BOOT

        String url = "https://demoqa.com/books";

        WebDriver driver = new ChromeDriver();
        Log.info("New driver initialized");

        Log.info("Setting up the window");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
        Log.info("Web application launched");

        WebElement usernameInput = driver.findElement(By.xpath("//*[@id=\"searchBox\"]"));
        Log.info("Found input search");

        usernameInput.sendKeys("git");
        Log.info("Send 'git' to input");

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span/a")).click();
        Log.info("Clicking the book");

        String bookName = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/label")).getText();
        Log.info("The title of the book is: " + bookName);

        driver.quit();
        Log.info("Browser closed");
    }

}
