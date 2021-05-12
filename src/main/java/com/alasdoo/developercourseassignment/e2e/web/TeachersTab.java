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
    public void clickOnDCancelCourseButton() {
        cancelCourseButton.click();
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

}
