package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PageFragment
public class LoginModalComponent extends BaseConfig {

    private static final Logger logger = LoggerFactory.getLogger(LoginModalComponent.class);


    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/aside[3]/div/div[1]/aside/form/div[1]/h3")
    public WebElement welcomeJiosaavnText;

    public WebElement getWelcomeJiosaavnText(){
        return this.welcomeJiosaavnText;
    }
    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d)->this.welcomeJiosaavnText.isDisplayed());
    }
}
