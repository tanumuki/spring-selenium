package com.jiosaavn.web.springselenium.page.login;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@PageFragment
public class LandingComponent extends BaseConfig {

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/header/div/div[2]/nav/ul/li[1]/a")
    private WebElement login_btn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/aside[3]/div/div[1]/div/span")
    private WebElement play_now_btn;

    @FindBy(xpath = "/aside/div/div[2]/span")
    private WebElement dismiss_btn;

    @FindBy(xpath = "//*[@id='root']/div[2]/aside[2]/div/span")
    private WebElement newPlaylist;

    public void login(){
//        if(this.play_now_btn.isDisplayed()){
//            System.out.println(play_now_btn+" is displayed");
//            this.dismiss_btn.click();
//        }
        this.login_btn.click();
    }

    public void switchTab2(){
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    public void clickPlaylistBtn(){
        this.newPlaylist.click();
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d) -> this.login_btn.isDisplayed());
    }


}
