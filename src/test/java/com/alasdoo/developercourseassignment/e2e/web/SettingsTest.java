package com.alasdoo.developercourseassignment.e2e.web;

import com.alasdoo.developercourseassignment.e2e.common.BrowserFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SettingsTest {

    private Settings settings;
    private MainMenu mainMenu;
    private Header header;

    WebDriver driver = BrowserFactory.getBrowser("firefox");

//    Necessary set up before all the tests"
    @BeforeEach
    void setup() {
        driver.get("http://localhost:3000");
        driver.manage().window().maximize();
        header = new Header(driver);
        settings = new Settings(driver);
        mainMenu = new MainMenu(driver);
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

    //    Closing the driver after the tests
    @AfterAll
    void close() {
        driver.close();
    }
}