package com.jiosaavn.web.springselenium.page.payments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class Paytm implements PaymentOption{


    @FindBy(xpath = "//label[@for='paytm_1']")
    private WebElement payWithPaytm;


    @Override
    public void paymentInfo(Map<String ,String> paymentDetails) {

        payWithPaytm.click();
    }
}
