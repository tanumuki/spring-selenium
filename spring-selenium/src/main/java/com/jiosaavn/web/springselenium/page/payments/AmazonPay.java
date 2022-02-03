package com.jiosaavn.web.springselenium.page.payments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class AmazonPay  implements PaymentOption{

    @FindBy(xpath = "//label[@for='amazon_1']")
    private WebElement payWithAmazonPay;


    @Override
    public void paymentInfo(Map<String ,String> paymentDetails) {

        payWithAmazonPay.click();
    }
}
