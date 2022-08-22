package org.example.basics;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasaThings {
    public static void main(String[] args) {
        String url = "https://demoqa.com/login";

        ChromeDriver driver = new ChromeDriver();
        driver.get(url);

        System.out.println("The title is: " + driver.getTitle());
        Assert.isTrue(driver.getTitle().equalsIgnoreCase("ToolsQA"), "The title of page is incorrect");

        WebElement loginInput = driver.findElement(By.id("userName"));
        loginInput.sendKeys("testuser");

        WebElement passInput = driver.findElement(By.id("password"));
        passInput.sendKeys("Password@123");

        WebElement sendButton = driver.findElement(By.id("login"));
        sendButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            WebElement logoutBtn = driver.findElement(By.xpath("//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']"));

            if (logoutBtn.isDisplayed()) {
                System.out.println("Found logout button!");
                logoutBtn.click();
            } else {
                System.out.println("Logout button not found!");
            }
        } catch (Exception e) {
            System.out.println("Logout button search failed!");
        }

        driver.quit();
    }

}
