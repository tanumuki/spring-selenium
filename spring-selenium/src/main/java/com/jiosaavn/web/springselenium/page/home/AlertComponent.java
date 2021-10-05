package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@PageFragment
public class AlertComponent extends BaseConfig {


    @FindBy(xpath = "//span[@class='c-btn c-btn--senary c-btn--tiny']")
    private WebElement cookiesToast;

    @FindBy(xpath = "//span[@class='c-btn c-btn--primary c-btn--medium']")
    private WebElement alertToast;

    @FindBy(xpath = "//span[@class='c-modal__close']")
    private WebElement closeAlertToast;

    public void acceptCookie(){
        this.cookiesToast.click();
    }

    public void closeAlert(){
            this.closeAlertToast.click();
    }
    public void waitForAlertToAppear(){
        this.webDriverWait.until(d->alertToast.isDisplayed());
    }

    public void waitForAlertToDisappear(){
        this.webDriverWait.until(d->!alertToast.isDisplayed());
    }



    @Override
    public boolean isAt() {
        return false;
    }
}
