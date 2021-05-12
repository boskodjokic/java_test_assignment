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

        browserName = browserName.toLowerCase();
        String browser = System.getProperties().get(browserName).toString();

        switch (browser) {
            case "chrome":
                return getChromeInstance();
            case "edge":
                return getEdgeInstance();
            case "ie":
                return getIEInstance();
            default:
                return getFFInstance();

        }
    }

    private static FirefoxDriver getFFInstance() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        return driver;
    }

    private static ChromeDriver getChromeInstance() {
        WebDriverManager.chromedriver().setup();
       ChromeDriver driver = new ChromeDriver();
        return driver;
    }

    private static EdgeDriver getEdgeInstance() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        return driver;
    }

    private static InternetExplorerDriver getIEInstance() {
        WebDriverManager.iedriver().setup();
        InternetExplorerDriver driver = new InternetExplorerDriver();
        return driver;
    }

}
