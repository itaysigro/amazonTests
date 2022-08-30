package Pages;

import SeleniumHelper.BaseMethods;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
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

    public void waitForStaleAndcatchAllElement() {
        List<WebElement> lst = findMultipleElements(By.cssSelector("[class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
        WebElement num = null;
        try {
            for (int i = 0; i < 20; i++) {
                System.out.println(lst.get(i).getText());
                WebElement e = lst.get(i);
                for (int j = 0; j < 5; j++) {
                    waitForStaleNessOfSomeElement(lst.get(i));
                    lst.add(i,num);
                }
                System.out.println("this is num " + num.getText());
            }

        }catch(StaleElementReferenceException e) {
            System.out.println("element is not attached to the page document");
            System.out.println(e.getMessage());
        }
    }

    @Step("check Price Cart")
    public void checkPriceCart() {
        float sum = 0;
        ArrayList<String> str3 = new ArrayList<String>();
        List<String> ss = new ArrayList<String>();
        List<WebElement> lst = findMultipleElements(By.cssSelector("[class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
        String str = "";
        String str2 = str;
        String[] str4 = {};


        String[] dsa ;


        for (WebElement curr : lst){
            for (int i = 1; i < lst.size(); i++) {
               String kkk = curr.getText().toString();
                str4[i] = kkk;
            }
            System.out.print("******************" + str4[1] + "*******************");
        }




//        for (int i = 0; i < 10 ; i++) {
//            dsa[i] = kkk
//        }
//
//
//
//        Object[] objects = lst.toArray();
//        // Printing array of objects
//        for (Object obj : objects)
//            System.out.print(obj + " ");
//    }
//
//}

//        for (WebElement curr: lst) {
//            ss.add(curr.getText());
//        }
//
//        for (int i = 0; i < 20; i++) {
//
//            Float sum12 = (float)ss;
//        }
//
//
//        System.out.println("Index "+ind);


//        for (int i = 0; i < lst.size(); i++) {
//            if (lst.get(i).isDisplayed()){
//                str = lst.get(i).getText();
//                str3[lst.get(i)] = str;
//
//                str4[lst.get(i)] = str;
//            }
//        }

        /*for (WebElement curr : lst) {

            if (curr.isDisplayed()) {
                String str = curr.getText();
                str2 = str2 + str;
                str3.get(curr);

            }
            waitForStaleNessOfSomeElement();
        }*/

        System.out.println(str2);
        /*waitForStaleAndcatchAllElement();
        int[] arr = {0,0,0};
        for (int i = 0; i < lst.size(); i++) {

            WebElement e  =lst.get(i);
            System.out.println(e.getText());

        }*/

        Allure.addAttachment("check Price Cart", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("click Gift")
    public void clickGift() {
        click(By.cssSelector("#sc-buy-box-gift-checkbox"));

        Allure.addAttachment("click Gift", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("click Check Out Buy")
    public void clickCheckOutBuy() {
        click(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input"));

        Allure.addAttachment("click Check Out Buy", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }


}
