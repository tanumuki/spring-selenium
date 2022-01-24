package com.jiosaavn.web.springselenium.page.login;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import com.jiosaavn.web.springselenium.page.home.AlertComponent;
import com.jiosaavn.web.springselenium.page.home.CaptchaComponent;
import org.openqa.selenium.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@PageFragment
public class HomePageLogin extends BaseConfig {

    @Autowired
    protected LandingComponent landingComponent;

    @Autowired
    protected LoginPageComponent loginPageComponent;

    @Autowired
    protected AlertComponent alertComponent;

    @Autowired
    protected CaptchaComponent captchaComponent;

    @Value("${application.url: https://staging.jiosaavn.com}")
    private String application_url;

    public void goTo(){
        System.out.println("Opening extension");
       // driver.get("chrome-extension://obldlamadkihjlkdjblncejeblbogmnb/jiosaavn.com/login?redirect=/");
       // driver.navigate().refresh();
        System.out.println("Refresh successfully");
        this.driver.get(application_url);
        System.out.println("opened "+application_url);
       // this.driver.manage().
    }
    public void goToLoginPageWithoutCatpcha(){
        this.driver.get(application_url);
        this.driver.manage().addCookie(new Cookie("captcha-bypass" ,"6R1VzqByL1WCfSfTwiUcRWqO2YcftgB1u4"));
        this.driver.navigate().refresh();
        loginPageComponent.clickLoginButton();
    }

    public LandingComponent getLandingComponent(){
        return landingComponent;
    }

    public LoginPageComponent getLoginPageComponent(){
        return loginPageComponent;
    }

    public AlertComponent getAlertComponent(){
        return alertComponent;
    }
    public CaptchaComponent getCaptchaComponent(){
        return captchaComponent;
    }

    @PreDestroy
    public void closeBrowsers(){
        driver.quit();
    }

    @Override
    public boolean isAt() {
        return this.getLoginPageComponent().isAt();
    }
}
