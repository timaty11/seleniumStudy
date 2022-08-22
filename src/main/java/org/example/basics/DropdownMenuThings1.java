package org.example.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownMenuThings1 {
    public static void main(String[] args) {

        String url = "https://demoqa.com/select-menu";

        // Launch a new Chrome browser.
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open DemoQA.com
        driver.get(url);

        // Select the Old Style Select Menu using the element id.
        Select menu = new Select(driver.findElement(By.id("oldSelectMenu")));

        // Print all the options of the dropdown.
        List<WebElement> availableOptions = menu.getOptions();
        System.out.println("Options in select menu:");
        for (WebElement option: availableOptions) {
            System.out.println(option.getText());
        }

        // Select 'Purple' using the index (4).
        menu.selectByIndex(4);
        System.out.println("Selected option " + menu.getFirstSelectedOption().getText() + "from menu:");

        // After that, select 'Magenta' using visible text.
        menu.selectByVisibleText("Magenta");
        System.out.println("Selected option " + menu.getFirstSelectedOption().getText() + "from menu:");

        // Select an option using value.
        menu.selectByValue("2");
        System.out.println("Selected option " + menu.getFirstSelectedOption().getText() + "from menu:");

        // Close the Browser.
        driver.quit();

    }

}
