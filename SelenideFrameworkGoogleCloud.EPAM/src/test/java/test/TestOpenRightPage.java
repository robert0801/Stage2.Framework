package test;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CloudGoogleComPage;
import page.PageWithSettingsOfCalculator;

public class TestOpenRightPage extends CommonConditions{
    @Test
    public void getToCloudGoogle(){
        PageWithSettingsOfCalculator page = new CloudGoogleComPage()
                .getToStartPageWithSearchingLine();
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://cloud.google.com/products/calculator",
                "Was open incorrect page for generate calculator.");

    }
}
