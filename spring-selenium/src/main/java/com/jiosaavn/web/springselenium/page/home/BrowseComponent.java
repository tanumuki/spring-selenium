package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class BrowseComponent extends BaseConfig {

    @FindBy(className = "c-nav__item")
    private List<WebElement> entitiesList;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/div/main/nav[1]/ul/li[7]/span")
    private WebElement surpriseBtn;

    public List<WebElement> getEntitiesList(){ return entitiesList; }

    public WebElement getSurpriseBtn(){ return surpriseBtn; }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d)->this.surpriseBtn.isDisplayed());
    }
}
