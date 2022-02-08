package com.jiosaavn.web.springselenium.page.payments;

import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class AmazonPay extends BaseConfig implements PaymentOption {

    @FindBy(xpath = "//label[@for='amazon_1']")
    protected WebElement payWithAmazonPay;


    @Override
    public void selectPayment() {

        payWithAmazonPay.click();
        System.out.println("clicked aApay");
    }


    @Override
    public boolean isAt() {
        return false;
    }
}
