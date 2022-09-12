package frameworksDesign.automationFramework;

import frameworksDesign.appModule.SignInAction;
import frameworksDesign.pageObjects.HomePage;
import frameworksDesign.utility.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GlobalVar_TC {

    private static WebDriver driver;

    public static void main(String[] args) {
        String url = Constant.URL;

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        SignInAction.Execute(driver, Constant.userName,Constant.userPwd);
        System.out.println("Login successfully. Logging out");
        HomePage homePage = new HomePage(driver);
        homePage.lnkLogout();

        driver.quit();

    }

}
