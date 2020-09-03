package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static util.WebelementUnils.click;

public class CloudGoogleComPage extends AbstractForCloudGoogle {

    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator']")
    private WebElement linkCloudGooglePage;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchLine;

    public CloudGoogleComPage(WebDriver driver) {
        super(driver);
    }

    public PageWithSettingsOfCalculator getToStartPageWithSearchingLine() {
        driver.get("https://cloud.google.com/");
        searchLine.sendKeys("Google Cloud Platform Pricing Calculator");
        searchLine.sendKeys(Keys.ENTER);
        click(driver, linkCloudGooglePage);
        return new PageWithSettingsOfCalculator(driver);
    }
}
