package com.alasdoo.developercourseassignment.e2e.web;

import com.alasdoo.developercourseassignment.e2e.common.BrowserFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeachersTabTest {

    private MainMenu mainMenu;
    private TeachersTab teachersTab;

    WebDriver driver = BrowserFactory.getBrowser(System.getProperty("browser"));

    @BeforeEach
    void setup() {

        driver.get("http://localhost:3000/teacher");
        driver.manage().window().maximize();
        mainMenu = new MainMenu(driver);
        teachersTab = new TeachersTab(driver);
    }

    //    We are asserting is the save button displayed, because it should not be, when the teacher is successfully saved. Email is left out.
    @Test
    @Order(1)
    void saveTeacherWithIncompleteData() {
        mainMenu.clickPlusButton();
        teachersTab.enterName("Bosko");
        teachersTab.enterSurname("Myers");
        teachersTab.clickSaveButton();
        assertTrue(teachersTab.isSaveButtonDisplayed());
    }

    //    Test for creating new teacher and checking is the teacher in the table
    @Test
    @Order(2)
    void teacherSuccessfullySaved() throws InterruptedException {
        mainMenu.clickPlusButton();
        teachersTab.enterName("Bosko");
        teachersTab.enterSurname("Djokic");
        teachersTab.enterEmail("bosko@gmail.com");
        teachersTab.clickSaveButton();
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        assertEquals("Bosko", teachersTab.getNameFromTable());
    }

    //    Testing update of the teacher
    @Test
    @Order(3)
    void updateTeacher() throws InterruptedException {
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        teachersTab.clickNameFromTable();
        teachersTab.clearName();
        teachersTab.enterName("Kosta");
        teachersTab.clickSaveButton();

        assertEquals("Kosta", teachersTab.getNameFromTable());
    }

    //    Testing deletion of the teacher
    @Test
    @Order(6)
    void deleteTeacher() throws InterruptedException {
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        teachersTab.clickNameFromTable();
        String name = teachersTab.getNameFromTable();
        teachersTab.clickDeleteButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement nameFromTable = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]"));
        assertNotEquals(name, nameFromTable.getText());

    }

    //    Testing addition of new course for the teacher
    @Test
    @Order(4)
    void addCourse() throws InterruptedException {
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        teachersTab.clickNameFromTable();
        teachersTab.clickToggleCoursesButton();
        teachersTab.clickOnAddCourseButton();
        teachersTab.clickOnCoursesDropdownList();
        String course =  teachersTab.clickOnRandomCourse();
        WebDriverWait wait=new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[1]/form[1]/div[2]/button[1]")));
        Thread.sleep(3000);
        teachersTab.clickSaveCourseButton();
        teachersTab.clickXButton();

        teachersTab.clickNameFromTable();
        teachersTab.clickToggleCoursesButton();

        String courseFromView = teachersTab.getLastCourseFromView();
        assertEquals(course, courseFromView);

    }

    //    Testing deletion of the teachers course
    @Test
    @Order(5)
    void deleteCourse() throws InterruptedException {
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        teachersTab.clickNameFromTable();
        teachersTab.clickToggleCoursesButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String courseFromView = teachersTab.getLastCourseFromView();
        int numberOfCourses = teachersTab.numberOfCoursesInTable();
        WebElement course = driver.findElement(By.xpath("//div[contains(text(),'" + courseFromView + "')]"));
        course.click();
        teachersTab.clickOnDeleteCourseButton();

        if(numberOfCourses>1) {
            assertNotEquals(courseFromView, teachersTab.getLastCourseFromView());
        }
        else {
            assertNotEquals(courseFromView, teachersTab.getEmptyCoursesTableText());
        }

    }
    @AfterAll
    void close() {
        driver.close();
    }
}