package com.jiosaavn.web.springselenium.page.login;

import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class LoginPageComponent extends BaseConfig {

    @FindBy(name = "email")
    private WebElement email_ib;

    @FindBy(name = "password")
    private WebElement password_ib;

    @FindBy(className = "//*[@id=\"recaptcha-anchor\"]/div[1]")
    private WebElement captcha_box;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/main/div/div/div[2]/div/div/div/div/div/section/form/fieldset/div[4]/button")
    private WebElement submit_btn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/header/div/div[2]/aside[2]/div[1]/img")
    private WebElement login_success_icon;

    public void loginWithCredentials(String email, String password){
        this.email_ib.sendKeys(Keys.TAB);
        this.email_ib.sendKeys(email);
        this.password_ib.sendKeys(Keys.TAB);
        this.password_ib.sendKeys(password);
        this.submit_btn.click();
    }

    public void checkLoginUnsuccessful(){
        this.submit_btn.isDisplayed();
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d) -> this.submit_btn.isDisplayed());
    }
}
