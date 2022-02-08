package com.jiosaavn.web.springselenium.page.payments;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory {




    private static  Supplier<PaymentOption> amazon = () ->new AmazonPay();
    private static  Supplier<PaymentOption> paytm = () ->new Paytm();

    private static final Map<String,Supplier<PaymentOption>> map = new HashMap<>();

    static {
        map.put("amazonPay", amazon);
        map.put("paytm",paytm);
        System.out.println("mape "+map.toString());
    }

    public static PaymentOption get(String option){
        return map.get(option).get();
    }

}
