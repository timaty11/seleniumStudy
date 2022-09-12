package frameworksDesign.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By userNameTxtBoxLocator = By.xpath("//*[@id=\"userName\"]");
    By pwdTxtBoxLocator = By.xpath("//*[@id=\"password\"]");
    By loginButtonLocator = By.xpath("//*[@id=\"login\"]");

    public WebElement txtBoxUsername() {
        return driver.findElement(userNameTxtBoxLocator);
    }

    public WebElement txtBoxPwd() {
        return driver.findElement(pwdTxtBoxLocator);
    }

    public WebElement loginButton() {
        return driver.findElement(loginButtonLocator);
    }

}
