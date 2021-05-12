package com.alasdoo.developercourseassignment.e2e.web;

import com.alasdoo.developercourseassignment.e2e.common.BrowserFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MainMenuTest {

    private MainMenu mainMenu;

    WebDriver driver = BrowserFactory.getBrowser("browser");

    @BeforeEach
    @DisplayName("Necessary set up before all the tests")
    void setup() {
        driver.get("http://localhost:3000");
        driver.manage().window().maximize();
        mainMenu = new MainMenu(driver);
    }

    @Test
    @DisplayName("Checking are all common buttons on main page working")
    void checkButtonsOnMainPage() throws InterruptedException {
        assertTrue(mainMenu.rightArrowEnabled());
        int clicks = mainMenu.getNumberOfClicks();
        for(int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        assertTrue(mainMenu.leftArrowEnabled());
        mainMenu.clickPlusButton();
        mainMenu.clickXButton();
    }

    @AfterAll
    @DisplayName("Closing the driver after the tests")
    void close() {
        driver.close();
    }
}