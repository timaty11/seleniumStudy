package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {
    public static void main(String[] args) {

        String url = "https://demoqa.com/automation-practice-form";

        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();


        /**
         * Validate isSelected and click
         */

        WebElement checkBoxSelected = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        boolean isSelected = checkBoxSelected.isSelected();

        // Performing click operation if element is not selected
        if(isSelected) {
            checkBoxSelected.click();
        }

        /**
         * Validate isDisplayed and click
         */
        WebElement checkBoxDisplayed = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        boolean isDisplayed = checkBoxDisplayed.isDisplayed();

        // Performing click operation if element is displayed
        if (isDisplayed) {
            checkBoxDisplayed.click();
        }

        /**
         * Validate isEnabled and click
         */
        WebElement checkBoxEnabled = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        boolean isEnabled = checkBoxEnabled.isEnabled();

        // Performing click operation if element is enabled
        if (isEnabled) {
            checkBoxEnabled.click();
        }

        driver.quit();

    }

}
