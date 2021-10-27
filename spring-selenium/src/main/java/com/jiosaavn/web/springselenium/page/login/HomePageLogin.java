package com.jiosaavn.web.springselenium.page.login;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import com.jiosaavn.web.springselenium.page.home.AlertComponent;
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

    @Value("${application.url: https://staging.jiosaavn.com}")
    private String application_url;

    public void goTo(){
        this.driver.get(application_url);
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

    @PreDestroy
    public void closeBrowsers(){
        driver.quit();
    }

    @Override
    public boolean isAt() {
        return this.getLoginPageComponent().isAt();
    }
}
