package com.turknet;

import com.turknet.base.BaseTest;
import com.turknet.util.UtilityPage;
import org.testng.Assert;
import org.testng.annotations.*;
import static com.turknet.pages.AddressInfoPage.*;
import static com.turknet.pages.HomePage.*;
import static com.turknet.pages.PreferencesPage.*;
import static com.turknet.pages.SubscribePage.*;
import static com.turknet.pages.UserInfoPage.*;

public class TestCase1 extends BaseTest {

    @BeforeTest()
    public void openHomePage(){

        goToHomePage();
        Assert.assertTrue(UtilityPage.isElementVisible(logo));
        Assert.assertTrue(UtilityPage.getHomePageControl());
        log.info("*** Turknet ana sayfası başarılı bir şekilde açıldı. ***");
    }

    @Test(priority = 1)
    public void openSubscribePage(){

        goToSubscribePage();
        Assert.assertTrue(UtilityPage.getSubscribePageControl());
        log.info("*** Abone ol sayfası başarılı bir şekilde açıldı ***");
    }

    @Test(priority = 2)
    public void writeUserInfo(){

        tabUserInfo();
        log.info("*** Kişisel bilgiler başarılı bir şekilde girildi. ***");
    }

    @Test(priority = 3)
    public void writeAddressInfo(){

        tabAddressInfo();
        log.info("*** Adres bilgileri başarılı bir şekilde girildi. ***");
    }

    @Test(priority = 4)
    public void writePreferencesInfo(){

        tabPreferencesInfo();
        log.info("*** Tercih bilgileri başarılı bir şekilde girildi. ***");
    }

    @Test(priority = 5)
    public void writeInvoiceChoice(){

        tabInvoiceChoice();
        log.info("*** Fatura tercihi başarılı bir şekilde değiştirildi. ***");
    }
}
