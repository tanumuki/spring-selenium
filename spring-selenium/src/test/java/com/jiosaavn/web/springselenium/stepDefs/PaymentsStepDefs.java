package com.jiosaavn.web.springselenium.stepDefs;

import com.jiosaavn.web.springselenium.page.home.HomePage;
import com.jiosaavn.web.springselenium.page.login.HomePageLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentsStepDefs {



    @And("^I verify the payment screen$")
    public void i_verify_the_payment_screen() throws Throwable {

        System.out.println("payment verifued");
    }



}
