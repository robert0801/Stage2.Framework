package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class AbstractForCloudGoogle {

    protected WebDriver driver;
    protected final Logger logger = LogManager.getRootLogger();

    public AbstractForCloudGoogle(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
