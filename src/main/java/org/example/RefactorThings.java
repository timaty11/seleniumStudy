package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

public class RefactorThings {
    public static void main(String[] args) {

        String url = "https://shop.demoqa.com/";

        // Launch a new Chrome browser.
        ChromeDriver driver = new ChromeDriver();

        // Open Shop.DemoQA.com
        driver.get(url);

        // Get Page Title name and Title length
        String titleName = driver.getTitle();

        // Print Page Title and Title length on the Eclipse Console.
        System.out.println("The title is: " + titleName + "\nThe length of the title: " + titleName.length());

        // Get Page URL and verify if it is a correct page opened
        Assert.isTrue(driver.getCurrentUrl().equalsIgnoreCase("https://shop.demoqa.com/"), "incorrect URL");

        // Get Page Source (HTML Source code) and Page Source length
        // Print Page Length on Eclipse Console.
        String sourceCode = driver.getPageSource();
        System.out.println("The source code is:\n" + sourceCode);
        System.out.println("The length is: " + sourceCode.length());

        // Close the Browser.
        driver.quit();

    }

}
