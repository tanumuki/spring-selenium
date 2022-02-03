package com.jiosaavn.web.springselenium.page.payments;

import com.jiosaavn.web.springselenium.page.BaseConfig;

public class PaymentPage extends BaseConfig {


    private PaymentOption paymentOption;


    public void setPaymentOption(PaymentOption paymentOption){
        this.paymentOption=paymentOption;
    }

    public PaymentOption getPaymentOption(PaymentOption paymentOption){
        return paymentOption;
    }


    @Override
    public boolean isAt() {
        return false;
    }
}
