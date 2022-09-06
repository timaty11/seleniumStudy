package intermidiate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseHoverThings {

    public static void main(String[] args) {
        mouseHoverAction();
        mouseSliderAction();

    }


    public static void mouseHoverAction() {
        String url = "https://demoqa.com/menu/";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        Actions actions = new Actions(driver);

        WebElement mainItem = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/a"));
        actions.moveToElement(mainItem);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/a")));
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/ul/li[1]/a")));

        actions.perform();

        driver.quit();
    }


    public static void mouseSliderAction() {
        String url = "https://demoqa.com/slider/";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        Actions actions = new Actions(driver);

        WebElement slider = driver.findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input"));
        actions.moveToElement(slider, 50, 0);
        actions.perform();
        slider.click();

        driver.quit();
    }

}
