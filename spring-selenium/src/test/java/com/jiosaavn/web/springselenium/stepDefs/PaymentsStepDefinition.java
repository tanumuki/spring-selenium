package com.jiosaavn.web.springselenium.stepDefs;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import com.jiosaavn.web.springselenium.page.login.LandingComponent;
import com.jiosaavn.web.springselenium.page.payments.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class PaymentsStepDefinition {

    /*
    Value of payment is there in application.properties
     */


    // PaymentPage paymentPage = new PaymentPage();
    @Value("${payment}")
    private String payOption;

    @Autowired
    private PaymentPage paymentPage;

    @Autowired
    private LandingComponent landingComponent;

    @And("^I verify the payment screen$")
    public void i_verify_the_payment_screen() throws Throwable {

        System.out.println("inside");
       // System.out.println("tet " +paymentPage.toString());
        //landingComponent.switchTab2();
        this.paymentPage.switchTab();
        Thread.sleep(2000);
        this.paymentPage.getTitle();
       // this.paymentPage.setPaymentOption(PaymentOptionFactory.get(payOption));
        BaseConfig config1 = new Paytm();
        this.paymentPage.setPaymentOption((PaymentOption)config1);
        this.paymentPage.pay();
        Thread.sleep(4000);
        System.out.println("payment verified");
    }




}
