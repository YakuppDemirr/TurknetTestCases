package com.turknet.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {

    public static WebDriver driver = null;
    protected static ThreadLocal<RemoteWebDriver> driverDocker = new ThreadLocal<>();
    public static String remote_url = "http://localhost:4444/wd/hub";

    public static void setBrowser(String browserType) throws MalformedURLException
    {

        if(driver == null){
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driverDocker.set(new RemoteWebDriver(new URL(remote_url), chromeOptions));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driverDocker.set(new RemoteWebDriver(new URL(remote_url), firefoxOptions));
                    break;
                default:
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    public static void quitDriver(){

        if (driver != null){

            driver.close(); //Driverin çalıştığı sayfayı kapatır
            driver.quit(); //Tüm sayfaları kapatır.
            driver = null;
        }
    }
}
