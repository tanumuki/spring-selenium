package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@PageFragment
public class BrowseComponent extends BaseConfig {

    @FindBy(className = "c-nav__item")
    private List<WebElement> entitiesList;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/div/main/nav[1]/ul/li[7]/span")
    private WebElement surpriseBtn;

    @FindBy(xpath = "//span[@class='u-centi u-valign-text-bottom u-padding-horizontal-small@sm']")
    private WebElement timestamp;

    public List<WebElement> getEntitiesList(){ return entitiesList; }

    public WebElement getSurpriseBtn(){ return surpriseBtn; }

    public WebElement getTimestamp(){
        System.out.println("it is timestamp");
//        WebElement we = this.webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("c-btn c-btn--primary c-btn--ghost c-btn--small c-btn--thick c-btn-modal")));
//        System.out.println("it waited for the element");
//        System.out.println(we.isDisplayed());
        return this.timestamp;
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d)->this.surpriseBtn.isDisplayed());
    }
}
