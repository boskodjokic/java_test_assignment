package com.alasdoo.developercourseassignment.e2e.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    private WebElement firstCourse;

    @FindBy(name = "classesBought")
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

    @FindBy(className = "MuiDataGrid-viewport")
    private WebElement accountNameInTable;

    @FindBy(css = "div.makeStyles-root-1 main.makeStyles-content-3 div.makeStyles-mainContent-4 div.MuiDataGrid-root.MuiDataGrid-root div.MuiDataGrid-mainGridContainer:nth-child(2) div.MuiDataGrid-window div.MuiDataGrid-dataContainer.data-container div.MuiDataGrid-viewport div.rendering-zone div.MuiDataGrid-row.Mui-even:nth-child(1) > div.MuiDataGrid-cell.MuiDataGrid-cellLeft:nth-child(2)")
    private WebElement nameInTable;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]")
    private WebElement courseDescription;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
    private WebElement coursesTable;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]")
    private WebElement emptyCoursesTable;


    //    Method for entering name
    public void enterName(String name) {
        nameField.sendKeys(name);
    }

    //    Method for clearing name
    public void clearName() {
        while (!nameField.getAttribute("value").equals("")) {
            nameField.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void clickOnNameField() {
        nameField.click();
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

//    Checking if the save button is displayed
    public boolean isSaveButtonDisplayed(){
        saveStudentButton.isDisplayed();
        return true;
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
        nameInTable.click();
    }

    //    Method for getting list of students in the table
    public void getListOfStudents(String name) {
        List<WebElement> listOfStudents = table.findElements(By.name(name));
    }

    //    Method for clicking newly added student account name in table
    public String getAccountNameFromTable() {
        String[] table = accountNameInTable.getText().split("\\r?\\n");
        return table[table.length-2];
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


//    Clicking on a random course from a course list
    public String clickOnRandomCourse() {
        List<WebElement> listOfCourses = allCourses.findElements(By.tagName("li"));
        Random random = new Random();
        int courseIndex = random.nextInt(10);
        Actions actions = new Actions(driver);
        String course = listOfCourses.get(courseIndex).getText();
//        Sometimes the test addCourse won't work until this below is executed. No idea how it is handling this, but it went OK 10/10 times when it printed the list in console.
//        for(int i =0 ; i< listOfCourses.size(); i++){
//            System.out.println(listOfCourses.get(i).getText());
//        }
        actions.moveToElement(listOfCourses.get(courseIndex)).click().perform();
        return course;
    }


    //    Entering classes bought
    public void enterClassesBought(String classesBought) {
        classesBoughtField.sendKeys(classesBought);
    }

    //    Clearing classes bought
    public void clearClassesBought() {
        while (!classesBoughtField.getAttribute("value").equals("")) {
            classesBoughtField.sendKeys(Keys.BACK_SPACE);
        }
    }

    //    Clicking on delete course button
    public void clickOnDeleteCourse() {
        deleteClassesButton.click();
    }

    //Getting last course from view table (we are taking second to last index, because with students, we have also classes in a string)
    public String getLastCourseFromView() {
        String chosenCourse = coursesTable.getText();
        String[] courseSplit = chosenCourse.split("\\r?\\n");
        return courseSplit[courseSplit.length - 2];
    }

    //    Getting classes bought text
    public String getCoursesBought() {
        String coursesBought = coursesTable.getText();
        String[] coursesBoughtSplit = coursesBought.split("\\r?\\n");

        return coursesBoughtSplit[coursesBoughtSplit.length - 1];
    }

    //    Getting text from courses table
    public String getCoursesTable() {
        return coursesTable.getText();
    }

//    Getting text from empty courses table
    public String getEmptyCoursesTableText() {
        return emptyCoursesTable.getText();
    }

//    Checking how many courses are in the table. It is divided by 2 as it takes course name and classes bought together from the viewport.
    public int numberOfCoursesInTable() {
        String[] check = getCoursesTable().split("\\r?\\n");
        return check.length/2;
    }

}
