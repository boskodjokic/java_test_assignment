package com.alasdoo.developercourseassignment.e2e.web;

import com.alasdoo.developercourseassignment.e2e.common.BrowserFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CoursesTabTest {

    private MainMenu mainMenu;
    private CoursesTab coursesTab;

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = BrowserFactory.getBrowser(System.getProperty("browser"));
        driver.get("http://localhost:3000/course");
        driver.manage().window().maximize();
        mainMenu = new MainMenu(driver);
        coursesTab = new CoursesTab(driver);
    }

    //    We are asserting is the save button displayed, because it should not be, when the course is successfully saved. Cost per class is left out.
    @Test
    @Order(1)
    void saveCourseWithIncompleteData() {
        mainMenu.clickPlusButton();
        coursesTab.enterCourseName("New Course");
        coursesTab.enterCostPerClass("50");
        assertTrue(coursesTab.isSaveButtonDisplayed());
    }

    //    Test for creating new course and checking is the course in the table
    @Test
    @Order(2)
    void courseSuccessfullySaved() throws InterruptedException {
        mainMenu.clickPlusButton();
        coursesTab.enterCourseName("New Course");
        coursesTab.enterCostPerClass("50");
        coursesTab.enterClassesPerWeek("5");
        coursesTab.clickSaveButton();
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        assertEquals("New Course", coursesTab.getNameFromTable());
    }

    //    Testing update of the course
    @Test
    @Order(3)
    void updateCourse() throws InterruptedException {
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        coursesTab.clickNameFromTable();
        coursesTab.clearName();
        coursesTab.enterCourseName("Newer Course");
        coursesTab.clickSaveButton();

        assertEquals("Newer Course", coursesTab.getNameFromTable());
    }

    //    Testing deletion of the course
    @Test
    @Order(6)
    void deleteCourse() throws InterruptedException {
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        coursesTab.clickNameFromTable();
        String name = coursesTab.getNameFromTable();
        coursesTab.clickDeleteButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement nameFromTable = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]"));
        assertNotEquals(name, nameFromTable.getText());

    }

    //        Closing the driver after the tests
    @AfterEach
    void close() {
        if (driver != null) {
            driver.close();
        }
    }
}