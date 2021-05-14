package com.alasdoo.developercourseassignment.e2e.web;

import com.alasdoo.developercourseassignment.e2e.common.BrowserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MainMenuTest {

    private MainMenu mainMenu;

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = BrowserFactory.getBrowser(System.getProperty("browser"));
        driver.get("http://localhost:3000");
        driver.manage().window().maximize();
        mainMenu = new MainMenu(driver);
    }

    //    Checking are all common buttons on main page working
    @Test
    void checkButtonsOnMainPage() throws InterruptedException {
        assertTrue(mainMenu.rightArrowEnabled());
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        assertTrue(mainMenu.leftArrowEnabled());
        mainMenu.clickPlusButton();
        mainMenu.clickXButton();
    }

    //        Closing the driver after the tests
    @AfterEach
    void close() {
        if (driver != null) {
            driver.close();
        }
    }
}