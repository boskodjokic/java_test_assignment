package com.alasdoo.developercourseassignment.e2e.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/*
This class is used to return different WebDrivers, so the user can choose different WebDriver for testing purposes.
 */

public class BrowserFactory {

    public static WebDriver getBrowser(String browserName) {

        if (browserName == null) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
            browserName = browserName.toLowerCase();

            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    return new EdgeDriver();
                case "ie":
                    WebDriverManager.iedriver().setup();
                    return new InternetExplorerDriver();
                default:
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();

            }

    }

}
