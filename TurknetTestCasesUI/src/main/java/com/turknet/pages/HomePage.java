package com.turknet.pages;

import static com.turknet.core.DriverManager.*;
import com.turknet.core.ConstantsPage;
import org.openqa.selenium.By;

public class HomePage {

    //region Home Page All Elements
    public static By logo = By.cssSelector(".attachment-full.size-full.lazy.loaded[width='300']");
    //endregion

    //region Home Page Methods
    public static void goToHomePage(){
        driver.navigate().to(ConstantsPage.getHomePageUrl);
    }
    //endregion
}
