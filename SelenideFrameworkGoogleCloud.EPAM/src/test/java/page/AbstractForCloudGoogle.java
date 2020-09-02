package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class AbstractForCloudGoogle {
    protected final Logger logger = LogManager.getRootLogger();
    protected void click(By element){
        $(element).waitUntil(visible, 10000).pressEnter();
    }

    protected void clickByCheckOption(By listWithOptions, String listOfOption, String option){
        click(listWithOptions);
        $(By.xpath(String.format(listOfOption, option))).waitUntil(visible, 10000).pressEnter();
    }
}
