package com.jiosaavn.web.springselenium.page.payments;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@PageFragment
public class AmazonPay extends BaseConfig implements PaymentOption {

    @FindBy(xpath = "//label[@for='amazon_1']")
    public WebElement payWithAmazonPay;


    @Override
    public void selectPayment() {
        System.out.println("inside select oayment of amazon");

        this.payWithAmazonPay.click();
        System.out.println("clicked aApay");
    }


    @Override
    public boolean isAt() {
        return false;
    }
}
