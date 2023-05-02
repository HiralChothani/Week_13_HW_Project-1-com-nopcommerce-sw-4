package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

public class ComputerPage extends Utility {
    public By computersMenu = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']");
    public By desktop = By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']");
    public By sortBy = By.xpath("//select[@id='products-orderby']");
    public String nameZ_A = "Name: Z to A";
    public String nameA_Z = "Name: A to Z";
    public By productNameList = By.xpath("//h2");
    public By addToCartForBYOC = By.cssSelector("body > div:nth-child(7) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div:nth-child(2) > button:nth-child(1)");
    public By buildYOC = By.xpath("//h1[normalize-space()='Build your own computer']");
    public By processor2_5 = By.xpath("//select[@id='product_attribute_1']");
    public By ram8GB = By.xpath("//select[@id='product_attribute_2']");
    public By hdd400GB = By.xpath("//input[@id='product_attribute_3_7']");
    public By osVH = By.xpath("//input[@id='product_attribute_4_9']");
    public By softwareTC = By.xpath("//input[@id='product_attribute_5_12']");
    public By totalPrice = By.xpath("//span[@id='price-value-1']");
    public By addToCartButton = By.xpath("//button[@id='add-to-cart-button-1']");
    public By confirmationMessage = By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]");
    public By crossButton = By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]");
    public By shoppingCart = (RelativeLocator.with(By.xpath("//span[contains(text(),'Shopping cart')]")).toRightOf(By.xpath("//span[contains(text(),'Wishlist')]")));
    public By goToCart = By.xpath("//button[normalize-space()='Go to cart']");
    public By message = By.xpath("//h1[contains(text(),'Shopping cart')]");
    public By qtyBox = By.xpath("//input[@class='qty-input']");
    public By updateCartButton = By.xpath("//button[@id='updatecart']");
    public By subTotal = By.xpath("//span[@class='product-subtotal']");
    public By agreeCheckBox = By.xpath("//input[@id='termsofservice']");
    public By checkOut = By.xpath("//button[@id='checkout']");
    public By welcomeMessage = By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']");
    public By guestCheckout = By.xpath("//button[normalize-space()='Checkout as Guest']");
    public By firstName = By.id("BillingNewAddress_FirstName");
    public By lastName = By.id("BillingNewAddress_LastName");
    public By email = By.id("BillingNewAddress_Email");
    public By country = By.id("BillingNewAddress_CountryId");
    public By city = By.id("BillingNewAddress_City");
    public By address1 = By.id("BillingNewAddress_Address1");
    public By zipCode = By.id("BillingNewAddress_ZipPostalCode");
    public By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
    public By continueButton = By.xpath("//button[@onclick='Billing.save()']");
    public By radioNextDay = By.xpath("//input[@id='shippingoption_1']");
    public By continueDelivery = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
    public By radioCredit = By.xpath("//input[@id='paymentmethod_1']");
    public By creditCardDropdown = By.xpath("//select[@id='CreditCardType']");
    public By cardHolderName = By.xpath("//input[@id='CardholderName']");
    public By cardNumber = By.xpath("//input[@id='CardNumber']");
    public By expireMonth = By.xpath("//select[@id='ExpireMonth']");
    public By expireYear = By.xpath("//select[@id='ExpireYear']");
    public By cardCode = By.xpath("//input[@id='CardCode']");
    public By continuePayment = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    public By continueNext = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
   public By paymentCC = By.xpath("//span[normalize-space()='Credit Card']");
   public By shippingNDA = By.xpath("//span[normalize-space()='Next Day Air']");
   public By totalAmount = By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]");
   public By confirm = By.xpath("//button[normalize-space()='Confirm']");
   public By thankYouMessage = By.xpath("//h1[normalize-space()='Thank you']");
   public By proceedMessage = By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");
   public By finalContinue = By.xpath("//button[normalize-space()='Continue']");
   public By welcomeText = By.xpath("//h2[normalize-space()='Welcome to our store']");

    public void click(By by) {
        mouseHoverOnTheElementAndClick(by);
    }

    public void selectOption(By by, String option) {
        selectByVisibleTextFromDropDown(by, option);
    }

    public List verifyProductOrder(By by) {
        return getTextFromElements(by);
    }

    public String verifyText(By by) {
        return getTextFromElement(by);
    }

    public void changeParameter(By by, String text) {
        clickOnTheElement(by);
        clearText(by);
        sendTextToTheElement(by, text);
    }

}
