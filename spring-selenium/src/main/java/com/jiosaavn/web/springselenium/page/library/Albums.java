package com.jiosaavn.web.springselenium.page.library;

import com.jiosaavn.web.springselenium.kelvin.annotations.Page;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class Albums extends BaseConfig {


   // @FindBy(xpath = "//a[contains(text(),'Albums')]")
    @FindBy(xpath = "//i[@class='o-icon-album o-icon--large u-margin-right-tiny@sm']")
    private WebElement albumText;

    public void openAlbumPageInNewTab() throws InterruptedException {
//        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
//        this.albumText.sendKeys(selectLinkOpeninNewTab);
        this.albumText.click();
        Thread.sleep(1000);
    }



    @Override
    public boolean isAt() {
        return this.webDriverWait.until(d->this.albumText.isDisplayed());
    }
}
