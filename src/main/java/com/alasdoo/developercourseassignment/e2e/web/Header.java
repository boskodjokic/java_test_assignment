package com.alasdoo.developercourseassignment.e2e.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

//    Header locator
    @FindBy(xpath = "//header/div[1]/h6[1]")
    private WebElement settingsHeaderTitle;

    private WebDriver driver;

    public Header(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    Method for getting header title text
    public String getSettingsHeaderTitle(){
        return settingsHeaderTitle.getText();
    }
}
