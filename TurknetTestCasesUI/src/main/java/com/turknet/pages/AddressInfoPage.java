package com.turknet.pages;

import com.turknet.util.UtilityPage;
import org.openqa.selenium.*;
import static com.turknet.base.BaseTest.*;
import static com.turknet.core.ConstantsPage.*;

public class AddressInfoPage {

    public static By radioButtonNoInternet = By.xpath("//*[contains(text(), 'İnternet yok')]");
    public static By radioButtonNoPhone = By.xpath("//*[contains(text(), 'Telefon yok')]");
    public static By clickContinueButton = By.cssSelector("button[class='sc-gKsewC gTsVDX'] span");

    public static void tabAddressInfo(){

        UtilityPage.clickElement(radioButtonNoInternet);
        log.info("*** Kullanıcı internet yok seçeneğini işaretledi. ***");

        UtilityPage.clickElement(radioButtonNoPhone);
        log.info("*** Kullanıcı telefon yok seçeneğini işaretledi. ***");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        controlDropdown();

        js.executeScript("window.scrollBy(0,600)");
        UtilityPage.clickElement(clickContinueButton);
        log.info("*** Kullanıcı tercihler tabına ilerledi. ***");
    }

    public static void controlDropdown(){

        for (int i = 1; i <= 6; i++) {
            UtilityPage.clickByXpath("(//div[@class='select__input-container css-ackcql'])[" + i + "]");
            switch (i)
            {
                case 1:
                    UtilityPage.setByXpath("(//input[@class='select__input'])[" + i + "]",city);
                    driver.findElement(By.xpath("(//input[@class='select__input'])[" + i + "]")).sendKeys(Keys.ENTER);
                    log.info("*** İl bilgisi girildi. ***");
                    break;
                case 2:
                    UtilityPage.setByXpath("(//input[@class='select__input'])[" + i + "]",county);
                    driver.findElement(By.xpath("(//input[@class='select__input'])[" + i + "]")).sendKeys(Keys.ENTER);
                    log.info("*** İlçe bilgisi girildi. ***");
                    break;
                case 3:
                    UtilityPage.setByXpath("(//input[@class='select__input'])[" + i + "]",neighborhood);
                    driver.findElement(By.xpath("(//input[@class='select__input'])[" + i + "]")).sendKeys(Keys.ENTER);
                    log.info("*** Mahalle bilgisi girildi. ***");
                    break;
                case 4:
                    UtilityPage.setByXpath("(//input[@class='select__input'])[" + i + "]",street);
                    driver.findElement(By.xpath("(//input[@class='select__input'])[" + i + "]")).sendKeys(Keys.ENTER);
                    log.info("*** Sokak bilgisi girildi. ***");
                    break;
                case 5:
                    UtilityPage.setByXpath("(//input[@class='select__input'])[" + i + "]",building);
                    driver.findElement(By.xpath("(//input[@class='select__input'])[" + i + "]")).sendKeys(Keys.ENTER);
                    log.info("*** Bina bilgisi girildi. ***");
                    break;
                case 6:
                    UtilityPage.setByXpath("(//input[@class='select__input'])[" + i + "]",apartment);
                    driver.findElement(By.xpath("(//input[@class='select__input'])[" + i + "]")).sendKeys(Keys.ENTER);
                    log.info("*** Daire bilgisi girildi. ***");
                    break;
                default:
                    break;
            }
        }
    }
}