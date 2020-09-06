package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                }
            }
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}

