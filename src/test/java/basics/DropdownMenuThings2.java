package basics;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownMenuThings2 {
    public static void main(String[] args) {

        String url = "https://demoqa.com/select-menu";

        // Launch a new Chrome browser.
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open DemoQA.com
        driver.get(url);

        // Select the Standard Multi-Select using the element id.
        Select menu = new Select(driver.findElement(By.id("cars")));

        // Verifying that the element is multi-select.
        Assert.isTrue(menu.isMultiple(), "The menu isn't multiple");

        // Select 'Opel' using the index and deselect the same using index.
        menu.selectByIndex(2);
        System.out.println("Selected option " + menu.getFirstSelectedOption().getText() + " from menu:");
        menu.deselectByIndex(2);

        // Select 'Saab' using value and deselect the same using value.
        menu.selectByValue("saab");
        System.out.println("Selected option " + menu.getFirstSelectedOption().getText() + " from menu:");
        menu.deselectByValue("saab");

        // Select multiple values and print all selected options
        menu.selectByValue("volvo");
        menu.selectByIndex(3);

        List<WebElement> selectedOptions = menu.getAllSelectedOptions();
        System.out.println("Options in select menu:");
        for (WebElement option: selectedOptions) {
            System.out.println(option.getText());
        }

        // Close the Browser.
        driver.quit();

    }

}
