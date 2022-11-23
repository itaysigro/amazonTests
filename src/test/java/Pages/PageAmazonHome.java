package Pages;

import Utilities.BaseMethods;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.ByteArrayInputStream;
import java.util.List;

public class PageAmazonHome extends BaseMethods {
    public PageAmazonHome(WebDriver driver) {
        super(driver);
    }

    public PageAmazonHome(WebDriverWait wait) {
        super(wait);
    }

    WebDriverWait wait = null;
    @Step("visit Amazon")
    public void visitAmazon() {
        visit("https://amazon.com");
        getDriver().manage().window().maximize();

        Allure.addAttachment("visit Amazon", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("click New Register")
    public void clickNewRegister() {
        click(By.cssSelector("#nav-link-accountList-nav-line-1"));
        click(By.cssSelector("#createAccountSubmit"));

        Allure.addAttachment("click New Register", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("click Filed Search")
    public void clickFiledSearch() {
        click(By.cssSelector("#twotabsearchtextbox"));

        Allure.addAttachment("click Filed Search", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("get Word Results")
    public void getWordResults() {
        System.out.println(findElement(By.xpath("//*[contains(text(),'results ')]")).getText());

        Allure.addAttachment("get Word Results", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("click First Result")
    public void clickFirstResult() {
      try {
            click(By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']"));

            Allure.addAttachment("click First Result", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        }catch (Exception e){
           System.out.println("Elem Not Found!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    @Step("choose Books Side Tool Bar")
    public void chooseBooksSideToolBar() {
        WebElement books = findElement(By.xpath("//*[@id=\"n/283155\"]/span/a/span"));
        books.click();

        Allure.addAttachment("choose Books Side Tool Bar", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("chose Cards Side Tool Bar")
    public void choseCardsSideToolBar() {
        //findElement(By.xpath("//*[@id=\"departments\"]/ul"));
        WebElement choseCards = findElement(By.cssSelector("#n\\/166239011 > span > a"));
        // WebElement choseCards = findElement(By.xpath("//*[@id=\"n/166239011\"]"));
        choseCards.click();

        Allure.addAttachment("chose Cards Side Tool Bar", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("click Top 4 Stars Side Tool Bar")
    public void clickTop4StarsSideToolBar() {
        WebElement ChoseTop4Stars = findElement(By.cssSelector("[class='a-icon a-icon-star-medium a-star-medium-4']"));
        // WebElement ChoseTop4Stars = findElement(By.xpath("//*[@id=\"p_72/1248963011\"]/span/a"));
        //*[@id="p_72/3014475011"]   //*[@id="p_72/3014475011"]/span/a
        ChoseTop4Stars.click();

        Allure.addAttachment("click Top 4 Stars Side Tool Bar", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("random Pick Ultimate Rare Card Bundele")
    public void randomPickUltimateRareCardBundele() {
        WebElement choseAnyUltimateRareCardBundle = findElement(By.xpath("//*[contains(text(),'Rare Card Bundle')]"));
        System.out.println(choseAnyUltimateRareCardBundle.getText());
        choseAnyUltimateRareCardBundle.click();

        Allure.addAttachment("random Pick Ultimate Rare Card Bundele", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
