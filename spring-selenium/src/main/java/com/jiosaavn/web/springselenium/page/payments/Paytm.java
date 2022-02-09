package com.jiosaavn.web.springselenium.page.payments;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;
@PageFragment
public class Paytm extends BaseConfig implements PaymentOption {


    @FindBy(xpath = "//label[@for='paytm_1']")
    protected WebElement payWithPaytm;


    @Override
    public void selectPayment() {
        System.out.println("entering inside select payment method");
        if(payWithPaytm==null){
            System.out.println("its null");
        }
        this.payWithPaytm.click();
        System.out.println("clicked paytm");
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
