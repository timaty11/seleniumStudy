package intermidiate;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RefreshBrowserThings {

    public static void main(String[] args) {
        refreshTest();

    }


    public static void refreshTest() {
        String url = "https://www.toolsqa.com";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        driver.navigate().refresh();

        driver.get(driver.getCurrentUrl());

        driver.navigate().to(driver.getCurrentUrl());

        driver.quit();
    }

}
