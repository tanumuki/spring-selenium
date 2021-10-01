package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class AlertComponent extends BaseConfig {


    @FindBy(xpath = "//span[@class='c-btn c-btn--senary c-btn--tiny']")
    private WebElement cookiesToast;

    @FindBy(xpath = "//span[@class='c-btn c-btn--primary c-btn--medium']")
    private WebElement alertToast;

    public void acceptCookie(){
        this.cookiesToast.click();
    }

    public void acceptAlertToast(){
        this.alertToast.click();
    }

    public void waitForAlertToAppear(){
        this.alertToast.wait();
    }



    @Override
    public boolean isAt() {
        return false;
    }
}
