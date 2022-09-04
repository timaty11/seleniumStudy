package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TablesThings1 {
    public static void main(String[] args) {

        String url = "http://toolsqa.com/automation-practice-table/";

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        // Here we are storing the value from the cell in to the string variable
        String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[2]")).getText();
        System.out.println(sCellValue);

        // Here we are clicking on the link of first row and the last column
        driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[6]/a")).click();
        System.out.println("Link has been clicked otherwise an exception would have thrown");
        driver.close();

    }

}
