package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CloudGoogleComPage;
import page.PageWithSettings;

public class OpenRightPageTest extends CommonConditions{
    @Test
    public void getToCloudGoogle(){
        PageWithSettings page = new CloudGoogleComPage(driver)
                .getToStartPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://cloud.google.com/products/calculator",
                "Open page with calculator");
    }
}
