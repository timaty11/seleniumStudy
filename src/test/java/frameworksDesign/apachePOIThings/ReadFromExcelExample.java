package frameworksDesign.apachePOIThings;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.time.Duration;

public class ReadFromExcelExample {

    public static void main(String[] args) throws IOException, InvalidFormatException, InterruptedException {
//        basicReadFromExcel();
//        readWholeSheet();
//        writeToCell();

        parseExcelToTestWebPage();

    }


    public static void basicReadFromExcel() throws IOException, InvalidFormatException {

        File file = new File("C:\\Users\\Bogomol\\Desktop\\test1.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("test_list1");
        XSSFRow row1 = sheet.getRow(1);
        XSSFCell cell5 = row1.getCell(5);
        String address = cell5.getStringCellValue();
        System.out.println("Student's address is: " + address);

    }


    public static void readWholeSheet() throws IOException, InvalidFormatException {

        File file = new File("C:\\Users\\Bogomol\\Desktop\\test1.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("test_list1");

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        for (int i = 0; i <= rowCount; i++) {
            int cellCount = sheet.getRow(i).getLastCellNum();

            System.out.print("Row " + i + " data is: ");
            for (int j = 0; j < cellCount; j++) {
                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + ", ");
            }
            System.out.println();
        }
    }


    public static void writeToCell() throws IOException, InvalidFormatException {

        File file = new File("C:\\Users\\Bogomol\\Desktop\\test1.xlsx");
        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheet("test_list1");

        XSSFCell cell = sheet.getRow(1).createCell(6);
        cell.setCellValue("NICE");

        FileOutputStream outputStream = new FileOutputStream(file);
        wb.write(outputStream);
        wb.close();

    }


    public static void parseExcelToTestWebPage() throws IOException, InterruptedException {

        String url = "https://demoqa.com/automation-practice-form";

        File file = new File("C:\\Users\\Bogomol\\Desktop\\test1.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("test_list1");
        int rowsCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        WebElement firstNameInput = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        WebElement lastNameInput = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        WebElement genderMaleInput = driver.findElement(By.xpath("//*[@id=\"gender-radio-1\"]"));
        WebElement mobileInput = driver.findElement(By.xpath("//*[@id=\"userNumber\"]"));
        WebElement addressInput = driver.findElement(By.xpath("//*[@id=\"currentAddress\"]"));
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"submit\"]"));

        for (int i = 1; i <= rowsCount; i++) {
            firstNameInput.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
            lastNameInput.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
            emailInput.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
            genderMaleInput.sendKeys(sheet.getRow(i).getCell(3).getStringCellValue());
            mobileInput.sendKeys(String.valueOf(sheet.getRow(i).getCell(4).getRawValue()));
            addressInput.sendKeys(sheet.getRow(i).getCell(5).getStringCellValue());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", genderMaleInput);

//            submitButton.click();
            js.executeScript("arguments[0].click();", submitButton);

            // Verify the confirmation message
            WebElement confirmationMessage = driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));

            XSSFCell confirmCell = sheet.getRow(i).createCell(6);
            if (confirmationMessage.isDisplayed()) {
                confirmCell.setCellValue("ADDED");
            } else {
                confirmCell.setCellValue("ERROR");
            }

            FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);

            // Close the confirmation popup
            WebElement closeButton = driver.findElement(By.id("closeLargeModal"));
            js.executeScript("arguments[0].click();", closeButton);

            Thread.sleep(2000);

        }

        workbook.close();
        driver.quit();

    }

}
