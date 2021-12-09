package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.apache.tomcat.jni.Time;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@PageFragment
public class CaptchaComponent extends BaseConfig {


    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
        private WebElement captchaIframe;

    @FindBy(css = "div.recaptcha-checkbox-border")
    private WebElement checkbox;


    public void clickCaptchaBox() throws InterruptedException {
        System.out.println("captcha wait");
       // Thread.sleep(10000);

        System.out.println("wait 1" +ExpectedConditions.frameToBeAvailableAndSwitchToIt(captchaIframe));
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(captchaIframe));
        //this.webDriverWait.withTimeout(Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(captchaIframe));
        System.out.println("captcha wait2");
        System.out.println("wait 2" +ExpectedConditions.elementToBeClickable(checkbox));
       // Thread.sleep(20000);
        TimeUnit.SECONDS.sleep(20);
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(checkbox)).click();
       // this.webDriverWait.withTimeout(Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(checkbox)).click();
        System.out.println("captcha click");
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
