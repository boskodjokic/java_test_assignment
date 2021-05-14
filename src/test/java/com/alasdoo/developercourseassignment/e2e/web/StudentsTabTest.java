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
class StudentsTabTest {

    private MainMenu mainMenu;
    private StudentsTab studentsTab;

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = BrowserFactory.getBrowser(System.getProperty("browser"));
        driver.get("http://localhost:3000/student");
        driver.manage().window().maximize();
        mainMenu = new MainMenu(driver);
        studentsTab = new StudentsTab(driver);
    }

    //    Test for creating new student and checking is the student in the table
    @Test
    @Order(2)
    void studentSuccessfullySaved() throws InterruptedException {
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

    //    We are asserting is the save button displayed, because it should not be, when the student is successfully saved. Password is left out.
    @Test
    @Order(1)
    void saveStudentWithIncompleteData() {
        mainMenu.clickPlusButton();
        studentsTab.enterName("Bosko");
        studentsTab.enterSurname("Myers");
        studentsTab.enterAccountName("bosko");
        studentsTab.enterEmail("bosko@gmail.com");
        studentsTab.enterBankCardNumber("1234");
        studentsTab.clickSaveStudentButton();

        assertTrue(studentsTab.isSaveButtonDisplayed());
    }

    //    Testing update of the student
    @Test
    @Order(3)
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
    @Order(7)
    void deleteStudent() throws InterruptedException {
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        studentsTab.clickOnStudentInTable();
        String name = studentsTab.getNameFromTable();
        studentsTab.clickDeleteStudentButtonUpdate();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement nameFromTable = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]"));
        assertNotEquals(name, nameFromTable.getText());

    }

    //    Testing addition of new course for the student
    @Test
    @Order(4)
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
        studentsTab.enterClassesBought("5");
        Thread.sleep(2000);
        WebDriverWait wait=new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[1]/form[1]/div[3]/button[1]")));
        studentsTab.clickSaveClassesButton();
        studentsTab.clickXButton();

        studentsTab.clickOnStudentInTable();
        studentsTab.clickToggleCourses();

        String courseFromView = studentsTab.getLastCourseFromView();
        assertEquals(course, courseFromView);

    }

    //    Testing update of the students course
    @Test
    @Order(5)
    void updateCourse() throws InterruptedException {
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        studentsTab.clickOnStudentInTable();
        studentsTab.clickToggleCourses();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String courseFromView = studentsTab.getLastCourseFromView();
        WebElement course = driver.findElement(By.xpath("//div[contains(text(),'" + courseFromView + "')]"));
        course.click();
        studentsTab.clearClassesBought();
        studentsTab.enterClassesBought("6");
        studentsTab.clickSaveClassesButton();

        assertEquals("6", studentsTab.getCoursesBought());
    }

    //    Testing deletion of the students course
    @Test
    @Order(6)
    void deleteCourse() throws InterruptedException {
        int clicks = mainMenu.getNumberOfClicks();
        for (int i = 0; i <= clicks - 1; i++) {
            mainMenu.clickRightArrowButton();
        }
        studentsTab.clickOnStudentInTable();
        studentsTab.clickToggleCourses();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String courseFromView = studentsTab.getLastCourseFromView().substring(0, studentsTab.getLastCourseFromView().length() - 2);
        int numberOfCourses = studentsTab.numberOfCoursesInTable();
        WebElement course = driver.findElement(By.xpath("//div[contains(text(),'" + courseFromView + "')]"));
        course.click();
        studentsTab.clickOnDeleteCourse();

        if(numberOfCourses>1) {
            assertNotEquals(courseFromView, studentsTab.getLastCourseFromView());
        }
        else {
            assertNotEquals(courseFromView, studentsTab.getEmptyCoursesTableText());
        }
    }

    //        Closing the driver after the tests
    @AfterEach
    void close() {
        if (driver != null) {
            driver.close();
        }
    }
}