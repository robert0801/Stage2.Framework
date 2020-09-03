package util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebelementUnils {
    static int countOfSwitchingInFrame = 0;

    public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static void click(WebDriver driver, WebElement element) {
        waitForVisibility(driver, element);
        element.sendKeys(Keys.ENTER);
    }

    public static void clickByCheckOption(WebDriver driver, WebElement listWithOptions, String listOfOption, String option) {
        click(driver, listWithOptions);
        WebElement element = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(listOfOption, option))));
        element.sendKeys(Keys.ENTER);
    }

    public static void getToSomeFrame(WebDriver driver, String nameFrame) {
        try {
            if (countOfSwitchingInFrame < 10) {
                System.out.println(countOfSwitchingInFrame);
                driver.switchTo().defaultContent();
                driver.switchTo().frame(0);
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameFrame));
            }
            else {
                throw new Exception();
            }
        } catch (Exception e) {
            countOfSwitchingInFrame++;
            getToSomeFrame(driver, nameFrame);
        }
    }

}
