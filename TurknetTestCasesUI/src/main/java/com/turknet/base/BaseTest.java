package com.turknet.base;

import com.turknet.core.DriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BaseTest extends DriverManager {

    public static Logger log = Logger.getLogger("TurknetTestCases-UI");

    @Parameters("browser")
    @BeforeTest
    public void startDriver(@Optional("browser") String browserName){

        //chrome, firefox, edge
        //String browserName = "chrome";
        try {
            setBrowser(browserName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void closeDriver(){

        quitDriver();
    }
}
