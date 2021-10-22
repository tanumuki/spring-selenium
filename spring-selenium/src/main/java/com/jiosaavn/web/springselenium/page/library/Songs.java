package com.jiosaavn.web.springselenium.page.library;

import com.jiosaavn.web.springselenium.kelvin.annotations.Page;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class Songs extends BaseConfig {

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/aside[2]/nav[1]/ul[1]/li[2]/a[1]")
    private WebElement songText;


    public void openSongsPageInNewTab(){
//        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
//        this.songText.sendKeys(selectLinkOpeninNewTab);
        this.songText.click();
    }


    @Override
    public boolean isAt() {
        return this.webDriverWait.until(d->this.songText.isDisplayed());
    }
}
