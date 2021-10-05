package com.jiosaavn.web.springselenium.page.login;

import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class LoginResultComponent extends BaseConfig {

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/header/div/div[2]/aside[2]/div[1]/img")
    private WebElement login_success_icon;

    public void success_login(){
        this.login_success_icon.isDisplayed();
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d) -> this.login_success_icon.isDisplayed());
    }
}
