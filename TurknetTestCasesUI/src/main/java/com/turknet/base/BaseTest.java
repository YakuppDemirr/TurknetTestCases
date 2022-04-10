package com.turknet.base;

import com.turknet.core.DriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class BaseTest extends DriverManager {

    public static Logger log = Logger.getLogger("TurknetTestCases-UI");

    @BeforeTest
    public void startDriver(){

        //chrome, firefox, edge
        String browserName = "chrome";
        setBrowser(browserName);
    }

    @AfterTest
    public void closeDriver(){

        quitDriver();
    }
}
