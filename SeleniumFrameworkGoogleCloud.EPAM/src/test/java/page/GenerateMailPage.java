package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GenerateMailPage extends AbstractForCloudGoogle {

    public static Double priceOnGenerateMailPage;
    public static String generateMail;
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//input[@id='mail_address']")
    private WebElement mailAddress;

    public GenerateMailPage(WebDriver driver) {
        super(driver);
    }

    public GenerateMailPage getToMailPage() {
        driver.get("https://10minutemail.com/");
        return this;
    }

    public GenerateMailPage copyMail() {
        Boolean checkCopyMail = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.attributeToBeNotEmpty(mailAddress, "value"));
        if (checkCopyMail) {
            generateMail = mailAddress.getAttribute("value");
        }
        driver.switchTo().window(PageWithSettings.tab.get(0));
        logger.info("Generate email");
        return this;

    }

    public GenerateMailPage clickToOpenMail() {
        driver.switchTo().window(PageWithSettings.tab.get(1));
        WebElement mailPage = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mail_messages_content']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mailPage);
        mailPage.click();
        logger.info("The email was success open");
        return this;
    }

    public void getPriceOnGenerateMailPage() {
        WebElement priceCalculatorOnMailPage = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(), 'USD')]")));
        String s = priceCalculatorOnMailPage
                .getText()
                .replace("USD ", "")
                .replaceAll("[^0-9.]", "");
        priceOnGenerateMailPage = Double.parseDouble(s);
    }
}
