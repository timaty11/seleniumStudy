package frameworksDesign.appModule;

import frameworksDesign.pageObjects.HomePage;
import frameworksDesign.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

public class SignInAction {

    public static void Execute (WebDriver driver, String userName, String userPwd) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.lnkMyAccount().click();

        loginPage.txtBoxUsername().sendKeys(userName);
        loginPage.txtBoxPwd().sendKeys(userPwd);
        loginPage.loginButton().click();

    }

}
