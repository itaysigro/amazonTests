package Pages;

import SeleniumHelper.BaseMethods;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;

public class PageAmazonRegister extends BaseMethods {
    public PageAmazonRegister(WebDriver driver) {
        super(driver);
    }

    public PageAmazonRegister(WebDriverWait wait) {
        super(wait);
    }

    @Step("verify continue with Empty Fields")
    public void clickContinueWIthEmptyFeildsOrJustContinue() {
        click(By.cssSelector("#continue"));

        Allure.addAttachment("verify continu with Empty Fields", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("verify Name Field")
    public void verifyName() {
        WebElement name = findElement(By.xpath("//*[contains(text(),'Enter your name')]"));
        if (name.isDisplayed()) {
            findElement(By.cssSelector("#ap_customer_name")).sendKeys("Itay Sigron");
            click(By.cssSelector("#continue"));

            Allure.addAttachment("verify Name Field", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
    }

    @Step("verify Email Field Description(Enter your email or mobile phone number)")
    public void verifyEmailEmptyField() {
        WebElement errorEmail = findElement(By.xpath("//*[contains(text(),'Enter your email or mobile phone number')]"));
        if (errorEmail.isDisplayed()) {
            findElement(By.cssSelector("#ap_email")).sendKeys("aaaa.co.il");
            click(By.cssSelector("#continue"));

            Allure.addAttachment("verify Email Field Description(Enter your email or mobile phone number", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
    }

    @Step("verify Email Description(Wrong Or Invalid Email Address Or Mobile Phone Number Please Correct And Try Again)")
    public void verifyWorngEmailField() {
        WebElement errorEmail = findElement(By.xpath("//*[contains(text(),'Wrong or Invalid email address or mobile phone number. Please correct and try again')]"));
        if (errorEmail.isDisplayed()) {
            removeInput(By.cssSelector("#ap_email"));
            findElement(By.cssSelector("#ap_email")).sendKeys("aaaa@gmail.com");
            click(By.cssSelector("#continue"));

            Allure.addAttachment("verify Email Description(Wrong Or Invalid Email Address Or Mobile Phone Number Please Correct And Try Again", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));

        }
    }

    @Step("pass Under 6 Char Or Empty")
    public void verifyPassUnder6CharOrEmpty() {
        WebElement passUnder6CharOrEmpty = findElement(By.xpath("//*[contains(text(),'Minimum 6 characters required')]"));
        if (passUnder6CharOrEmpty.isDisplayed()) {
            findElement(By.cssSelector("#ap_password")).sendKeys("123456");
            click(By.cssSelector("#continue"));

            Allure.addAttachment("pass Under 6 Char Or Empty", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
    }

    @Step("RePass Empty")
    public void verifyRePassEmpty() {
        WebElement rePassEmpty = findElement(By.xpath("//*[contains(text(),'Type your password again')]"));
        if (rePassEmpty.isDisplayed()) {
            findElement(By.cssSelector("#ap_password_check")).sendKeys("12345");
            click(By.cssSelector("#continue"));

            Allure.addAttachment("RePass Empty", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
    }

    @Step("RePass Match")
    public void verifyRePassMatch() {
        WebElement rePassMatch = findElement(By.xpath("//*[contains(text(),'Passwords must match')]"));
        if (rePassMatch.isDisplayed()) {
            removeInput(By.cssSelector("#ap_password_check"));
            findElement(By.cssSelector("#ap_password_check")).sendKeys("123456");
            click(By.cssSelector("#continue"));
            System.out.println("i cant continue to register because they have robot verify");

            Allure.addAttachment("RePass Match", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
    }

    @Step("return To Home Page")
    public void returnToHomePage() {
        click(By.cssSelector("#a-page > div.a-section.a-padding-medium.auth-workflow > div.a-section.a-spacing-none.auth-navbar > div > a"));

        Allure.addAttachment("return To Home Page", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
