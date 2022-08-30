package SeleniumHelper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {
    // 1=firefox 2=chrome 3=edge
    public static WebDriver createDriverObj(int browserType)
    {
        WebDriver driver = null;
        switch (browserType) {
            case 1:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case 2:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;


            default:
                break;
        }

        return driver;
    }
}
