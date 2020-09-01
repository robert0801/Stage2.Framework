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
import settingscalc.Calculator;

import java.util.ArrayList;

public class PageWithSettings extends AbstractForCloudGoogle {

    public static Double priceOnCalculatorPage;
    static ArrayList<String> tab;
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//input[contains(@ng-model,'quantity')]")
    private WebElement numberOfInstances;
    @FindBy(xpath = "//label[text()='Operating System / Software']/../md-select")
    private WebElement listOperatingSystem;
    private String typeOperatingSystem = "//md-option[@value='%s']";
    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement listMachineClass;
    private String typeMachineClass = "//md-select-menu[@style=contains(text(), '')]/descendant::md-option[@value='%s']";
    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement listMachineType;
    private String typeMachineType = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-%s']";
    @FindBy(xpath = "//*[contains(@ng-model,'GPU')]")
    private WebElement addGPU;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement listNumberOfGPU;
    private String typeNumberOfGPU = "//div[normalize-space()='%s']/parent::md-option";
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement listGPUType;
    private String typeGPUType = "//md-option[@value='%s']";
    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement listLocalSSD;
    private String typeLocalSSD = "//div[normalize-space()='%s GB']/parent::md-option";
    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement listDatacenterLocation;
    private String typeDatacenterLocation = "//md-select-menu[@class='md-overflow']/descendant::div[contains(text(), '%s')]/parent::md-option";
    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement listCommittedUsage;
    private String typeCommittedUsage = "//md-select-menu[contains(@style, 'transform-origin')]//div[text()='%s']/parent::md-option";
    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimate;
    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement buttonEmailEstimate;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement buttonInputMail;
    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement buttonSendEmail;

    public PageWithSettings(WebDriver driver) {
        super(driver);
    }

    public PageWithSettings checkNumberOfInstances(Calculator calculator) {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        waitForVisibility(numberOfInstances);
        numberOfInstances.sendKeys(String.valueOf(calculator.getNumberOfInstance()));
        return this;
    }

    public PageWithSettings checkOperatingSystem(Calculator calculator) {
        click(listOperatingSystem);
        clickByCheckOption(typeOperatingSystem, calculator.getOperatingSystem());
        return this;
    }

    public PageWithSettings checkMachineClass(Calculator calculator) {
        click(listMachineClass);
        clickByCheckOption(typeMachineClass, calculator.getMachineClass());
        return this;
    }

    public PageWithSettings checkMachineType(Calculator calculator) {
        click(listMachineType);
        clickByCheckOption(typeMachineType, calculator.getTypeMachineType());
        return this;
    }

    public PageWithSettings checkAddGPU(Calculator calculator) {
        click(addGPU);
        click(listNumberOfGPU);
        clickByCheckOption(typeNumberOfGPU, String.valueOf(calculator.getNumberOfGPU()));
        click(listGPUType);
        clickByCheckOption(typeGPUType, calculator.getTypeGPUType());
        return this;
    }

    public PageWithSettings checkLocalSSD(Calculator calculator) {
        click(listLocalSSD);
        clickByCheckOption(typeLocalSSD, calculator.getLocalSSD());
        return this;
    }

    public PageWithSettings checkDatacenterLocation(Calculator calculator) {
        click(listDatacenterLocation);
        clickByCheckOption(typeDatacenterLocation, calculator.getDatacenterLocation());
        return this;
    }

    public PageWithSettings checkCommittedUsage(Calculator calculator) {
        click(listCommittedUsage);
        clickByCheckOption(typeCommittedUsage, String.valueOf(calculator.getCommittedUsage()));
        return this;
    }

    public PageWithSettings addToEstimate() {
        click(buttonAddToEstimate);
        return this;
    }

    public PageWithSettings emailEstimate() {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        click(buttonEmailEstimate);
        logger.info("Create calculator on page with some settings");
        return this;
    }

    public PageWithSettings createNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        return this;
    }

    public PageWithSettings checkInputMail() {
        waitForVisibility(buttonInputMail);
        buttonInputMail.sendKeys(GenerateMailPage.generateMail);
        return this;
    }

    public PageWithSettings checkSendEmail() {
        click(buttonSendEmail);
        logger.info("The settings of calculator was success send on generate email");
        return this;
    }

    public void getPriceInCalculator() {
        driver.switchTo().window(tab.get(0));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        WebElement priceCalculator = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-card-content[@id='resultBlock']//div/b[contains(text(),Total)]")));
        String s = priceCalculator
                .getText()
                .replace("1 month", "")
                .replaceAll("[^0-9.]", "");
        priceOnCalculatorPage = Double.parseDouble(s);
    }
}
