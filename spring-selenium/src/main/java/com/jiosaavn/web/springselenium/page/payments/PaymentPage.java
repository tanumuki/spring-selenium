package com.jiosaavn.web.springselenium.page.payments;
import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@PageFragment
public class PaymentPage extends BaseConfig {


//    @Autowired
//    private PaymentOption paymentOption;

   private PaymentOption paymentOption;


    public void setPaymentOption(PaymentOption paymentOption){
        this.paymentOption=paymentOption;
    }

    public PaymentOption getPaymentOption(PaymentOption paymentOption){
        return paymentOption;
    }

    public void switchTab(){
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    public void pay(){
        System.out.println("payment option vlaue is "+paymentOption.toString());
        this.paymentOption.selectPayment();
    }


    @Override
    public boolean isAt() {
        return false;
    }
}
