package test;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CloudGoogleComPage;
import page.PageWithSettings;

public class TestOpenRightPage extends CommonConditions{
    @Test
    public void getToCloudGoogle(){
        PageWithSettings page = new CloudGoogleComPage()
                .getToStartPage();
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://cloud.google.com/products/calculator",
                "Open no correct page");

    }
}
