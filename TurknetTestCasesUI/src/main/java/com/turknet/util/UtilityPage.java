package com.turknet.util;

import com.turknet.core.ConstantsPage;
import com.turknet.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.turknet.base.BaseTest.*;
import java.time.Duration;

public class UtilityPage extends DriverManager {

    //Saniye cinsinden bekleme
    public static void waitBySeconds ( int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void hoverElement(By element){
        Actions builder = new Actions(driver);
        WebElement webElement = driver.findElement(element);
        builder.moveToElement(webElement).build().perform();
    }

    public static boolean getHomePageControl(){
        return driver.getCurrentUrl()
                .equals(ConstantsPage.getHomePageUrl);
    }

    public static boolean getSubscribePageControl(){
        return driver.getCurrentUrl()
                .equals("https://turk.net/taahhutsuz-ozgur-iletisim-abonelik");
    }

    public static boolean getTextEmailControl(By element){
        return driver.findElement(element)
                .getText()
                .equals("Geçerli bir e-posta giriniz");
    }

    public static WebElement waitElementVisible(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return webElement;
    }

    public static boolean isElementVisible(By element){
        boolean isVisible = false;
        try
        {
            isVisible = waitElementVisible(element).isDisplayed();
        }
        catch (Exception e)
        {
            log.info("Element " + element + " bulunamadı.");
            isVisible = false;
        }
        return isVisible;
    }

    public static boolean clickElement(By element){
        boolean isClick = false;
        try
        {
            waitElementVisible(element).click();
            isClick = true;
        }
        catch (Exception e)
        {
            log.info("Element " + element + " bulunamadı.");
            isClick = false;
        }
        return isClick;
    }

    public static void setByXpath(String xpath, String value){
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        element.sendKeys(value);
    }

    public static void clickByXpath(String xpath){
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }

    public static boolean sendKeysElementClear(By element){
        boolean isSendKeys = false;

        try
        {
            WebElement webElement = waitElementVisible(element);
            webElement.clear();
            isSendKeys = true;
        }
        catch (Exception e)
        {
            log.info("Element " + element + " bulunamadı.");
            isSendKeys = false;
        }
        return isSendKeys;
    }

    public static boolean sendKeysElement(By element, String value ){
        boolean isSendKeys = false;

        try
        {
            WebElement webElement = waitElementVisible(element);
            webElement.sendKeys(value);
            isSendKeys = true;
        }
        catch (Exception e)
        {
            log.info("Element " + element + " bulunamadı.");
            isSendKeys = false;
        }
        return isSendKeys;
    }
}
