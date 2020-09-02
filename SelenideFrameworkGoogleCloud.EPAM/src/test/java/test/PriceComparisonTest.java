package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CloudGoogleComPage;
import page.GenerateMailPage;
import page.PageWithSettingsOfCalculator;
import services.CalculatorCreator;
import settingscalc.Calculator;

public class PriceComparisonTest extends CommonConditions {
    @Test
    public void openPage() {
        Calculator testCalculator = CalculatorCreator.createCalculatorWithSomeProperty();
        PageWithSettingsOfCalculator cloudPage = new CloudGoogleComPage()
                .getToStartPageWithSearchingLine()
                .settingValueNumberOfInstances(testCalculator)
                .settingValueOperatingSystem(testCalculator)
                .settingValueMachineClass(testCalculator)
                .settingValueMachineType(testCalculator)
                .settingAddGPU(testCalculator)
                .settingValueLocalSSD(testCalculator)
                .settingValueDatacenterLocation(testCalculator)
                .settingValueCommittedUsage(testCalculator)
                .clickOnTheButtonAddToEstimate()
                .createNewTab();

        GenerateMailPage mailPage = new GenerateMailPage()
                .getToMailPage()
                .copyMail();
        cloudPage
                .clickOnButtonEmailEstimate()
                .insertGeneratingMailInFieldInputMail()
                .clickOnTheButtonSendEmail()
                .getPriceInCalculatorPage();
        mailPage
                .clickToOpenMail()
                .getPriceOnGenerateMailPage();

        Assert.assertEquals(PageWithSettingsOfCalculator.priceOnCalculatorPage, GenerateMailPage.priceOnGenerateMailPage,
                "Price in sent mail doesn't match with price on the generate calculator page.");
    }

}

