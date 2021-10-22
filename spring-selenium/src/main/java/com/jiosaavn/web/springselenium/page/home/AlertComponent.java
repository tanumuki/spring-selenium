package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PageFragment
public class AlertComponent extends BaseConfig {

    private static final Logger logger = LoggerFactory.getLogger(AlertComponent.class);


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
        logger.info("toast is getting clicked");
        logger.debug("toast is getting clicked");
        logger.warn("toast is getting clicked");
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
