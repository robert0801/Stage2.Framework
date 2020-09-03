package page;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;


public class GenerateMailPage extends AbstractForCloudGoogle{

    public static Double priceOnGenerateMailPage;
    public static String generateMail;
    private By mailAddress = By.xpath("//input[@id='mail']");
    private By mailPage = By.xpath("//a[@class='viewLink title-subject'][text()]");
    private By fieldWithCostOnGenerateMailPage = By.xpath("//h3[contains(text(), 'USD')]");
    private By fieldWithSentMail = By.xpath("//div[@class='inbox-area maillist']");

    public GenerateMailPage getToMailPage(){
        Selenide.open("https://10minemail.com/ru/");
        return this;
    }

    public GenerateMailPage copyMail() {
        generateMail = $(mailAddress).waitUntil(not(attribute("value", "")), 10000)
                .getAttribute("value");
        Selenide.switchTo().window(PageWithSettingsOfCalculator.tab.get(0));
        logger.info("Generate email success coping.");
        return this;

    }

    public GenerateMailPage clickToOpenMail() {
        switchTo().window(PageWithSettingsOfCalculator.tab.get(1));
        $(mailPage).waitWhile(empty, 30000);
        JavascriptExecutor executor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", $(fieldWithSentMail));
        $(mailPage).click();
        logger.info("The email was success open");
        return this;
    }

    public void getPriceOnGenerateMailPage() {
        String s = $(fieldWithCostOnGenerateMailPage).waitUntil(visible, 20000)
                .getText()
                .replace("USD ", "")
                .replaceAll("[^0-9.]","");
        priceOnGenerateMailPage = Double.parseDouble(s);
        System.out.println(priceOnGenerateMailPage);
    }
}
