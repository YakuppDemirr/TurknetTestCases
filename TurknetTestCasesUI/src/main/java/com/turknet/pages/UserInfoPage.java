package com.turknet.pages;

import com.turknet.util.UtilityPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import static com.turknet.core.ConstantsPage.*;
import static com.turknet.base.BaseTest.*;

public class UserInfoPage {

    public static By nameSurnameText = By.cssSelector("input[name='FullName']");
    public static By emailText = By.cssSelector("input[name='Email']");
    public static By phoneText = By.cssSelector("input[name='Gsm']");
    public static By checkBoxKvkk = By.cssSelector("input[name='IsPersonalInformationTextRead']");
    public static By modalKvkkButton = By.cssSelector("button[class='sc-gKsewC goUKvN'] span");
    public static By clickContinueButton = By.cssSelector("button[class='sc-fubCfw jZlafD'] span");
    public static By checkEmailMessage = By.xpath("//*[text()='Geçerli bir e-posta giriniz']");

    public static void tabUserInfo(){

        UtilityPage.sendKeysElement(nameSurnameText, nameSurname);
        log.info("*** Kullanıcı adı soyadı girildi. ***");

        UtilityPage.sendKeysElement(emailText, invalidEmail);
        log.info("*** Kullanıcı email girildi. ***");

        UtilityPage.sendKeysElement(phoneText, phoneNumber);
        log.info("*** Kullanıcı telefon girildi. ***");

        UtilityPage.clickElement(checkBoxKvkk);
        log.info("*** Kullanıcı kvkk onayını için checkbox işaretledi. ***");

        UtilityPage.clickElement(modalKvkkButton);
        log.info("*** Kullanıcı kvkk onayını için açılan modalı kapadı. ***");
        UtilityPage.clickElement(clickContinueButton);

        Assert.assertTrue(UtilityPage.isElementVisible(checkEmailMessage));
        UtilityPage.sendKeysElementClear(emailText);
        log.info("*** Kullanıcı hatalı email bilgisi silindi. ***");

        UtilityPage.sendKeysElement(emailText, email);
        log.info("*** Kullanıcı email girildi. ***");

        UtilityPage.clickElement(clickContinueButton);
        log.info("*** Kullanıcı adres bilgilerine ilerledi. ***");
    }
}
