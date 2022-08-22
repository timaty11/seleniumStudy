package org.example.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {
    public static void main(String[] args) {

        String url = "https://demoqa.com/radio-button";

        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        /**
         * Find radio button using ID, Validate isSelected and then click to select
         */

        WebElement radioEle = driver.findElement(By.id("yesRadio"));
        boolean select = radioEle.isSelected();
        System.out.print(select);
        // Performing click operation if element is not already selected
        if (select == false) {
            radioEle.click();
        }

        /**
         * Find radio button using Xpath, Validate isDisplayed and click to select
         */

        WebElement radioElem = driver.findElement(By.xpath("//div/input[@id='impressiveRadio']"));
        boolean sel = radioEle.isDisplayed();

        // Performing click operation if element is displayed
        if (sel == true) {
            radioElem.click();
        }

        /**
         * Find radio button using CSS Selector, Validate isEnabled and click to select
         */

        WebElement radioNo = driver.findElement(By.cssSelector("input[id='noRadio']"));
        boolean selectNo = radioEle.isDisplayed();

        // Performing click operation if element is enabled
        if (selectNo == true) {
            radioNo.click();
        }

    }

}
