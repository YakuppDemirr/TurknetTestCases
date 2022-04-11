package com.turknet.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class DriverManager {

    public static WebDriver driver = null;

    public static void setBrowser(String browserType){

        if(driver == null){
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
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
