package com.jiosaavn.web.springselenium.page.payments;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.springframework.beans.factory.annotation.Autowired;

@PageFragment
public class PaymentPage extends BaseConfig {


    @Autowired
    private PaymentOption paymentOption;


    public void setPaymentOption(PaymentOption paymentOption){
        this.paymentOption=paymentOption;
    }

    public PaymentOption getPaymentOption(PaymentOption paymentOption){
        return paymentOption;
    }

    public void pay(){
        this.paymentOption.selectPayment();
    }


    @Override
    public boolean isAt() {
        return false;
    }
}
