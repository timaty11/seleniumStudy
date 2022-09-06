package intermidiate;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDropThings {

    public static void main(String[] args) {
        dragAndDropTest();
        dragAndDropByTest();

    }


    public static void dragAndDropTest() {
        String url = "http://demoqa.com/droppable/";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        Actions actions = new Actions(driver);

        WebElement button = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement placeToDrop = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
        actions.dragAndDrop(button, placeToDrop).perform();

        Assert.isTrue(driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText().equalsIgnoreCase("Dropped!"), "Not dropped!");

        driver.quit();
    }


    public static void dragAndDropByTest() {
        String url = "http://demoqa.com/droppable/";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        Actions actions = new Actions(driver);

        WebElement button = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement placeToDrop = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));

        int originOffsetX = button.getLocation().getX();
        int originOffsetY = button.getLocation().getY();

        int destOffsetX = placeToDrop.getLocation().getX();
        int destOffsetY = placeToDrop.getLocation().getY();

        actions.dragAndDropBy(button, (destOffsetX - originOffsetX), (destOffsetY - originOffsetY));
        actions.perform();

        Assert.isTrue(placeToDrop.getText().equalsIgnoreCase("Dropped!"), "Not dropped!");

        driver.quit();
    }

}
