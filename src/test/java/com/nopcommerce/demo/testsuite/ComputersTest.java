package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ComputersTest extends BaseTest {
    ComputerPage computerPage = new ComputerPage();
    TopMenuTest topMenuTest = new TopMenuTest();

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        // Click on Computer Menu.
        computerPage.click(computerPage.computersMenu);
        // Click on Desktop
        computerPage.click(computerPage.desktop);
        // get all product name in list
        List expectedProductOrder = computerPage.verifyProductOrder(computerPage.productNameList);
        // Select Sort By position "Name: Z to A"
        computerPage.selectOption(computerPage.sortBy, computerPage.nameZ_A);
        //  Verify the Product will arrange in Descending order.
        List actualProductOrder = computerPage.verifyProductOrder(computerPage.productNameList);
        Assert.assertEquals(actualProductOrder, expectedProductOrder, "Product not arranged in descending order");

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // Click on Computer Menu.
        computerPage.click(computerPage.computersMenu);
        // Click on Desktop
        computerPage.click(computerPage.desktop);
        // Select Sort By position "Name: A to Z"
        computerPage.selectOption(computerPage.sortBy, computerPage.nameA_Z);
        // Click on "Add To Cart"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(computerPage.addToCartForBYOC));
        computerPage.click(computerPage.addToCartForBYOC);
        // Verify the Text "Build your own computer"
        Assert.assertEquals(computerPage.verifyText(computerPage.buildYOC), "Build your own computer", "Text not displayed");
        // Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        computerPage.selectOption(computerPage.processor2_5, "2.2 GHz Intel Pentium Dual-Core E2200");
        //Select "8GB [+$60.00]" using Select class.
        computerPage.selectOption(computerPage.ram8GB, "8GB [+$60.00]");
        // Select HDD radio "400 GB [+$100.00]"
        computerPage.click(computerPage.hdd400GB);
        // Select OS radio "Vista Premium [+$60.00]"
        computerPage.click(computerPage.osVH);
        //  Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userName1 = wait.until(ExpectedConditions.visibilityOfElementLocated(computerPage.softwareTC));
        computerPage.click(computerPage.softwareTC);
        //  Verify the price "$1,475.00"
        Thread.sleep(2000);
        Assert.assertEquals(computerPage.verifyText(computerPage.totalPrice), "$1,475.00", "Wrong Price");
        // Click on "ADD TO CARD" Button
        computerPage.click(computerPage.addToCartButton);
        // Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals(computerPage.verifyText(computerPage.confirmationMessage), "The product has been added to your shopping cart", "Message not displayed");
        //After that close the bar clicking on the cross button.
        computerPage.click(computerPage.crossButton);
        // Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnTheElement(computerPage.shoppingCart);
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userName2 = wait.until(ExpectedConditions.visibilityOfElementLocated((computerPage.goToCart)));
        computerPage.click(computerPage.goToCart);
        // Verify the message "Shopping cart"
        computerPage.verifyText(computerPage.message);
        // Change the Qty to "2" and Click on "Update shopping cart"
        computerPage.changeParameter(computerPage.qtyBox, "2");
        computerPage.click(computerPage.updateCartButton);
        // Verify the Total"$2,950.00"
        Assert.assertEquals(computerPage.verifyText(computerPage.subTotal), "$2,950.00", "Wrong Total");
        // click on checkbox “I agree with the terms of service”
        computerPage.click(computerPage.agreeCheckBox);
        // Click on “CHECKOUT”
        computerPage.click(computerPage.checkOut);
        //  Verify the Text “Welcome, Please Sign In!”
        computerPage.verifyText(computerPage.welcomeMessage);
        // Click on “CHECKOUT AS GUEST” Tab
        computerPage.click(computerPage.guestCheckout);
        // Fill the all mandatory field
        computerPage.sendTextToTheElement(computerPage.firstName, "Daun");
        computerPage.sendTextToTheElement(computerPage.lastName, "Wilkinson");
        final String randomEmail = randomEmail();
        computerPage.sendTextToTheElement(computerPage.email, randomEmail);
        computerPage.sendTextToTheElement(computerPage.country, "United Kingdom");
        computerPage.sendTextToTheElement(computerPage.city, "Birmingham");
        computerPage.sendTextToTheElement(computerPage.address1, "43");
        computerPage.sendTextToTheElement(computerPage.zipCode, "RT65 8UH");
        computerPage.sendTextToTheElement(computerPage.phoneNumber,"07656723476");
        //  Click on “CONTINUE”
        computerPage.click(computerPage.continueButton);
        // Click on Radio Button “Next Day Air($0.00)”
        computerPage.click(computerPage.radioNextDay);
        // Click on “CONTINUE”
        computerPage.click(computerPage.continueDelivery);
        // Select Radio Button “Credit Card”
        computerPage.click(computerPage.radioCredit);
        // click on continue
        computerPage.click(computerPage.continueNext);
        // Select “Master card” From Select credit card dropdown
        computerPage.selectByVisibleTextFromDropDown(computerPage.creditCardDropdown, "Master card");
        // Fill all the details
        computerPage.sendTextToTheElement(computerPage.cardHolderName,"xyz");
        computerPage.sendTextToTheElement(computerPage.cardNumber,"0000000000000000");
        computerPage.sendTextToTheElement(computerPage.expireMonth,"10");
        computerPage.sendTextToTheElement(computerPage.expireYear,"2025");
        computerPage.sendTextToTheElement(computerPage.cardCode,"456");
        // Click on “CONTINUE”
        computerPage.click(computerPage.continuePayment);
        // Verify “Payment Method” is “Credit Card”
        computerPage.verifyText(computerPage.paymentCC);
        // Verify “Shipping Method” is “Next Day Air”
        computerPage.verifyText(computerPage.shippingNDA);
        // Verify Total is “$2,950.00”
        computerPage.verifyText(computerPage.subTotal);
        // Click on “CONFIRM”
        computerPage.click(computerPage.confirm);
        // Verify the Text “Thank You”
        computerPage.verifyText(computerPage.thankYouMessage);
        // Verify the message “Your order has been successfully processed!”
        computerPage.verifyText(computerPage.proceedMessage);
        // Click on “CONTINUE”
        computerPage.click(computerPage.finalContinue);
        // Verify the text “Welcome to our store”
        computerPage.verifyText(computerPage.welcomeText);





    }
}
