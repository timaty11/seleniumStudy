package intermidiate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseClickThings {

    public static void main(String[] args) {
        rightClickTest();
        doubleClickTest();

    }


    public static void rightClickTest() {
        String url = "https://demoqa.com/buttons";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        Actions actions = new Actions(driver);

        WebElement button = driver.findElement(By.xpath("//*[@id=\"rightClickBtn\"]"));
        actions.contextClick(button).perform();

        System.out.println(driver.findElement(By.xpath("//*[@id=\"rightClickMessage\"]")).getText());

        driver.quit();
    }


    public static void doubleClickTest() {
        String url = "https://demoqa.com/buttons";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        Actions actions = new Actions(driver);

        WebElement button = driver.findElement(By.xpath("//*[@id=\"doubleClickBtn\"]"));
        actions.doubleClick(button).perform();

        System.out.println(driver.findElement(By.xpath("//*[@id=\"doubleClickMessage\"]")).getText());

        driver.quit();
    }

}
