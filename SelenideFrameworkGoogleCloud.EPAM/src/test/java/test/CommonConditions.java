package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import util.TestListener;
import static com.codeborne.selenide.Configuration.baseUrl;


@Listeners({TestListener.class})
public class CommonConditions {

    @BeforeTest()
    public static void setUp()
    {
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = false;
        baseUrl = "https://cloud.google.com";
    }

    @AfterClass
    public static void clearUp()
    {
        Selenide.closeWindow();
    }

}
