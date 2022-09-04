package Tests;

import DataBase.Excel;
import Pages.PageAmazonHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestPageAmazonHome {
    private WebDriver driver;
    private WebDriverWait wait;

    public TestPageAmazonHome(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public void runTest_Entrance_Registration() {
        PageAmazonHome page = new PageAmazonHome(driver);
        page.visitAmazon();
        page.clickNewRegister();
    }

    public void case1_RunSearchItem1() {
        PageAmazonHome page = new PageAmazonHome(driver);
        Excel ex = new Excel(driver);
        page.visitAmazon();
        page.clickFiledSearch();
        ex.readExcelSearchItem1("C:/Users/itays/IdeaProjects/Amazon/src/main/java/DataBase/AmazonData.xlsx");
        ex.getExcelMatrix_nXm(0, 1, 1);
        page.getWordResults();
        page.chooseBooksSideToolBar();
        page.clickFirstResult();
    }

    public void case2_RunSearchItem2() {
        PageAmazonHome page = new PageAmazonHome(driver);
        Excel ex = new Excel(driver);
        page.clickFiledSearch();
        ex.readExcelSearchItem2();
        page.getWordResults();
        page.choseCardsSideToolBar();
        page.clickTop4StarsSideToolBar();
        page.randomPickUltimateRareCardBundele();
    }
}
