package org.example.intermidiate;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WaitThings {
    public static void main(String[] args) {
        String url = "https://demoqa.com/dynamic-properties";

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(url);

        // Find an element with id "visibleAfter".
        // This element takes 5 secs to load which means this element will appear after 5 secs.
        Assert.isTrue(driver.findElement(By.id("visibleAfter")).isDisplayed(), "Element not found!");
        driver.findElement(By.id("visibleAfter")).click();

        driver.quit();
    }

}
