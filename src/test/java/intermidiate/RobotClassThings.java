package intermidiate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class RobotClassThings {

    public static void main(String[] args) throws AWTException, InterruptedException {
        keyboardTest();

    }


    //// NOT WORKING
    public static void keyboardTest() throws AWTException, InterruptedException {
        String url = "https://demoqa.com/automation-practice-form";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        Actions actions = new Actions(driver);
        actions.moveToElement(uploadButton).click().perform();

//        uploadButton.sendKeys(Keys.ENTER);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_SHIFT);
//        robot.keyPress(KeyEvent.VK_COLON);
//        robot.keyPress(KeyEvent.VK_BACK_SLASH);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_BACK_SLASH);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);

        robot.keyPress(KeyEvent.VK_ENTER);

        driver.quit();
    }
}
