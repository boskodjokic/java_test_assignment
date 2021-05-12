package com.alasdoo.developercourseassignment.e2e.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings {

    private WebDriver driver;

    public Settings(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
/*
Below are different locators. I used xpath, because there are no unique locators on the frontend.
 */

    @FindBy(xpath = "//p[contains(text(),'Inject demo')]")
    private WebElement settingsBodyText;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[2]/div[1]/div[1]/button[1]")
    private WebElement startButton;

    @FindBy(xpath = "//span[contains(text(),'Start')]")
    private WebElement startButtonLabel;


//    This method is used to get text from settings body page.
    public String getSettingsBodyText(){
        return settingsBodyText.getText();
    }

//    This method is used to get button text.
    public String getStartButtonText() {
        return startButtonLabel.getText();
    }

//    Checking if start button is enabled.
    public boolean startButtonEnabled(){
        return startButton.isEnabled();
    }
}
