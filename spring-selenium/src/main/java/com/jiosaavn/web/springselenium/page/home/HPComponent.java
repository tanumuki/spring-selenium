package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

@PageFragment
public class HPComponent extends BaseConfig {

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/footer/div[1]/p")
    private WebElement pageFooter;

//    @FindBy(xpath = "//a[@class='c-logo active']")
    @FindBy(xpath = "//a[@title='Logo Button']")
    private WebElement homeHeading;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/header/div/div[1]/nav/ul/li[3]/span")
    private WebElement upgradeBtn;

//    @FindBy(xpath = "//a[@title='Browse']")
    @FindBy(linkText = "Browse")
    private WebElement browseBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/aside[3]/div[1]/ul[1]/li[1]/span")
    private WebElement timestamp;

    @FindBy(xpath = "//div[@class='c-dropdown__header user-profile-menu']")
    private WebElement headerUserMenu;

    @FindBy(className = "//li[@class='c-drop c-drop--list']")
    private List<WebElement> playlistList;

    public void scrollTillTheEndOfPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",this.pageFooter);
        Thread.sleep(2000);
    }

    public WebElement getUpgradeBtn(){ return this.upgradeBtn; }

    public WebElement getHomeHeading() { return this.homeHeading; }

    public WebElement getBrowseBtn() { return this.browseBtn; }

    public WebElement getPageFooter(){
        return this.pageFooter;
    }

    public WebElement getTimestamp() { return this.timestamp; }

    public WebElement getHeaderUserMenu(){
        return this.headerUserMenu;
    }

    public List<WebElement> getPlaylistList() throws InterruptedException {
        Thread.sleep(10000);
        this.driver.navigate().refresh();
//        new WebDriverWait(driver, 10).until(ExpectedConditions.fr(this.playlistList));
        System.out.println("size of playlist "+ this.playlistList.size());
        return this.playlistList; }

    public void clickHeaderUserMenu(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", this.headerUserMenu);
    }

    public void handleNewTab(){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d)->this.homeHeading.isDisplayed());
    }
}
