package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settingscalc.Calculator;
import java.util.ArrayList;
import static util.WebelementUnils.*;

public class PageWithSettingsOfCalculator extends AbstractForCloudGoogle {

    public static Double priceOnCalculatorPage;
    static ArrayList<String> tab;
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
    private WebElement fieldForInputGenerateMail;
    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement buttonSendEmail;
    @FindBy(xpath = "//md-card-content[@id='resultBlock']//div/b[contains(text(),Total)]")
    private WebElement priceCalculator;

    public PageWithSettingsOfCalculator(WebDriver driver) {
        super(driver);
    }

    public PageWithSettingsOfCalculator settingValueNumberOfInstances(Calculator calculator) {
        switchToFrame(driver, "myFrame");
        waitForVisibility(driver, numberOfInstances);
        numberOfInstances.sendKeys(String.valueOf(calculator.getNumberOfInstance()));
        logger.info("The number of instances has been successfully chose.");
        return this;
    }

    public PageWithSettingsOfCalculator settingValueOperatingSystem(Calculator calculator) {
        clickByCheckOption(driver, listOperatingSystem, typeOperatingSystem, calculator.getOperatingSystem());
        logger.info("The operating system has been successfully chose.");
        return this;
    }

    public PageWithSettingsOfCalculator settingValueMachineClass(Calculator calculator) {
        clickByCheckOption(driver, listMachineClass, typeMachineClass, calculator.getMachineClass());
        logger.info("The machine class has been successfully chose.");
        return this;
    }

    public PageWithSettingsOfCalculator settingValueMachineType(Calculator calculator) {
        clickByCheckOption(driver, listMachineType, typeMachineType, calculator.getTypeMachineType());
        logger.info("The machine type has been successfully chose.");
        return this;
    }

    public PageWithSettingsOfCalculator settingAddGPU(Calculator calculator) {
        click(driver, addGPU);
        clickByCheckOption(driver, listNumberOfGPU, typeNumberOfGPU, String.valueOf(calculator.getNumberOfGPU()));
        clickByCheckOption(driver, listGPUType, typeGPUType, calculator.getTypeGPUType());
        logger.info("The option, that describe GPU, has been successfully chose.");
        return this;
    }

    public PageWithSettingsOfCalculator settingValueLocalSSD(Calculator calculator) {
        clickByCheckOption(driver, listLocalSSD, typeLocalSSD, calculator.getLocalSSD());
        logger.info("The local SSD has been successfully chose.");
        return this;
    }

    public PageWithSettingsOfCalculator settingValueDatacenterLocation(Calculator calculator) {
        clickByCheckOption(driver, listDatacenterLocation, typeDatacenterLocation, calculator.getDatacenterLocation());
        logger.info("The datacenter location has been successfully chose.");
        return this;
    }

    public PageWithSettingsOfCalculator settingValueCommittedUsage(Calculator calculator) {
        clickByCheckOption(driver, listCommittedUsage, typeCommittedUsage, String.valueOf(calculator.getCommittedUsage()));
        logger.info("The committed usage has been successfully chose.");
        return this;
    }

    public PageWithSettingsOfCalculator clickOnTheButtonAddToEstimate() {
        click(driver, buttonAddToEstimate);
        logger.info("The button \"Add To Estimate\" has been successfully clicked.");
        return this;
    }

    public PageWithSettingsOfCalculator clickOnButtonEmailEstimate() {
        switchToFrame(driver, "myFrame");
        click(driver, buttonEmailEstimate);
        logger.info("The calculator was successfully created.");
        return this;
    }

    public PageWithSettingsOfCalculator createNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        logger.info("New TAB was successfully created. Window switched.");
        return this;
    }

    public PageWithSettingsOfCalculator insertGeneratingMailInFieldInputMail() {
        waitForVisibility(driver, fieldForInputGenerateMail);
        fieldForInputGenerateMail.sendKeys(GenerateMailPage.generateMail);
        return this;
    }

    public PageWithSettingsOfCalculator clickOnTheButtonSendEmail() {
        click(driver, buttonSendEmail);
        logger.info("The settings of calculator was success send on generate email");
        return this;
    }

    public void getPriceInCalculatorPage() {
        driver.switchTo().window(tab.get(0));
        switchToFrame(driver, "myFrame");
//        WebElement priceCalculator = new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-card-content[@id='resultBlock']//div/b[contains(text(),Total)]")));
        String s = priceCalculator
                .getText()
                .replace("1 month", "")
                .replaceAll("[^0-9.]", "");
        priceOnCalculatorPage = Double.parseDouble(s);
        logger.info("The price on calculator successfully get.");
    }
}
