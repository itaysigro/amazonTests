package SeleniumHelper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseMethods {
    private WebDriver driver;
    private WebDriverWait wait;

    public BaseMethods(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public BaseMethods(WebDriverWait wait) {
        super();
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    // ======================================================================================================================
    // waits

    public void waitForStaleNessOfSomeElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.stalenessOf((WebElement) locator));
    }

    public void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    // ======================================================================================================================

    // find elements
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findMultipleElements(By locator) {
        return driver.findElements(locator);
    }

    // ======================================================================================================================

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getTextByLocator(By locator) {
        return driver.findElement(locator).getText();
    }

    public WebElement typeInto(By locator, String inputText) {
        findElement(locator).sendKeys(inputText);
        return findElement(locator);
    }

    public void removeInput(By locator) {
        for (int i = 0; i < 50; i++) {
            findElement(locator).sendKeys(Keys.BACK_SPACE);
        }
    }

    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public void visit(String url) {
        driver.get(url);
    }

    public void waitForStaleNessOfSomeElement(WebElement webElement) {
        System.out.println("starting the wait proccess");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
}
