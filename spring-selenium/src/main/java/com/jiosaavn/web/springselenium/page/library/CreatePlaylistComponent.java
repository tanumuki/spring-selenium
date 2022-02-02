package com.jiosaavn.web.springselenium.page.library;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@PageFragment
public class CreatePlaylistComponent extends BaseConfig {


    @FindBy(name = "playlist-name")
    private WebElement playlistNameIB;

    @FindBy(xpath = "//button[@class=\"c-btn c-btn--primary c-btn--large c-btn--wide\"]")
    private WebElement playlistSaveBtn;

    @FindBy(xpath = "//span[@class=\"c-modal__close\"]")
    private WebElement cancelBtn;

    public void createPlaylist(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(this.playlistNameIB));
        this.playlistNameIB.click();
        String random = RandomStringUtils.randomAlphanumeric(5).toUpperCase();
        this.playlistNameIB.sendKeys(random);
        this.playlistSaveBtn.click();
    }
    @Override
    public boolean isAt() {
        return false;
    }
}
