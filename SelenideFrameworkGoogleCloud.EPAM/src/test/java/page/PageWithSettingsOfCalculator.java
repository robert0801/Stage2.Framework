package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import settingscalc.Calculator;
import org.openqa.selenium.*;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PageWithSettingsOfCalculator extends AbstractForCloudGoogle{

    static ArrayList<String> tab;
    public static Double priceOnCalculatorPage;

    private By numberOfInstances = By.xpath("//input[contains(@ng-model,'quantity')]");
    private By listOperatingSystem = By.xpath("//label[text()='Operating System / Software']/../md-select");
    private String typeOperatingSystem = "//md-option[@value='%s']";
    private By listMachineClass = By.xpath("//md-select[@placeholder='VM Class']");
    private String typeMachineClass = "//md-select-menu[@style=contains(text(), '')]/descendant::md-option[@value='%s']";
    private By listMachineType = By.xpath("//md-select[@placeholder='Instance type']");
    private String typeMachineType = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-%s']";
    private By addGPU = By.xpath("//*[contains(@ng-model,'GPU')]");
    private By listNumberOfGPU = By.xpath("//md-select[@placeholder='Number of GPUs']");
    private String typeNumberOfGPU = "//div[normalize-space()='%s']/parent::md-option";
    private By listGPUType = By.xpath("//md-select[@placeholder='GPU type']");
    private String typeGPUType = "//md-option[@value='%s']";
    private By listLocalSSD = By.xpath("//md-select[@placeholder='Local SSD']");
    private String typeLocalSSD = "//div[normalize-space()='%s GB']/parent::md-option";
    private By listDatacenterLocation = By.xpath("//md-select[@placeholder='Datacenter location']");
    private String typeDatacenterLocation = "//md-select-menu[@class='md-overflow']/descendant::div[contains(text(), '%s')]/parent::md-option";
    private By listCommittedUsage = By.xpath("//md-select[@placeholder='Committed usage']");
    private String typeCommittedUsage = "//md-select-menu[contains(@style, 'transform-origin')]//div[text()='%s']/parent::md-option";
    private By buttonAddToEstimate = By.xpath("//button[@aria-label='Add to Estimate']");
    private By buttonEmailEstimate = By.xpath("//button[@id='email_quote']");
    private By fieldForInputGenerateMail = By.xpath("//input[@type='email']");
    private By buttonSendEmail = By.xpath("//button[@aria-label='Send Email']");

    public PageWithSettingsOfCalculator settingValueNumberOfInstances(Calculator calculator){
        Selenide.switchTo().frame(0);
        Selenide.switchTo().frame("myFrame");
        $(numberOfInstances).waitUntil(visible, 10000).setValue(String.valueOf(calculator.getNumberOfInstance()));
        return this;
    }

    public PageWithSettingsOfCalculator settingValueOperatingSystem(Calculator calculator){
        clickByCheckOption(listOperatingSystem, typeOperatingSystem, calculator.getOperatingSystem());
        return this;
    }

    public PageWithSettingsOfCalculator settingValueMachineClass(Calculator calculator){
        clickByCheckOption(listMachineClass, typeMachineClass, calculator.getMachineClass());
        return this;
    }

    public PageWithSettingsOfCalculator settingValueMachineType(Calculator calculator){
        clickByCheckOption(listMachineType, typeMachineType, calculator.getTypeMachineType());
        return this;
    }

    public PageWithSettingsOfCalculator settingAddGPU(Calculator calculator){
        click(addGPU);
        clickByCheckOption(listNumberOfGPU, typeNumberOfGPU, String.valueOf(calculator.getNumberOfGPU()));
        clickByCheckOption(listGPUType, typeGPUType, calculator.getTypeGPUType());
        return this;
    }

    public PageWithSettingsOfCalculator settingValueLocalSSD(Calculator calculator){
        clickByCheckOption(listLocalSSD, typeLocalSSD, calculator.getLocalSSD());
        return this;
    }

    public PageWithSettingsOfCalculator settingValueDatacenterLocation(Calculator calculator){
        clickByCheckOption(listDatacenterLocation, typeDatacenterLocation, calculator.getDatacenterLocation());
        return this;
    }

    public PageWithSettingsOfCalculator settingValueCommittedUsage(Calculator calculator){
        clickByCheckOption(listCommittedUsage, typeCommittedUsage, String.valueOf(calculator.getCommittedUsage()));
        return this;
    }

    public PageWithSettingsOfCalculator clickOnTheButtonAddToEstimate(){
        click(buttonAddToEstimate);
        return this;
    }

    public PageWithSettingsOfCalculator clickOnButtonEmailEstimate(){
        Selenide.switchTo().frame(0);
        Selenide.switchTo().frame("myFrame");
        $(buttonEmailEstimate).waitUntil(visible, 10000).click();
        return this;
    }

    public PageWithSettingsOfCalculator createNewTab(){
        executeJavaScript("window.open()");
        tab = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
        Selenide.switchTo().window(tab.get(1));
        return this;
    }

    public PageWithSettingsOfCalculator insertGeneratingMailInFieldInputMail(){
        $(fieldForInputGenerateMail).waitUntil(visible, 10000).setValue(GenerateMailPage.generateMail);
        return this;
    }

    public PageWithSettingsOfCalculator clickOnTheButtonSendEmail(){
        click(buttonSendEmail);
        logger.info("The settings of calculator was success send on generate email");
        return this;
    }

    public void getPriceInCalculatorPage(){
        Selenide.switchTo().window(tab.get(0));
        Selenide.switchTo().frame(0);
        Selenide.switchTo().frame("myFrame");
        SelenideElement priceCalculator = $(By.xpath("//md-card-content[@id='resultBlock']//div/b[contains(text(),Total)]"))
                .waitUntil(visible, 10000);
        String s = priceCalculator
                .getText()
                .replace("1 month","")
                .replaceAll("[^0-9.]", "");
        priceOnCalculatorPage = Double.parseDouble(s);
        System.out.println(priceOnCalculatorPage);
    }
}
