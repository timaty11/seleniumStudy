package advanced;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenshotThings {

    public static void main(String[] args) throws IOException {
        screenshotSample();
        screenshotOfAnElement();

    }


    public static void screenshotSample() {

        String url = "https://demoqa.com";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        // Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\Bogomol\\Desktop\\homePageScreenshot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Closing the webdriver
        driver.quit();
    }


    public static void screenshotOfAnElement() throws IOException {

        String url = "https://demoqa.com";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        // Locate the web element
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img"));

        // capture screenshot with getScreenshotAs() of the WebElement class
        File screenshot = logo.getScreenshotAs(OutputType.FILE);

        //Save cropped Image at destination location physically.
        FileUtils.copyFile(screenshot, new File("C:\\Users\\Bogomol\\Desktop\\header.png"));

        driver.quit();
    }

}
