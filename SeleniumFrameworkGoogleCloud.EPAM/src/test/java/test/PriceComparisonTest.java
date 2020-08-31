package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CloudGoogleComPage;
import page.GenerateMailPage;
import page.PageWithSettings;
import services.CalculatorCreator;
import settingscalc.Calculator;

public class PriceComparisonTest extends CommonConditions {
    @Test
    public void openPage() {
        Calculator testCalculator = CalculatorCreator.createCalculatorWithSomeProperty();
        PageWithSettings cloudPage = new CloudGoogleComPage(driver)
                .getToStartPage()
                .checkNumberOfInstances(testCalculator)
                .checkOperatingSystem(testCalculator)
                .checkMachineClass(testCalculator)
                .checkMachineType(testCalculator)
                .checkAddGPU(testCalculator)
                .checkLocalSSD(testCalculator)
                .checkDatacenterLocation(testCalculator)
                .checkCommittedUsage(testCalculator)
                .addToEstimate()
                .emailEstimate()
                .createNewTab();

        GenerateMailPage mailPage = new GenerateMailPage(driver)
                .getToMailPage()
                .copyMail();
        cloudPage
                .checkInputMail()
                .checkSendEmail()
                .getPriceInCalculator();
        mailPage
                .clickToOpenMail()
                .getPriceOnGenerateMailPage();

    }

    @Test(dependsOnMethods = "openPage")
    public void checkCost() {
        Assert.assertEquals(PageWithSettings.priceOnCalculatorPage, GenerateMailPage.priceOnGenerateMailPage,
                "Price in sent mail doesn't match with price on the generate calculator page.");
    }
}

