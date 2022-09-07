package intermidiate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HeadlessBrowserThings {

    public static void main(String[] args) {
        chromeBrowserTest();

    }


    public static void chromeBrowserTest() {
        String url = "https://demoqa.com/automation-practice-form";
        ChromeOptions options = new ChromeOptions().addArguments("headless");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        System.out.println("The title is: " + driver.getTitle());

        driver.quit();
    }

}
