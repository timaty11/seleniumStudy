package frameworksDesign.automationFramework;

import frameworksDesign.appModule.SignInAction;
import frameworksDesign.pageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Param_TC {

    private static WebDriver driver;

    public static void main(String[] args) {
        String url = "https://demoqa.com/login";

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        SignInAction.Execute(driver, "testuser_1","Test@123");
        System.out.println("Login successfully. Logging out");
        HomePage homePage = new HomePage(driver);
        homePage.lnkLogout();

        driver.quit();

    }

}
