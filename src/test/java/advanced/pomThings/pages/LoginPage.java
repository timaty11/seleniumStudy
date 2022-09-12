package advanced.pomThings.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By usernameLocator = By.id("userName");
    By pwdLocator = By.id("password");
    By loginBtnLocator = By.id("login");

    public void enterUsername(String user) {
        driver.findElement(usernameLocator).sendKeys(user);
    }

    public void enterPassword(String password) {
        driver.findElement(pwdLocator).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginBtnLocator).click();
    }

}
