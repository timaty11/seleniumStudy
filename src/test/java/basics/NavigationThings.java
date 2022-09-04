package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationThings {
    public static void main(String[] args) {

        String url = "https://demoqa.com";

        // Launch a new Chrome browser.
        ChromeDriver driver = new ChromeDriver();

        // Open Shop.DemoQA.com
        driver.get(url);

//        // Click on Registration link
//        driver.findElement(By.xpath(".//*[@id='menu-item-374']/a")).click();

        // Come back to Home page
        driver.navigate().back();

        // Again go back to Registration page
        driver.navigate().forward();

        // Again come back to Home page
        driver.navigate().to(url);

        // Refresh the Browser
        driver.navigate().refresh();

        // Close the Browser.
        driver.quit();

    }
}
