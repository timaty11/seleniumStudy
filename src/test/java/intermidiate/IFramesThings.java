package intermidiate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class IFramesThings {
    public static void main(String[] args) {
        findNumberOfFrames();
        switchByIndex();
        switchByName();
        switchById();
        switchByWebElement();
        switchBackToMainPage();
        
    }


    public static void findNumberOfFrames() {
        String url = "https://demoqa.com/frames";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // By executing a java script
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);

        // By finding all the web elements using iframe tag
        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        System.out.println("The total number of iframes are " + iframeElements.size());

        driver.quit();
    }


    public static void switchByIndex() {
        String url = "https://demoqa.com/frames";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Switch by Index
        driver.switchTo().frame(0);
        driver.quit();
    }


    public static void switchByName() {
        String url = "https://demoqa.com/frames";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Switch by frame name
        driver.switchTo().frame("iframe1");
        driver.quit();
    }


    public static void switchById() {
        String url = "https://demoqa.com/frames";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Switch by frame ID
        driver.switchTo().frame("IF1");
        driver.quit();
    }


    public static void switchByWebElement() {
        String url = "https://demoqa.com/frames";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // First find the element using any of locator strategy
        WebElement iframeElement = driver.findElement(By.id("IF1"));

        // now use the switch command
        driver.switchTo().frame(iframeElement);
        driver.quit();
    }


    public static void switchBackToMainPage() {
        String url = "https://demoqa.com/frames";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // First find the element using any of locator strategy
        WebElement iframeElement = driver.findElement(By.id("IF1"));

        // now use the switch command
        driver.switchTo().frame(0);

        // Do all the required tasks in the frame 0
        // Switch back to the main window
        driver.switchTo().defaultContent();
        driver.quit();
    }


    public static void switchToIFrameByIndex() {
        String url = "https://demoqa.com/frames";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Switch to Frame using Index
        driver.switchTo().frame(0);

        // Identifying the heading in webelement
        WebElement frame1Heading= driver.findElement(By.id("sampleHeading"));

        // Finding the text of the heading
        String frame1Text=frame1Heading.getText();

        // Print the heading text
        System.out.println(frame1Text);

        // Closing the driver
        driver.close();
    }


    public static void switchToIFrameByName() {
        String url = "https://demoqa.com/frames";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Switch to Frame using id of the frame
        driver.switchTo().frame("frame1");

        // Identifying the heading in webelement
        WebElement frame1Heading= driver.findElement(By.id("sampleHeading"));

        // Finding the text of the heading
        String frame1Text=frame1Heading.getText();

        // Print the heading text
        System.out.println(frame1Text);

        // Closing the driver
        driver.close();
    }


    public static void switchToIFrameByWebElement() {
        String url = "https://demoqa.com/frames";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Locating frame1 using its id
        WebElement frame1=driver.findElement(By.id("frame1"));

        // Switching the WebDriver context to frame1
        driver.switchTo().frame(frame1);

        // Identifying the frame heading in a WebElement
        WebElement frame1Heading= driver.findElement(By.id("sampleHeading"));

        // Finding the text of the frame1 heading
        String frame1Text=frame1Heading.getText();

        // Print the heading
        System.out.println("Text of the frame1 heading is:"+frame1Text);

        // Closing the driver
        driver.close();
    }


    public static void switchToChildIFrame() {
        String url = "https://demoqa.com/nestedframes";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Number of Frames on a Page
        int countIframesInPage = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames on a Page:" + countIframesInPage);

        // Locate the frame1 on the webPage
        WebElement frame1=driver.findElement(By.id("frame1"));

        // Switch to Frame1
        driver.switchTo().frame(frame1);

        // Locate the Element inside the Frame1
        WebElement frame1Element= driver.findElement(By.tagName("body"));

        // Get the text for frame1 element
        String frame1Text=frame1Element.getText();
        System.out.println("Frame1 is :"+frame1Text);

        // Number of Frames on a Frame1
        int countIframesInFrame1 =driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the Frame1:" + countIframesInFrame1);

        // switch to child frame
        driver.switchTo().frame(0);

        int countIframesInFrame2 =driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the Frame2:" + countIframesInFrame2);

        driver.close();
    }


    public static void switchBackToParentFrame() {
        String url = "https://demoqa.com/nestedframes";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Number of Frames on a Page
        int countIframesInPage =driver. findElements(By. tagName("iframe")). size();
        System.out.println("Number of Frames on a Page:"+countIframesInPage);

        // Locate the frame1 on the webPage
        WebElement frame1=driver.findElement(By.id("frame1"));

        // Switch to Frame1
        driver.switchTo().frame(frame1);

        // Number of Frames on a Frame1
        int countIframesInFrame1 =driver. findElements(By. tagName("iframe")). size();
        System.out.println("Number of Frames inside the Frame1:"+countIframesInFrame1);

        // Switch to child frame
        driver.switchTo().frame(0);
        int countIframesInFrame2 =driver. findElements(By. tagName("iframe")). size();
        System.out.println("Number of Frames inside the Frame2:"+countIframesInFrame2);

        // Switch to Parent iFrame
        driver.switchTo().parentFrame();

        // Locate the Element inside the Frame1
        WebElement frame1Element= driver.findElement(By.tagName("body"));

        // Get the text for frame1 element
        String frame1Text=frame1Element.getText();

        // Try to Print the text present inside parent frame
        System.out.println("Frame1 is :" + frame1Text);
        driver.close();
    }


    public static void switchBackToMainWebPage() {
        String url = "https://demoqa.com/nestedframes";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Locate the webElement page heading
        WebElement pageHeadingElement=driver.findElement(By.xpath("//div[@class='main-header']"));

        // Find text of the page heading
        String pageHeading=pageHeadingElement.getText();

        // Print the page heading
        System.out.println("Page Heading is :"+pageHeading);

        // Switch to Parent iframe
        WebElement frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);
        WebElement frame1Element = driver.findElement(By.tagName("body"));
        String frame1Text = frame1Element.getText();
        System.out.println("Frame1 is :"+frame1Text);

        // Switch to child frame
        driver.switchTo().frame(0);
        WebElement frame2Element = driver.findElement(By.tagName("p"));
        String frame2Text = frame2Element.getText();
        System.out.println("Frame2 is :"+frame1Text);

        // Try to print the heading of the main page without switching
        WebElement mainPageText = driver.findElement(By.xpath("//*[@id=\"framesWrapper\"]/div[1]/text()"));
        System.out.println(mainPageText);
        driver.close();
    }

}
