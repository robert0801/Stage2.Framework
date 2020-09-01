package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleComPage extends AbstractForCloudGoogle {

    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator']")
    private WebElement linkCloudGooglePage;


    public CloudGoogleComPage(WebDriver driver) {
        super(driver);
    }

    public PageWithSettings getToStartPage() {
        driver.get("https://cloud.google.com/");
        WebElement searchLine = driver.findElement(By.xpath("//input[@type='text']"));
        searchLine.sendKeys("Google Cloud Platform Pricing Calculator");
        searchLine.sendKeys(Keys.ENTER);
        click(linkCloudGooglePage);
        return new PageWithSettings(driver);
    }
}
