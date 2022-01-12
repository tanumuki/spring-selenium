package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFragment
public class HPComponent extends BaseConfig {

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/footer/div[1]/p")
    private WebElement pageFooter;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/header/div/div[1]/nav/ul/li[1]/a")
    private WebElement homeHeading;

    public WebElement getPageFooter(){
        return this.pageFooter;
    }

    public void scrollTillTheEndOfPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",this.pageFooter);
        Thread.sleep(2000);
    }
    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d)->this.homeHeading.isDisplayed());
    }
}
