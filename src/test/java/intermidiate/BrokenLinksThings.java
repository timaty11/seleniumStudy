package intermidiate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinksThings {

    public static void main(String[] args) {
        brokenLinkHandle();
        brokenImagesHandle();
    }


    public static void brokenLinkHandle() {
        String url = "https://demoqa.com/links";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        // Get all URLs from page
        List<WebElement> urls = driver.findElements(By.tagName("a"));
        System.out.println("Found " + urls.size() + " amount of URLs on the page");

        // Iterate through all the URLs
        for (WebElement webElement : urls) {
            url = webElement.getAttribute("href");
            System.out.print(url);

            // Check if url is valid
            if (verifyLink(url)) {
                System.out.println(" - is valid!");
            } else {
                System.out.println(" - is invalid!");
            }
        }

        driver.quit();
    }


    public static void brokenImagesHandle() {
        String url = "https://demoqa.com/broken";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        // Get all images from web page
        List<WebElement> imgList = driver.findElements(By.tagName("img"));
        System.out.println("Found " + imgList.size() + " amount of URLs on the page");

        // Iterate through all images
        for (WebElement image : imgList) {
            System.out.print(image.getAttribute("src"));

            // Check if url is valid
            if (verifyLink(image.getAttribute("src"))) {
                System.out.print(" - is valid!");
            } else {
                System.out.print(" - is invalid!");
            }

            //Validate image display using JavaScript executor
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0);", image);

                if (imageDisplayed) {
                    System.out.println(" DISPLAY - OK");
                } else {
                    System.out.println(" DISPLAY - BROKEN");
                }
            } catch (Exception e) {
                System.out.println("Error Occured");
            }
        }

        driver.quit();
    }


    private static boolean verifyLink(String linkUrl) {
        try {
            URL url = new URL(linkUrl);

            // Create the connection and check the response code
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();

            return httpURLConnection.getResponseCode() < 400;

        } catch (Exception e) {
            return false;
        }
    }

}
