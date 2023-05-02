package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {
    public By computersMenu = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']");
    public By computersText = By.xpath("//h1[normalize-space()='Computers']");


    public void selectMenu(By by) {
        clickOnTheElement(by);
    }

    public String verifyText(By by) {
        return getTextFromElement(by);
    }

}
