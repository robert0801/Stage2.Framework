package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CloudGoogleComPage;
import page.PageWithSettingsOfCalculator;

public class OpenRightPageTest extends CommonConditions {
    @Test
    public void getToCloudGoogle() {
        PageWithSettingsOfCalculator page = new CloudGoogleComPage(driver)
                .getToStartPageWithSearchingLine();
        Assert.assertEquals(driver.getCurrentUrl(), "https://cloud.google.com/products/calculator",
                "Was open correct page for generate calculator.");
    }
}
