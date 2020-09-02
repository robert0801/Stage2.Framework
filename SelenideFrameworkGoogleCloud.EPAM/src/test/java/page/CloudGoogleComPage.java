package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
public class CloudGoogleComPage extends AbstractForCloudGoogle{

    public PageWithSettingsOfCalculator getToStartPageWithSearchingLine(){
        Selenide.open("/");
        $(By.xpath("//input[@type='text']")).setValue("Google Cloud Platform Pricing Calculator").pressEnter();
        $(By.xpath("//a[@data-ctorig='https://cloud.google.com/products/calculator']")).waitUntil(Condition.visible, 10000).click();
        logger.info("Open web site with Cloud Calculator");
        return new PageWithSettingsOfCalculator();
    }
}
