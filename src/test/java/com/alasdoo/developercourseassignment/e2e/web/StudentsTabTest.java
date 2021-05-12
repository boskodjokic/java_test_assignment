package com.alasdoo.developercourseassignment.e2e.web;

import com.alasdoo.developercourseassignment.e2e.common.BrowserFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudentsTabTest {

    private MainMenu mainMenu;
    private StudentsTab studentsTab;

    WebDriver driver = BrowserFactory.getBrowser("browser");

    @BeforeEach
    void setup() {

        driver.get("http://localhost:3000");
        driver.manage().window().maximize();
        mainMenu = new MainMenu(driver);
        studentsTab = new StudentsTab(driver);
    }

    //    Test for creating new student and checking is the student in the table
    @Test
    void enterAllOfTheDataForStudent() throws InterruptedException {
        mainMenu.clickPlusButton();
        studentsTab.enterName("Bosko");
        studentsTab.enterSurname("Djokic");
        studentsTab.enterAccountName("bosko");
        studentsTab.enterEmail("bosko@gmail.com");
        studentsTab.enterPassword("password");
        studentsTab.enterBankCardNumber("1234");
        studentsTab.clickSaveStudentButton();
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        assertEquals("bosko", studentsTab.getAccountNameFromTable());
    }

    //    This test is failing because every field should be filled in when submitting the form. Password is left out.
    @Test
    void enterIncompleteDataForStudent() {
        mainMenu.clickPlusButton();
        studentsTab.enterName("Bosko");
        studentsTab.enterSurname("Myers");
        studentsTab.enterAccountName("bosko");
        studentsTab.enterEmail("bosko@gmail.com");
        studentsTab.enterBankCardNumber("1234");
        studentsTab.clickSaveStudentButton();
    }

    //    Testing update of the student
    @Test
    void updateStudent() throws InterruptedException {
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        studentsTab.clickOnStudentInTable();
        studentsTab.clearName();
        studentsTab.enterName("Kosta");
        studentsTab.clickSaveStudentButtonUpdate();

        assertEquals("Kosta", studentsTab.getNameFromTable());
    }

    //    Testing deletion of the student
    @Test
    void deleteStudent() throws InterruptedException {
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        studentsTab.clickOnStudentInTable();
        studentsTab.clickDeleteStudentButtonUpdate();

        assertNotEquals("Bosko", studentsTab.getNameFromTable());
    }

    //    Testing addition of new course for the student
    @Test
    void addCourse() throws InterruptedException {
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        studentsTab.clickOnStudentInTable();
        studentsTab.clickToggleCourses();
        studentsTab.clickAddNewCourse();
        studentsTab.clickOnCoursesDropdownList();
        String course =  studentsTab.clickOnRandomCourse();
        System.out.println(course);
        studentsTab.enterClassesBought("5");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(3000);
        studentsTab.clickSaveClassesButton();
        studentsTab.clickXButton();

        studentsTab.clickOnStudentInTable();
        studentsTab.clickToggleCourses();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertEquals(course, studentsTab.getLastCourseFromView());

    }

    //    Testing update of the students course
    @Test
    void updateCourse() throws InterruptedException {
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        studentsTab.clickOnStudentInTable();
        studentsTab.clickToggleCourses();
        studentsTab.clickOnFirstStudentsCourse();
        studentsTab.clearClassesBought();
        studentsTab.enterClassesBought("6");
        studentsTab.clickSaveClassesButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        assertEquals("6", studentsTab.getCoursesBought());
    }

    //    Testing deletion of the students course
    @Test
    void deleteCourse() throws InterruptedException {
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        studentsTab.clickOnStudentInTable();
        studentsTab.clickToggleCourses();
//        String courseName = studentsTab.getCourseDescription();
        studentsTab.clickOnFirstStudentsCourse();
        studentsTab.clickOnDeleteCourse();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        assertEquals("", studentsTab.getCoursesTable());
    }

    @AfterAll
    @DisplayName("Closing the driver after the tests")
    void close() {
        driver.close();
    }
}