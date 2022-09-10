package frameworksDesign.pomThings.testCases;

import frameworksDesign.pomThings.pages.DashBoard;
import frameworksDesign.pomThings.pages.HomePage;
import frameworksDesign.pomThings.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Login_TC1 {

    public static void main(String[] args) throws InterruptedException {

        String url = "https://demoqa.com/login";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        LoginPage loginPage = new LoginPage(driver);
        DashBoard dashBoard = new DashBoard(driver);

        loginPage.enterUsername("gunjankaushik");
        loginPage.enterPassword("Password@123");
        loginPage.clickLogin();

        System.out.println("The page header is: " + dashBoard.getHeadingText());
        dashBoard.sendSearchInput("git");
        dashBoard.clickLogout();

        driver.quit();
    }

}
