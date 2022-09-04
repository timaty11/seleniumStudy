package intermidiate;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsThings {
    public static void main(String[] args) {
        simpleAlertHandle();
        promptAlertHandle();
        confirmationAlertHandle();

    }


    public static void simpleAlertHandle() {
        String url = "https://demoqa.com/alerts";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // This step will result in an alert on screen
        driver.findElement(By.id("alertButton")).click();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();

        driver.quit();
    }


    public static void promptAlertHandle() {
        String url = "https://demoqa.com/alerts";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // This step will result in an alert on screen
        WebElement element = driver.findElement(By.id("promtButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        Alert promptAlert  = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        System.out.println("Alert text is " + alertText);

        // Send some text to the alert
        promptAlert.sendKeys("Test User");
        promptAlert.accept();

        driver.quit();
    }


    public static void confirmationAlertHandle() {
        String url = "https://demoqa.com/alerts";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // This step will result in an alert on screen
        WebElement element = driver.findElement(By.id("confirmButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        Alert confirmationAlert = driver.switchTo().alert();
        String alertText = confirmationAlert.getText();
        System.out.println("Alert text is " + alertText);
        confirmationAlert.accept();

        driver.quit();
    }


    public static void unexpectedAlertHandle() {
        String url = "https://demoqa.com/alerts";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        try {
            driver.findElement(By.id("timerAlertButton")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert simpleAlert = driver.switchTo().alert();
            simpleAlert.accept();
            System.out.println("Unexpected alert accepted");
        } catch (Exception e) {
            System.out.println("unexpected alert not present");
        }

        driver.quit();
    }

}
