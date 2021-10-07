package com.jiosaavn.web.springselenium.page.login;

import com.jiosaavn.web.springselenium.kelvin.annotations.Page;
import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.kelvin.service.LoggerService;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@PageFragment
public class LoginPageComponent extends BaseConfig {

    @Autowired
    private LoggerService log;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement email_ib;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password_ib;

    @FindBy(className = "//*[@id=\"recaptcha-anchor\"]/div[1]")
    private WebElement captcha_box;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/main/div/div/div[2]/div/div/div/div/div/section/form/fieldset/div[4]/button")
    private WebElement submit_btn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/header/div/div[2]/aside[2]/div[1]/img")
    private WebElement login_success_icon;

    public void loginWithCredentials(String email, String password){
        this.email_ib.click();
        this.email_ib.sendKeys(email);
        this.password_ib.click();
        this.password_ib.sendKeys(password);
        this.submit_btn.click();
        log.getLogger().info("The user has clicked Submit button");
    }

    public void checkLoginUnsuccessful(){
        this.submit_btn.isDisplayed();
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d) -> this.email_ib.isDisplayed());
    }
}
