package frameworksDesign.pomThings.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoard {

    WebDriver driver;

    public DashBoard(WebDriver driver) {
        this.driver = driver;
    }

    By headingLocator = By.xpath("//div[@class=\"main-header\"]");
    By searchInputLocator = By.xpath("//*[@id=\"searchBox\"]");
    By logoutButtonLocator = By.id("submit");

    public String getHeadingText() {
        return driver.findElement(headingLocator).getText();
    }

    public void sendSearchInput(String toSearch) {
        System.out.println("Entering the " + toSearch + " to the input");
        driver.findElement(searchInputLocator).sendKeys(toSearch);
    }

    public void clickLogout() {
        driver.findElement(logoutButtonLocator).click();
    }

}
