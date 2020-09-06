package test;

import driver.DriverSingleton;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    @BeforeTest()
    public void setUp() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
