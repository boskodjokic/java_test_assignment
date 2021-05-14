package com.alasdoo.developercourseassignment.e2e.web;

import com.alasdoo.developercourseassignment.e2e.common.BrowserFactory;
import com.alasdoo.developercourseassignment.e2e.common.TakeScreenshotAfterFailure;
import com.alasdoo.developercourseassignment.e2e.common.WebDriverUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(TakeScreenshotAfterFailure.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SettingsTest {


    private Settings settings;
    private Header header;
    private WebDriverUtils webDriverUtils;

//    Default browser is Firefox. If nothing is given it the path, tests would run in Firefox.
//    For any other browser type in the path in terminal "-Dbrowser=(name of the preferred browser)"
         WebDriver driver;

    //    Necessary set up before all the tests"
    @BeforeEach
    void setup() {
        driver =  BrowserFactory.getBrowser(System.getProperty("browser"));
        driver.get("http://localhost:3000");
        driver.manage().window().maximize();
        header = new Header(driver);
        settings = new Settings(driver);
        MainMenu mainMenu = new MainMenu(driver);
        WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
        mainMenu.clickSettings();
    }

    //      Checking header title
    @Test
    void checkHeaderTitle() {
        assertEquals("Settings", header.getSettingsHeaderTitle());
         }

    //    Checking is settings body correctly displayed
    @Test
    void checkSettingsBodyText() {
        assertEquals("Inject demo content in the backend. Run this command only once!", settings.getSettingsBodyText());
    }

    //    Checking is start button enabled and is the START label present
    @Test
    void checkStartButton() {
        assertTrue(settings.startButtonEnabled());
        assertEquals("START", settings.getStartButtonText());
    }

    //        Closing the driver after the tests
    @AfterEach
    void close() {
        if (driver != null) {
            driver.close();
        }
    }

}

