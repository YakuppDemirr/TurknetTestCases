package com.turknet.pages;

import com.turknet.util.UtilityPage;
import org.openqa.selenium.By;

public class SubscribePage {


    public static By personalButton = By.cssSelector("li[id='menu-item-18']");
    public static By subscribeButton = By.cssSelector("li[id='menu-item-1952'] a");

    public static void goToSubscribePage(){

        UtilityPage.hoverElement(personalButton);
        UtilityPage.clickElement(subscribeButton);
    }
}
