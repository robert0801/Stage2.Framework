package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    @FindBy(xpath = "//input[@id='mail']")
    private WebElement mailAddress;
    @FindBy(xpath = "//h3[contains(text(), 'USD')]")
    private WebElement priceCalculatorOnMailPage;
    @FindBy(xpath = "//*[@id='inbox_count_number']")
    private WebElement countOfSentMail;
    @FindBy(xpath = "//a[@class='viewLink title-subject'][text()]")
    private WebElement mailPage;

    public GenerateMailPage(WebDriver driver) {
        super(driver);
    }

    public GenerateMailPage getToMailPage() {
        driver.get("https://10minemail.com/ru/");
        return this;
    }

    public GenerateMailPage copyMail() {
        Boolean checkCopyMail = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.attributeToBeNotEmpty(mailAddress, "value"));
        if (checkCopyMail) {
            generateMail = mailAddress.getAttribute("value");
        }
        driver.switchTo().window(PageWithSettingsOfCalculator.tab.get(0));
        logger.info("Email is generate succesfully.");
        return this;

    }

    public GenerateMailPage clickToOpenMail() {
        driver.switchTo().window(PageWithSettingsOfCalculator.tab.get(1));
        waitForVisibility(mailPage);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mailPage);
        mailPage.click();
        logger.info("The email was success open");
        return this;
    }

    public void getPriceOnGenerateMailPage() {
        waitForVisibility(priceCalculatorOnMailPage);
        String s = priceCalculatorOnMailPage
                .getText()
                .replace("USD ", "")
                .replaceAll("[^0-9.]", "");
        priceOnGenerateMailPage = Double.parseDouble(s);
    }
}
