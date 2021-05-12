package com.alasdoo.developercourseassignment.e2e.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursesTab {

    private final WebDriver driver;

    public CoursesTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "developerCourseName")
    private WebElement courseNameField;

    @FindBy(name = "costPerClass")
    private WebElement costPerClassField;

    @FindBy(name = "classesPerWeek")
    private WebElement classesPerWeekField;

    @FindBy(css = "button[data-test-id='save']")
    private WebElement coursesSaveButton;

    @FindBy(css = "button[data-test-id='delete']")
    private WebElement coursesDeleteButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[2]/div[1]/button[1]/span[1]/*[1]")
    private WebElement coursesXButton;

    //    Method for entering course name
    public void enterCourseName(String courseName) {
        courseNameField.sendKeys(courseName);
    }

    //    Method for entering cost Per Class
    public void enterCostPerClass(String costPerClass) {
        costPerClassField.sendKeys(costPerClass);
    }

    //    Method for entering classes per week
    public void enterClassesPerWeek(String classesPerWeek) {
        classesPerWeekField.sendKeys(classesPerWeek);
    }

    //    Method for clicking save button
    public void clickSaveButton(){
        coursesSaveButton.click();
    }

    //    Method for clicking delete button
    public void clickDeleteButton(){
        coursesDeleteButton.click();
    }

    //    Method for clicking x button
    public void clickXButton(){
        coursesXButton.click();
    }
    //    Method for deleting course name
    public void clearCourseName() {
        courseNameField.clear();
    }

    //    Method for deleting cost per class
    public void clearCostPerClass() {
        costPerClassField.clear();
    }

    //    Method for deleting classes per week
    public void clearClassesPerWeek() {
        classesPerWeekField.clear();
    }
}
