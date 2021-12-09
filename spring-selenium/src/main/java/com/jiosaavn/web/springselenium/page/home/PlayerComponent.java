package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFragment
public class PlayerComponent extends BaseConfig {


    @FindBy(xpath = "//span[@class='o-icon-play o-icon--xlarge']")
    private WebElement playButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/a[1]")
    private WebElement albumTile;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/span[1]")
    private WebElement oneTapPlayButton;

    @FindBy(xpath = "//body/div[@id='root']/div[2]/aside[4]/div[1]/figure[1]/figcaption[1]/h4[1]/a[1]")
    private WebElement playerSongMeta;

    @FindBy (xpath = "(//span[@class='u-visible-visually@lg'])[2]")
    private WebElement songDurationMeta;

    @FindBy(xpath = "//span[@class='u-centi u-valign-text-bottom u-padding-horizontal-small@sm']")
    private WebElement songTimerOnPlayerElement;

    public void clickPlayButton() throws InterruptedException {
        oneTapPlayButton.click();
        Thread.sleep(10000);
    }
    public void clickSongMetaOnPlayer() throws InterruptedException {
        playerSongMeta.click();
        Thread.sleep(5000);
    }
    public void getSongDuration(){

        String songDurationMentionedOnAlbum = songDurationMeta.getText();
        System.out.println("Value=" +songDurationMeta.getText());
        //System.out.println("Attribute " +songDurationMeta.);
        String durationString= songDurationMeta.getText().replaceAll("[A-Za-z ·]", "");
        System.out.println("duration22 "+durationString);
        // Get song timer displayed on player
       String songTimer= songTimerOnPlayerElement.getText();
        System.out.println("Song timer "+songTimer);
        String timerArray[] =songTimer.split("/");
        String currentTimeOnPlayer=timerArray[0].trim();
        String songRunTimeOnPlayer=timerArray[1].trim();
        System.out.println("current time "+currentTimeOnPlayer +" and runtime "+songRunTimeOnPlayer);



    }


    @Override
    public boolean isAt() {
        return false;
    }
}
