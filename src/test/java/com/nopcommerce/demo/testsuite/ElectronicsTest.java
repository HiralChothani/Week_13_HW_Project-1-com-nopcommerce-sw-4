package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.ElectronicsPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElectronicsTest extends BaseTest {
    TopMenuTest topMenuTest = new TopMenuTest();
    ElectronicsPage electronicsPage = new ElectronicsPage();

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //  Mouse Hover on “Electronics” Tab
        electronicsPage.mouseHover(electronicsPage.electronics);
        // Mouse Hover on “Cell phones” and click
        electronicsPage.click(electronicsPage.cellPhones);
        // Verify the text “Cell phones”
        Assert.assertEquals(electronicsPage.verifyText(electronicsPage.cellPhoneText), "Cell phones", "Text not displayed");

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // Mouse Hover on “Electronics” Tab
        // Mouse Hover on “Cell phones” and click
        // Verify the text “Cell phones”
        verifyUserShouldNavigateToCellPhonesPageSuccessfully();
        // Click on List View Tab
        electronicsPage.click(electronicsPage.listViewTab);
        // Click on product name “Nokia Lumia 1020” link
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(electronicsPage.productNL1020));
        Thread.sleep(2000);
        electronicsPage.click(electronicsPage.productNL1020);
        // Verify the text “Nokia Lumia 1020”
        Assert.assertEquals(electronicsPage.verifyText(electronicsPage.NL1020Text), "Nokia Lumia 1020", "Text not displayed");
        // Verify the price “$349.00
        Assert.assertEquals(electronicsPage.verifyText(electronicsPage.price349), "$349.00", "Wrong Price");
        // Change quantity to 2
        electronicsPage.changeParameter(electronicsPage.qtyBox, "2");
        //  Click on “ADD TO CART” tab
        electronicsPage.click(electronicsPage.addToCart);
        // Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals(electronicsPage.verifyText(electronicsPage.confirmationMessage), "The product has been added to your shopping cart", "message not displayed");
        // After that close the bar clicking on the cross button.
        electronicsPage.click(electronicsPage.crossButton);
        // Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
//        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
//        WebElement userName1 = wait.until(ExpectedConditions.visibilityOfElementLocated(electronicsPage.productNL1020));
        Thread.sleep(2000);
        electronicsPage.mouseHover(electronicsPage.shoppingCartTab);
        electronicsPage.click(electronicsPage.goToCart);
        // Verify the message "Shopping cart"
        electronicsPage.verifyText(electronicsPage.shoppingCartText);
        // Verify the quantity is 2
        String actualQuantity = driver.findElement(By.xpath("//input[@class='qty-input']")).getAttribute("value");
        String expectedQuantity = "2";
        Assert.assertEquals(expectedQuantity, actualQuantity);
        // Verify the Total $698.00
        Assert.assertEquals(electronicsPage.verifyText(electronicsPage.total698), "$698.00", "Wrong total Price");
        // click on checkbox “I agree with the terms of service”
        electronicsPage.click(electronicsPage.agreeCheckBox);
        //  Click on “CHECKOUT”
        electronicsPage.click(electronicsPage.checkOut);
        // Verify the Text “Welcome, Please Sign In!”
        electronicsPage.verifyText(electronicsPage.welcomeMessage);
        // Click on “REGISTER” tab
        electronicsPage.click(electronicsPage.registerTab);
        // Verify the text “Register”
        electronicsPage.verifyText(electronicsPage.registerText);
        //  Fill the mandatory fields
        electronicsPage.sendTextToTheElement(electronicsPage.firstName, "Daun");
        electronicsPage.sendTextToTheElement(electronicsPage.lastName, "Wilkinson");
        final String randomEmail = randomEmail();
        electronicsPage.sendTextToTheElement(electronicsPage.email, randomEmail);
        electronicsPage.sendTextToTheElement(electronicsPage.password, "abcd1234");
        electronicsPage.sendTextToTheElement(electronicsPage.confirmPassword, "abcd1234");
        //  Click on “REGISTER” Button
        electronicsPage.click(electronicsPage.registerButton);
        // Verify the message “Your registration completed”
        Assert.assertEquals(electronicsPage.verifyText(electronicsPage.completeRegistrationText), "Your registration completed", "Message not displayed");
        // Click on “CONTINUE” tab
        electronicsPage.click(electronicsPage.continueTab);
        // Verify the text “Shopping card”
        electronicsPage.verifyText(electronicsPage.shoppingCartText);
        // click on Login
        electronicsPage.click(electronicsPage.logInLink);
        // verify text "Welcome, Please Sign In!"
        electronicsPage.verifyText(electronicsPage.welcomeMessage);
        // Enter email, password
        electronicsPage.sendTextToTheElement(electronicsPage.email, "Julie.will1@gmail.com");
        electronicsPage.sendTextToTheElement(electronicsPage.password, "abcd1234");
        // click on LOGIN button
        electronicsPage.click(electronicsPage.logInLinkButton);
        // click on checkbox “I agree with the terms of service”
        electronicsPage.click(electronicsPage.agreeCheckBox);
        // Click on “CHECKOUT”
        electronicsPage.click(electronicsPage.checkOut);
        // click on continue
        electronicsPage.click(electronicsPage.continueButton);
        //  Click on Radio Button “2nd Day Air ($0.00)”
        electronicsPage.click(electronicsPage.radio2dayAir);
        // Click on “CONTINUE”
        electronicsPage.click(electronicsPage.continueShippingNext);
        // Select Radio Button “Credit Card”
        electronicsPage.click(electronicsPage.radioCC);
        electronicsPage.click(electronicsPage.continuePaymentNext);
        // Select “Visa” From Select credit card dropdown
        electronicsPage.selectByVisibleTextFromDropDown(electronicsPage.cardOption, "Visa");
        // Fill all the details
        electronicsPage.sendTextToTheElement(electronicsPage.cardHolderName, "xyz");
        electronicsPage.sendTextToTheElement(electronicsPage.cardNumber, "0000000000000000");
        electronicsPage.sendTextToTheElement(electronicsPage.expireMonth, "10");
        electronicsPage.sendTextToTheElement(electronicsPage.expireYear, "2025");
        electronicsPage.sendTextToTheElement(electronicsPage.cardCode, "456");
        // Click on “CONTINUE”
        electronicsPage.click(electronicsPage.continuePaymentNext);
        // Verify “Payment Method” is “Credit Card”
        Assert.assertEquals(electronicsPage.verifyText(electronicsPage.paymentMethodCC), "Credit Card", "Payment method different");
        // Verify “Shipping Method” is “2nd Day Air”
        Assert.assertEquals(electronicsPage.verifyText(electronicsPage.shippingMethod2Day), "2nd Day Air", "Shipping Method different");
        // Verify Total is “$698.00”
        Assert.assertEquals(electronicsPage.verifyText(electronicsPage.totalFinal), "$698.00", "Wrong Total");
        // Click on “CONFIRM”
        electronicsPage.click(electronicsPage.confirmButton);
        //  Verify the Text “Thank You”
        Assert.assertEquals(electronicsPage.verifyText(electronicsPage.thankYouText), "Thank you", "Text not dispalyed");
        // Verify the message “Your order has been successfully processed!”
        Assert.assertEquals(electronicsPage.verifyText(electronicsPage.orderConfirmationMessage), "Your order has been successfully processed!", "Message not displayed");
        // Click on “CONTINUE”
        electronicsPage.click(electronicsPage.continueButtonAfterPayment);
        // Verify the text “Welcome to our store”
        Assert.assertEquals(electronicsPage.verifyText(electronicsPage.welcomeToStoreMessage), "Welcome to our store", "Text not displayed");
        // Click on “Logout” link
        electronicsPage.click(electronicsPage.logOut);
        // Verify the URL is “https://demo.nopcommerce.com/”
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demo.nopcommerce.com/";
        Assert.assertEquals("Url does not match", expectedUrl, currentUrl);
    }
}
