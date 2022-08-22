package org.example.intermidiate;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class AdvancedWaitThings {
    public static void main(String[] args) throws InterruptedException {

        String url = "https://demoqa.com/dynamic-properties";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.pollingEvery(Duration.ofMillis(250));
        wait.withTimeout(Duration.ofSeconds(3));

        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver arg0) {
                WebElement element = arg0.findElement(By.id("colorChange"));
                String color = element.getCssValue("color");
                System.out.println("The color of the button is " + color);

                if (color.equals("red")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        wait.until(function);
    }

}
