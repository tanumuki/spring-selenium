package com.jiosaavn.web.springselenium.page.payments;
import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageFragment
public class Paytm extends BaseConfig implements PaymentOption {


//    @Autowired
//    public WebDriver driver;

    public Paytm(){
        super();
        System.out.println("default cons" +driver.toString());

    }

    @FindBy(xpath = "//label[@for='paytm_1']")
    protected WebElement payWithPaytm;



    @Override
    public void selectPayment() {
        System.out.println("value of payment option ");
        System.out.println("entering inside select payment method");
       // System.out.println("value of paywith paytn "+payWithPaytm.toString());
        System.out.println("value of driver "+driver.toString());
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
