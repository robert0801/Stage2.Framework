package page;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;


public class GenerateMailPage{


    public static Double priceOnGenerateMailPage;
    public static String generateMail;

    private final Logger logger = LogManager.getRootLogger();

    public GenerateMailPage getToMailPage(){
        Selenide.open("https://10minutemail.com/");
        return this;
    }

    public GenerateMailPage copyMail() {
        generateMail = $(By.xpath("//input[@id='mail_address']")).waitUntil(not(attribute("value", "")), 10000)
                .getAttribute("value");
        Selenide.switchTo().window(PageWithSettings.tab.get(0));
        logger.info("Generate email");
        return this;

    }

    public GenerateMailPage clickToOpenMail() {
        
        switchTo().window(PageWithSettings.tab.get(1));
        $(By.xpath("//*[@id='mail_messages_content']")).waitWhile(empty, 20000);
        JavascriptExecutor executor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", $(By.xpath("//*[@id='mail_messages_content']")));
        $(By.xpath("//*[@id='mail_messages_content']")).click();
        logger.info("The email was success open");
        return this;
    }

    public void getPriceOnGenerateMailPage() {
        String s = $(By.xpath("//h3[contains(text(), 'USD')]")).waitUntil(visible, 20000)
                .getText()
                .replace("USD ", "")
                .replaceAll("[^0-9.]","");
        priceOnGenerateMailPage = Double.parseDouble(s);
        System.out.println(priceOnGenerateMailPage);
    }
}
