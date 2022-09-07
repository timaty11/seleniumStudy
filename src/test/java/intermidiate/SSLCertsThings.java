package intermidiate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SSLCertsThings {

    public static void main(String[] args) {
        sslErrorHandleTest();

    }


    public static void sslErrorHandleTest() {
        String url = "badssl.com/";

        // Accessing insecure SSL certs
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(handlingSSL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://" + "expired." + url);

        System.out.println("The page title is: " + driver.getTitle());

        driver.quit();
    }

}
