package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class AbstractForCloudGoogle {

    protected WebDriver driver;

    public AbstractForCloudGoogle(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
