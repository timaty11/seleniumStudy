package intermidiate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindowsThings {

    public static void main(String[] args) {
//        findChildWindow();
//        handleMultipleWindows();
//        switchBetweenChildAndParent();

        practiceWindowExercise();

    }

    public static void findChildWindow() {
        String url = "https://demoqa.com/browser-windows";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Open new child window within the main window
        driver.findElement(By.id("windowButton")).click();

        // Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
            }
        }

        driver.quit();
    }


    public static void handleMultipleWindows() {
        String url = "https://demoqa.com/browser-windows";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Opening all the child window
        driver.findElement(By.id("windowButton")).click();
        driver.findElement(By.id("messageWindowButton")).click();

        String MainWindow = driver.getWindowHandle();
        System.out.println("Main window handle is " + MainWindow);

        // To handle all new opened window
        Set<String> s1 = driver.getWindowHandles();
        System.out.println("Child window handle is" + s1);
        Iterator<String> i1 = s1.iterator();

        // Here we will check if child window has other child windows and when child window
        // is the main window it will come out of loop.
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                driver.close();
                System.out.println("Child window closed");
            }
        }

        driver.quit();
    }


    public static void switchBetweenChildAndParent() {
        String url = "https://demoqa.com/browser-windows";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        driver.findElement(By.id("windowButton")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
                driver.close();
                System.out.println("Child window closed");
            }
        }

        // Switch back to the main window which is the parent window.
        driver.switchTo().window(mainWindow);

        driver.quit();
    }


    public static void practiceWindowExercise() {
        String url = "https://demoqa.com/browser-windows";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        String mainWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//*[@id=\"windowButton\"]")).click();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        String childWindow = i1.next();
        childWindow = i1.next();
        driver.switchTo().window(childWindow);
        System.out.println("The text on the window is: " + driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]")).getText());
        driver.close();
        driver.switchTo().window(mainWindow);

        driver.findElement(By.xpath("//*[@id=\"messageWindowButton\"]")).click();
        Set<String> s2 = driver.getWindowHandles();
        Iterator<String> i2 = s2.iterator();

        childWindow = i2.next();
        childWindow = i2.next();
        driver.switchTo().window(childWindow);
        System.out.println("The text on the window is: " + driver.findElement(By.tagName("body")).getText());
        driver.close();
        driver.switchTo().window(mainWindow);

        driver.quit();
    }

}
