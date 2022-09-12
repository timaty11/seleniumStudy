package frameworksDesign.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By myAccButtonLocator = By.xpath("//*[@id=\"login\"]");
    By logoutButtonLocator = By.xpath("//*[@id=\"submit\"]");

    public WebElement lnkMyAccount() {
        return driver.findElement(myAccButtonLocator);
    }

    public WebElement lnkLogout() {
        return driver.findElement(logoutButtonLocator);
    }

}
