package com.alasdoo.developercourseassignment.e2e.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class TeachersTab {

    private final WebDriver driver;

    public TeachersTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "teacherName")
    private WebElement teacherNameField;

    @FindBy(name = "teacherSurname")
    private WebElement teacherSurnameField;

    @FindBy(name = "teacherEmail")
    private WebElement teacherEmailField;

    @FindBy(css = "button[data-test-id='save']")
    private WebElement teacherSaveButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[3]/div[1]/form[1]/div[2]/button[1]")
    private WebElement teacherSaveCourseButton;

    @FindBy(css = "button[data-test-id='delete']")
    private WebElement teacherDeleteButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[2]/div[1]/button[1]/span[1]/*[1]")
    private WebElement teacherXButton;

    @FindBy(xpath = "//span[contains(text(),'Toggle courses')]")
    private WebElement teacherToggleCoursesButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[1]/button[1]")
    private WebElement assignNewCourseButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[1]/div[1]")
    private WebElement courseDropdown;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[1]/form[1]/div[2]/button[1]")
    private WebElement saveCourseButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[1]/form[1]/div[2]/button[2]")
    private WebElement cancelCourseButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[1]/form[1]/div[2]/button[1]")
    private WebElement deleteCourseButton;

    @FindBy(xpath = "//body/div[@id='menu-developerCourseId']/div[3]/ul[1]")
    private WebElement allCourses;

    @FindBy(css = "div.makeStyles-root-1 main.makeStyles-content-3 div.makeStyles-mainContent-4 div.MuiDataGrid-root.MuiDataGrid-root div.MuiDataGrid-mainGridContainer:nth-child(2) div.MuiDataGrid-window div.MuiDataGrid-dataContainer.data-container div.MuiDataGrid-viewport div.rendering-zone div.MuiDataGrid-row.Mui-even > div.MuiDataGrid-cell.MuiDataGrid-cellLeft:nth-child(2)")
    private WebElement nameInTable;

    @FindBy(css = "button[data-test-id='add-courses']")
    private WebElement addCourseButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]")
    private WebElement coursesTable;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]")
    private WebElement emptyCoursesTable;

//    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]")
//    private WebElement emptyCoursesTable;

    //    Method for entering teachers name
    public void enterName(String name) {
        teacherNameField.sendKeys(name);
    }

    //    Method for entering teachers surname
    public void enterSurname(String surname) {
        teacherSurnameField.sendKeys(surname);
    }

    //    Method for entering teachers surname
    public void enterEmail(String email) {
        teacherEmailField.sendKeys(email);
    }

    //    Method for clicking save button
    public void clickSaveButton(){
        teacherSaveButton.click();
    }

    //    Method for clicking save courses button
    public void clickSaveCourseButton(){
        teacherSaveCourseButton.click();
    }

    //    Method for clicking delete button
    public void clickDeleteButton(){
        teacherDeleteButton.click();
    }

    //    Method for clicking x button
    public void clickXButton(){
        teacherXButton.click();
    }
    //    Method for deleting teachers name
    public void clearName() {
        teacherNameField.clear();
    }

    //    Method for deleting teachers surname
    public void clearSurname() {
        teacherSurnameField.clear();
    }

    //    Method for deleting teachers surname
    public void clearEmail() {
        teacherEmailField.clear();
    }

    //    Method for clicking x button
    public void clickToggleCoursesButton() {
        teacherToggleCoursesButton.click();
    }
    //    Method for clicking course in dropdown course list
    public void clickOnCoursesDropdownList() {
        courseDropdown.click();
    }

    //    Method for clicking save course button
    public void clickOnSaveCourseButton() {
        saveCourseButton.click();
    }

    //    Method for clicking delete course button
    public void clickOnDeleteCourseButton() {
        deleteCourseButton.click();
    }

    //    Method for clicking cancel course button
    public void clickOnCancelCourseButton() {
        cancelCourseButton.click();
    }

    //    Method for clicking add course button
    public void clickOnAddCourseButton() {
        addCourseButton.click();
    }

//    Method for asserting is the button displayed
    public boolean isSaveButtonDisplayed() {
        teacherSaveButton.isDisplayed();
        return true;
    }

    //    Method for getting the text from the table
    public String getNameFromTable() {
        return nameInTable.getText();
    }

    //    Method for clicking newly added teacher account name in table
    public void clickNameFromTable() {
        nameInTable.click();
    }

    //    Clicking on a random course from a course list
    public String clickOnRandomCourse() {
        List<WebElement> listOfCourses = allCourses.findElements(By.tagName("li"));
        Random random = new Random();
        int courseIndex = random.nextInt(listOfCourses.size());
        Actions actions = new Actions(driver);
        String chosenCourse = listOfCourses.get(courseIndex).getText();
        actions.moveToElement(listOfCourses.get(courseIndex)).click().perform();
        return chosenCourse;
    }

    //Getting last course from view table
    public String getLastCourseFromView() {
        String chosenCourse = coursesTable.getText();
        String[] courseSplit = chosenCourse.split("\\r?\\n");
        return courseSplit[courseSplit.length - 1];
    }

    //    Getting text from courses table
    public String getCoursesTable() {
        return coursesTable.getText();
    }

//     Checking how many courses are in the table. It is divided by 2 as it takes course name and classes bought together from the viewport.
    public int numberOfCoursesInTable() {
        String[] check = getCoursesTable().split("\\r?\\n");
        return check.length;
    }

    //    Getting text from empty courses table
    public String getEmptyCoursesTableText() {
        return emptyCoursesTable.getText();
    }

}
