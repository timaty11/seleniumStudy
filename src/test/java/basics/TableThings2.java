package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TableThings2 {
    public static void main(String[] args) {
        String url = "https://toolsqa.com/automation-practice-table";

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        String sRow = "1";
        String sCol = "2";

        // Here we are locating the xpath by passing variables in the xpath
        String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + sRow + "]/td[" + sCol + "]")).getText();
        System.out.println(sCellValue);
        String sRowValue = "Clock Tower Hotel";

        // First loop will find the 'ClOCK TWER HOTEL' in the first column
        for (int i = 1; i <= 5; i++){
            String sValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/th")).getText();
            if (sValue.equalsIgnoreCase(sRowValue)){
                // If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row
                for (int j=1;j<=5;j++){
                    String sColumnValue= driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/td["+ j +"]")).getText();
                    System.out.println(sColumnValue);
                }
                break;
            }
        }

        driver.close();
    }

}
