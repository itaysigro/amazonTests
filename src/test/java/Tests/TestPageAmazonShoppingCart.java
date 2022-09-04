package Tests;

import Pages.PageAmazonShoppingCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPageAmazonShoppingCart {
    private WebDriver driver;
    private WebDriverWait wait;

    public TestPageAmazonShoppingCart(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public TestPageAmazonShoppingCart(WebDriverWait wait) {
        super();
        this.wait = wait;
    }

    public TestPageAmazonShoppingCart() {
        super();
    }

    public void runTestcase3() {
        PageAmazonShoppingCart pas = new PageAmazonShoppingCart(driver);
        TestPageAmazonHome tap = new TestPageAmazonHome(driver);
        tap.case1_RunSearchItem1();
        pas.addToCart();
        tap.case2_RunSearchItem2();
        pas.addToCart();
        pas.clickShoppingCart();
    }

    public void runTestcase4() {
        PageAmazonShoppingCart pas = new PageAmazonShoppingCart(driver);
        pas.clickGift();
        pas.clickCheckOutBuy();
    }
}
