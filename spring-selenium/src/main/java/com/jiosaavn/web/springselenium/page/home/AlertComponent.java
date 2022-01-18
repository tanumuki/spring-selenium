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

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/header/div/div[2]/nav/ul/li[1]/a")
    private WebElement login_btn;

    public void acceptCookie(){
        this.cookiesToast.click();
    }

    public void closeAlert(){
        logger.info("toast is getting clicked");
//        logger.debug("toast is getting clicked");
//        logger.warn("toast is getting clicked");
        this.closeAlertToast.click();
    }

    public void waitForAlertToAppear() throws InterruptedException {
        Thread.sleep(2000);
        this.webDriverWait.until((d)->this.alertToast.isDisplayed());
    }

    public void waitForAlertToDisappear(){
        this.webDriverWait.until(d->!alertToast.isDisplayed());
    }

    public void maximizeScreen(){
        this.driver.manage().window().maximize();
    }

    @Override
    public boolean isAt() {

        return this.webDriverWait.until((d)->this.login_btn.isDisplayed());
    }
}
