package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

@PageFragment
public class HPComponent extends BaseConfig {

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/footer/div[1]/p")
    private WebElement pageFooter;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/header/div/div[1]/nav/ul/li[1]/a")
    private WebElement homeHeading;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/header/div/div[1]/nav/ul/li[3]/span")
    private WebElement upgradeBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/header/div/div[1]/nav/ul/li[2]/a")
    private WebElement browseBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/aside[3]/div[1]/ul[1]/li[1]/span")
    private WebElement timestamp;

    public void scrollTillTheEndOfPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",this.pageFooter);
        Thread.sleep(2000);
    }

    public WebElement getUpgradeBtn(){ return this.upgradeBtn; }

    public WebElement getHomeHeading() { return homeHeading; }

    public WebElement getBrowseBtn() { return browseBtn; }

    public WebElement getPageFooter(){
        return this.pageFooter;
    }

    public WebElement getTimestamp() { return timestamp; }

    public void handleNewTab(){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d)->this.homeHeading.isDisplayed());
    }
}
