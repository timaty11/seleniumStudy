package intermidiate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ToolTipThings {

    public static void main(String[] args) {
        toolTipTest();

    }


    public static void toolTipTest() {
        String url = "https://demoqa.com/tool-tips";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        Actions actions = new Actions(driver);

        WebElement textBox1 = driver.findElement(By.id("toolTipButton"));
        actions.moveToElement(textBox1);
        actions.pause(Duration.ofSeconds(1));
        System.out.println("Retrieved tooltip text as :" + driver.findElement(By.id("toolTipButton")).getAttribute("aria-describedby"));
        actions.pause(Duration.ofSeconds(1));
        actions.perform();


        WebElement textBox2 = driver.findElement(By.id("toolTipTextField"));
        actions.moveToElement(textBox2);
        actions.pause(Duration.ofSeconds(1));
        System.out.println("Retrieved tooltip text as :" + driver.findElement(By.id("toolTipTextField")).getAttribute("aria-describedby"));
        actions.pause(Duration.ofSeconds(1));
        actions.perform();


        // Close the main window
        driver.quit();
    }

}
