package com.turknet.base;

import com.turknet.core.DriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class BaseTest extends DriverManager {

    public static Logger log = Logger.getLogger("TurknetTestCases-UI");

    @Parameters("browser")
    @BeforeTest
    public void startDriver(@Optional("browser") String browserName){

        //chrome, firefox, edge
        //String browserName = "chrome";
        setBrowser(browserName);
    }

    @AfterTest
    public void closeDriver(){

        quitDriver();
    }
}
