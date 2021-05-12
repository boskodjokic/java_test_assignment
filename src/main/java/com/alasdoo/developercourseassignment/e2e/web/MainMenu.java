package com.alasdoo.developercourseassignment.e2e.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenu {

    private final WebDriver driver;

    public MainMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*
Below are different locators. I used xpath, because there are no unique locators on the frontend.
 */

    @FindBy(xpath = "//span[contains(text(),'Students')]")
    private WebElement studentsButton;

    @FindBy(xpath = "//span[contains(text(),'Teachers')]")
    private WebElement teachersButton;

    @FindBy(xpath = "//span[contains(text(),'Courses')]")
    private WebElement CoursesButton;

    @FindBy(xpath = "//span[contains(text(),'Settings')]")
    private WebElement settingsButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/button[1]")
    private WebElement plusButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/button[2]/span[1]/*[1]")
    private WebElement rightArrowButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]/*[1]")
    private WebElement leftArrowButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/p[1]")
    private WebElement paginationCaption;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[2]/div[1]/button[1]/span[1]/*[1]")
    private WebElement xButton;

    //    Click settings button from right side menu
    public void clickSettings() {
        settingsButton.click();
    }

    //    Click plus button
    public void clickPlusButton() {
        plusButton.click();
    }

    //    Click right arrow button
    public void clickRightArrowButton() {
        rightArrowButton.click();
    }

    //  Click left arrow button
    public void clickLeftArrowButton() {
        leftArrowButton.click();
    }

    // Checking is right arrow enabled
    public boolean rightArrowEnabled() {
        return rightArrowButton.isEnabled();
    }

    // Checking is left arrow enabled
    public boolean leftArrowEnabled() {
        return leftArrowButton.isEnabled();
    }

    //    Clicking button to close the drawer
    public void clickXButton() {
        xButton.click();
    }

    // Method for calculating how many times can the right and left arrow be clicked
    public int getNumberOfClicks() throws InterruptedException {
        String number = paginationCaption.getText();
        String[] splitNumbers = number.split(" ");
        return Math.floorDiv((Integer.parseInt(splitNumbers[splitNumbers.length - 1]) - 1), 10);
    }
}
