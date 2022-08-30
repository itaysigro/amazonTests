package Tests;

import Pages.PageAmazonRegister;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPageAmazonRegister {
    private WebDriver driver;
    private WebDriverWait wait;

    public TestPageAmazonRegister(WebDriver driver) {
        super();
        this.driver = driver;
        this.wait = wait;
    }

    public void runTestcaseclickContinueWIthEmptyFeildsRgister(){
        PageAmazonRegister page = new PageAmazonRegister(driver);
        page.clickContinueWIthEmptyFeildsOrJustContinue();
    }

    public void runTestcaseNameAndEmailRgister(){
        PageAmazonRegister page = new PageAmazonRegister(driver);
        page.verifyName();
        page.verifyEmailEmptyField();
        page.verifyWorngEmailField();
    }
    public void runTestcasePassRgisterScreen() {
        PageAmazonRegister page = new PageAmazonRegister(driver);
        page.verifyPassUnder6CharOrEmpty();
        page.verifyRePassEmpty();
        page.verifyRePassMatch();
        page.returnToHomePage();
    }
}
