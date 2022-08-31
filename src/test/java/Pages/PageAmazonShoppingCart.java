package Pages;

import SeleniumHelper.BaseMethods;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.ByteArrayInputStream;
import java.util.List;


public class PageAmazonShoppingCart extends BaseMethods {
    public PageAmazonShoppingCart(WebDriver driver) {
        super(driver);
    }

    public PageAmazonShoppingCart(WebDriverWait wait) {
        super(wait);
    }

    @Step("add To Cart")
    public void addToCart() {
        WebElement cart = findElement(By.cssSelector("#add-to-cart-button"));
        cart.click();

        Allure.addAttachment("add To Cart", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("click Shopping Cart")
    public void clickShoppingCart() {
        click(By.cssSelector("#nav-cart-count-container"));

        Allure.addAttachment("click Shopping Cart", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("click Gift")
    public void clickGift() {
        click(By.cssSelector("#sc-buy-box-gift-checkbox"));

        Allure.addAttachment("click Gift", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("click Check Out Buy")
    public void clickCheckOutBuy() {
       // waitForStaleNessOfSomeElement(By.cssSelector("#sc-buy-box-ptc-button"));
        click(By.cssSelector("#sc-buy-box-ptc-button > span > input"));
        /*WebElement BuyCart = findElement(By.cssSelector("#sc-buy-box-ptc-button"));
        BuyCart.click();*/

        Allure.addAttachment("click Check Out Buy", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }


}
