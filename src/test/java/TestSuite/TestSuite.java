package TestSuite;

import Utilities.IntWebDriver;
import Tests.TestPageAmazonHome;
import Tests.TestPageAmazonRegister;
import Tests.TestPageAmazonShoppingCart;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSuite {
    WebDriver wd;

    @BeforeClass
    public void setup() {
        wd = IntWebDriver.createDriverObj(2);
    }

    @Test(priority = 1)
    @Description("Visit Amazon And Click Register")
    public void testCase1() {
        TestPageAmazonHome tpa = new TestPageAmazonHome(wd);
        tpa.runTest_Entrance_Registration();
    }

    @Test(priority = 2)
    @Description("Registration and Validate Registration")
    public void testCase2() {
        TestPageAmazonRegister tpa = new TestPageAmazonRegister(wd);
        tpa.runTestcaseclickContinueWIthEmptyFeildsRgister();
        tpa.runTestcaseNameAndEmailRgister();
        tpa.runTestcasePassRgisterScreen();
    }

    @Test(priority = 3)
    @Description("Enter Items Properties in srach filed and enter to shopping cart")
    public void testCase3() {
        TestPageAmazonShoppingCart tpas = new TestPageAmazonShoppingCart(wd);
        tpas.runTestcase3();
    }

    @Test(priority = 4)
    @Description("Shopping cart")
    public void testCase4() {
        TestPageAmazonShoppingCart tpas = new TestPageAmazonShoppingCart(wd);
        tpas.runTestcase4();
    }

    @AfterTest
    public void Teardown() {
        wd.quit();
    }
}
