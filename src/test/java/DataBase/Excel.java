package DataBase;

import SeleniumHelper.BaseMethods;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;

public class Excel extends BaseMethods {

    public Excel(WebDriver driver) {
        super(driver);
    }

    public Excel(WebDriverWait wait) {
        super(wait);
    }

    XSSFWorkbook wb;
    XSSFSheet sheet1;

    @Step("read Excel Search Item 1")
    public void readExcelSearchItem1(String excelPath) {
        try {
            File src = new File(excelPath);
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Allure.addAttachment("read Excel Search Item 1", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("get Data")
    public String getData(int sheetNumber, int row, int colum) {
        sheet1 = wb.getSheetAt(sheetNumber);
        String data = sheet1.getRow(row).getCell(colum).getStringCellValue();
        return data;
    }

    @Step("get Excel Matrix_nXm")
    public void getExcelMatrix_nXm(int sheetNumber, int row1, int col1) {
        String data1 = null;
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                sheet1 = wb.getSheetAt(sheetNumber);
                data1 = sheet1.getRow(i).getCell(j).getStringCellValue();
                typeInto(By.cssSelector("#twotabsearchtextbox"), data1);
                click(By.cssSelector("#nav-search-submit-button"));
                System.out.println(data1);
            }
        }

        Allure.addAttachment("get Excel Matrix_nXm", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("read Excel Search Item 2")
    public void readExcelSearchItem2() {
        File src = new File("C:/Users/itays/IdeaProjects/Amazon/src/main/java/DataBase/AmazonData.xlsx");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(src);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        XSSFWorkbook wb1 = null;
        try {
            wb1 = new XSSFWorkbook(fis);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        XSSFSheet sheet11 = wb1.getSheetAt(0);
        String data0 = sheet11.getRow(0).getCell(1).getStringCellValue();
        typeInto(By.cssSelector("#twotabsearchtextbox"), data0);
        click(By.cssSelector("#nav-search-submit-button"));
        System.out.println("Data from excel " + data0);
        System.out.println();

        try {
            wb1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Allure.addAttachment("read Excel Search Item 2", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}


