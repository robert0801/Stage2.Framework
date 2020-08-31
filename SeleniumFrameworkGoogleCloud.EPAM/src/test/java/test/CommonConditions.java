package test;

import driver.DriverSingleton;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import util.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners({TestListener.class})
public class CommonConditions {

    private static final int VALUE_TIMEOUT = 20;
    protected WebDriver driver;

    @BeforeTest()
    public void setUp() {
        driver = DriverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(VALUE_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(VALUE_TIMEOUT, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        Dimension dimension = new Dimension(1920, 1000);
        driver.manage().window().setSize(dimension);
    }

    @AfterTest(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
