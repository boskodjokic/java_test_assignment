package com.alasdoo.developercourseassignment.e2e.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class StudentsTab {

    private final WebDriver driver;

    public StudentsTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*
Below are different locators. I used xpath for several of them because there are no unique locators on the frontend.
 */

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[2]/form[1]/div[7]/button[1]")
    private WebElement saveStudentButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[2]/form[1]/div[7]/button[2]")
    private WebElement deleteStudentButton;

    @FindBy(css = "button[data-test-id='courses']")
    private WebElement toggleCourses;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[2]/form[1]/div[8]/button[1]")
    private WebElement saveStudentButtonWhenUpdating;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[2]/form[1]/div[8]/button[2]")
    private WebElement deleteStudentButtonWhenUpdating;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[1]/button[1]")
    private WebElement addNewCourseButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[1]/div[1]")
    private WebElement courseDropdown;

    @FindBy(xpath = "//body/div[@id='menu-developerCourseId']/div[3]/ul[1]")
    private WebElement allCourses;
//
//    @FindBy(xpath = "//body/div[@id='menu-developerCourseId']/div[3]/ul[1]/li[1]")
//    private WebElement firstCourse;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[3]/div[1]/form[1]/div[2]/div[1]/input[1]")
    private WebElement classesBoughtField;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[1]/form[1]/div[3]/button[1]")
    private WebElement saveClassesButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[1]/form[1]/div[3]/button[2]")
    private WebElement cancelClassesButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[1]/form[1]/div[3]/button[3]")
    private WebElement deleteClassesButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[2]/div[1]/button[1]/span[1]/*[1]")
    private WebElement xButton;

    @FindBy(name = "name")
    private WebElement nameField;

    @FindBy(name = "surname")
    private WebElement surnameField;

    @FindBy(name = "accountName")
    private WebElement accountField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "bankCardNumber")
    private WebElement bankCardNumberField;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]")
    private WebElement table;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]")
    private WebElement accountNameInTable;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]")
    private WebElement nameInTable;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]")
    private WebElement courseDescription;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]")
    private WebElement courseBought;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
//MuiDataGrid-cell MuiDataGrid-cellLeft
//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]
    private WebElement coursesTable;


    //    Method for entering name
    public void enterName(String name) {
        nameField.sendKeys(name);
    }

    //    Method for clearing name
    public void clearName() {
        nameField.clear();
    }

    //    Method for entering surname
    public void enterSurname(String surname) {
        surnameField.sendKeys(surname);
    }

    //    Method for entering account name
    public void enterAccountName(String accountName) {
        accountField.sendKeys(accountName);
    }

    //    Method for entering email
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    //    Method for entering password
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    //    Method for entering bank card number
    public void enterBankCardNumber(String bankCardNumber) {
        bankCardNumberField.sendKeys(bankCardNumber);
    }

    //    Method for clicking save student button
    public void clickSaveStudentButton() {
        saveStudentButton.click();
    }

    //    Method for clicking delete student button
    public void clickDeleteStudentButton() {
        deleteStudentButton.click();
    }

    //    Method for clicking save student button when updating (different than the first one because of changing xpath)
    public void clickSaveStudentButtonUpdate() {
        saveStudentButtonWhenUpdating.click();
    }

    //    Method for clicking delete student button when updating (different than the first one because of changing xpath)
    public void clickDeleteStudentButtonUpdate() {
        deleteStudentButtonWhenUpdating.click();
    }

    //    Method for clicking x button
    public void clickXButton() {
        xButton.click();
    }

    //    Method for clicking toggle courses button
    public void clickToggleCourses() {
        toggleCourses.click();
    }

    //    Method for clicking save courses button
    public void clickSaveClassesButton() {
        saveClassesButton.click();
    }

    //    Method for clicking cancel courses button
    public void clickCancelClassesButton() {
        cancelClassesButton.click();
    }

    //    Method for clicking newly added student in table
    public void clickOnStudentInTable() {
        accountNameInTable.click();
    }

    //    Method for getting list of students in the table
    public void getListOfStudents(String name) {
        List<WebElement> listOfStudents = table.findElements(By.name(name));
    }

    //    Method for clicking newly added student account name in table
    public String getAccountNameFromTable() {
        return accountNameInTable.getText();
    }

    //    Method for clicking newly added student name in table
    public String getNameFromTable() {
        return nameInTable.getText();
    }

    //    Method for clicking add new course
    public void clickAddNewCourse() {
        addNewCourseButton.click();
    }

    //    Method for clicking course in dropdown course list
    public void clickOnCoursesDropdownList() {
        courseDropdown.click();
    }

    //    Method for getting list of courses
    public void getListOfCoursesDropdown() {
        List<WebElement> listOfCoursesDropdown = allCourses.findElements(By.className("MuiTouchRipple-root"));
    }

//    Clicking on a random course from a course list
    public String clickOnRandomCourse() {
        List<WebElement> listOfCourses = allCourses.findElements(By.className("MuiTouchRipple-root"));
        Random random = new Random(20);
        int courseIndex = random.nextInt(20);
        Actions actions = new Actions(driver);
        String chosenCourse = listOfCourses.get(courseIndex).getText();
        System.out.println(chosenCourse);
        actions.moveToElement(listOfCourses.get(courseIndex)).click().perform();
        return chosenCourse;
    }

//    //  Clicking on the first course in the dropdown
//    public void clickOnFirstCourse() {
//        firstCourse.click();
//    }

    //    Entering classes bought
    public void enterClassesBought(String classesBought) {
        classesBoughtField.sendKeys(classesBought);
    }

    //    Clearing classes bought
    public void clearClassesBought() {
        classesBoughtField.clear();
    }

    //    Clicking on delete course button
    public void clickOnDeleteCourse() {
        deleteClassesButton.click();
    }

//    //    Getting course description
//    public String getCourseDescription() {
//        return courseDescription.getText();
//    }

    //    Method for getting list of courses
    public void getListOfCoursesView() {
        List<WebElement> listOfCoursesView = coursesTable.findElements(By.className("MuiDataGrid-viewport"));
    }

    public String getLastCourseFromView() {
        List<WebElement> listOfCoursesView = coursesTable.findElements(By.xpath("//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]"));
        System.out.println(listOfCoursesView.size());
        int lastIndex = listOfCoursesView.size()-1;
        Actions actions = new Actions(driver);
        String chosenCourse = listOfCoursesView.get(lastIndex).getText();
        actions.moveToElement(listOfCoursesView.get(lastIndex)).click().perform();
        return chosenCourse;
    }

    //    Clicking on first student course in courses table
    public void clickOnFirstStudentsCourse() {
        courseDescription.click();
    }

    //    Getting classes bought text
    public String getCoursesBought() {
        return courseBought.getText();
    }

    //    Getting text from courses table
    public String getCoursesTable() {
        return coursesTable.getText();
    }

}
