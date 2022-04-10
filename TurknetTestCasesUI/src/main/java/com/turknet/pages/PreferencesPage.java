package com.turknet.pages;

import com.turknet.util.UtilityPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import static com.turknet.base.BaseTest.*;
import static com.turknet.core.DriverManager.driver;

public class PreferencesPage {

    public static By checkboxModem = By.cssSelector("input[name='Modem']");
    public static By checkboxModemForm = By.cssSelector("input[name='ModemOnBilgilendirmeFormu']");
    public static By checkboxModemForm2 = By.cssSelector("input[name='ModemMesafeliSatisSozlesmesi']");
    public static By checkboxIp = By.cssSelector("input[name='Statik IP']");
    public static By checkboxPhone = By.cssSelector("input[name='Ev Telefonu']");

    public static By changeBillButton = By.cssSelector("p[class='sc-jSgupP dInnIP']");
    public static By invoiceChoice = By.cssSelector("div[class='select__control css-1s2u09g-control']");
    public static By invoiceChoiceBillEPosta = By.xpath("//*[text()='E-Posta']");
    public static By clickContinueButton = By.cssSelector("button[class='sc-gKsewC gTsVDX']");
    public static By modalControl = By.cssSelector("div[class='sc-bdfBwQ jBNmKK sc-kLgntA clPJcm']");

    public static void tabPreferencesInfo() {

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");

        UtilityPage.clickElement(checkboxModem);
        UtilityPage.clickElement(checkboxModemForm);
        UtilityPage.clickElement(checkboxModemForm2);
        UtilityPage.clickElement(checkboxIp);
        UtilityPage.clickElement(checkboxPhone);
    }

    public static void tabInvoiceChoice(){

        UtilityPage.clickElement(changeBillButton);
        log.info("*** Fatura tercihi değiştir tıklandı. ***");

        UtilityPage.clickElement(invoiceChoice);
        log.info("*** Fatura tercihi değiştirme için dropbox listelendi. ***");

        UtilityPage.clickElement(invoiceChoiceBillEPosta);
        log.info("*** Fatura tercihi E-Posta olarak değiştirildi. ***");

        UtilityPage.clickElement(clickContinueButton);
        log.info("*** Telefon numarası doğrulama modalına yönlendirildi.");

        UtilityPage.isElementVisible(modalControl);
        Assert.assertTrue(UtilityPage.isElementVisible(modalControl));
        log.info("*** Telefon numarası doğrulama modalının başarılı bir şekilde açıldığı kontrol edildi.");
    }
}


