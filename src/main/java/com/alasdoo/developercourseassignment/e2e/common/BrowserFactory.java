package com.alasdoo.developercourseassignment.e2e.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

    public static WebDriver getBrowser(String browserName) {
        browserName = browserName.toLowerCase();

        switch (browserName) {
            case "chrome":
                return getChromeInstance();
            case "edge":
                return getEdgeInstance();
            case "ie":
                return getIEInstance();
            default:
                return getFFInstance();

        }
//        if(browserName.equals("chrome"))
//            return getChromeInstance();
//
//        if(browserName.equals("edge"))
//            return getEdgeInstance();
//
//        if(browserName.equals("ie"))
//            return getIEInstance();
//        else
//            return getFFInstance();
    }

    private static FirefoxDriver getFFInstance() {
         WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver =new FirefoxDriver();
        return driver;
    }

    private static ChromeDriver getChromeInstance() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver =new ChromeDriver();
        return driver;
    }

    private static EdgeDriver getEdgeInstance() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver =new EdgeDriver();
        return driver;
    }

    private static InternetExplorerDriver getIEInstance() {
        WebDriverManager.iedriver().setup();
        InternetExplorerDriver driver =new InternetExplorerDriver();
        return driver;
    }

}
