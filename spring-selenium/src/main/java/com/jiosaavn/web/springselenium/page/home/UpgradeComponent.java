package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFragment
public class UpgradeComponent extends BaseConfig {

    @FindBy(xpath = "//*[@id=\"wrapper\"]/header/div[1]/div/ul/li[2]/a")
    private WebElement myAccountBtn;

    public WebElement getMyAccountBtn(){
        return this.myAccountBtn;
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d)->this.myAccountBtn.isDisplayed());
    }
}
