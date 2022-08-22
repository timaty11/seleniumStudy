package org.example.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Struct;
import java.util.List;

public class LocatorThings {
    public static void main(String[] args) {

        String url = "https://demoqa.com/";

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");


        /**Locate by ID Attribute
         * URL - https://demoqa.com/automation-practice-form
         */

        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName"));

        /**
         *  Locate by Name attribute
         *  URL - https://demoqa.com/automation-practice-form
         */

        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.name("gender"));

        /**
         *  Locate by className attribute
         *  URL - https://demoqa.com/automation-practice-form
         */

        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.className("practice-form-wrapper"));

        /**
         *  Locate by linkText and ParticalLinkText attribute
         *  URL - https://demoqa.com/links
         */

        driver.get("https://demoqa.com/links");
        // linkText
        driver.findElement(By.linkText("Home"));
        // partialLinkText
        driver.findElement(By.partialLinkText("Ho"));

        /**
         *  Locate by tagName attribute
         *  URL - https://demoqa.com/links
         */

        driver.get("https://demoqa.com/links");
        List<WebElement> list = driver.findElements(By.tagName("a"));

        /**
         *  Locate by cssSelector attribute
         *  URL - https://demoqa.com/text-box
         */

        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.cssSelector("input[id= ‘userName’]"));

        /**
         *  Locate by xpath attribute
         *  URL - https://demoqa.com/text-box
         */

        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.xpath("//input[@id='userName']"));

        driver.quit();

    }

}
