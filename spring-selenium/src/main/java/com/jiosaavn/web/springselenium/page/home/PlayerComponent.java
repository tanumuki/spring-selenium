package com.jiosaavn.web.springselenium.page.home;

import com.google.common.util.concurrent.Uninterruptibles;
import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.kelvin.config.Util;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Pattern;

@PageFragment
public class PlayerComponent extends BaseConfig {



    @FindBy(xpath = "//span[@class='o-icon-play o-icon--xlarge']")
    private WebElement playButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/a[1]")
    private WebElement albumTile;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/span[1]")
    private WebElement oneTapPlayButton;

    @FindBy(xpath = "//body/div[@id='root']/div[2]/aside[3]/div[1]/figure[1]/figcaption[1]/h4[1]/a[1]")
    private WebElement playerSongMeta;

    @FindBy (xpath = "(//span[@class='u-visible-visually@lg'])[2]")
    private WebElement songDurationMeta;

    @FindBy(xpath = "//span[@class='u-centi u-valign-text-bottom u-padding-horizontal-small@sm']")
    private WebElement songTimerOnPlayerElement;

    @FindBy(xpath = "//div[@class='c-progress__seek']")
    private WebElement scrubberElement;

    @FindBy(xpath = "//span[@class='o-icon-pause o-icon--xlarge']")
    private WebElement pauseButton;
    @FindBy(xpath = "//body[1]/div[1]/div[2]/aside[3]/div[1]/ul[2]/li[3]/span[1]")
    private WebElement pauseButton2;


    @FindBy(xpath = "//body/div[@id='root']/div[2]/aside[4]/div[1]/ul[2]/li[3]/span[1]")
    private WebElement plButton;


    @FindBy(xpath = "//span[@class='o-icon-next o-icon--xlarge']")
    private WebElement nextButton;

//    @FindBy(xpath = "//body/div[@id='root']/div[2]/aside[4]/div[1]/ul[2]/li[4]/span[1]")
//    private WebElement nextButton;

    @FindBy(xpath = "//figure[@class='c-player__current o-flag o-flag--small o-flag--mini o-flag--thumbnail@lg']/figcaption/h4/a")
    private WebElement songNameDisplayedOnPlayer;

    public void clickPlayButton() throws InterruptedException {
        oneTapPlayButton.click();
        System.out.println("one tap play button clicked");
        Thread.sleep(1000);
    }
    public void clickSongMetaOnPlayer() throws InterruptedException {
        System.out.println("inside click song meta player");


        this.webDriverWait.until(ExpectedConditions.visibilityOf(playerSongMeta));
        playerSongMeta.click();
        Thread.sleep(2000);
        System.out.println("player song meta clicked");
    }
    public void getSongDuration(){

        /*
        Get the song duration displayed on the album metadata and the duration on the player info and compare. It should be equal
         */

        String songDurationMentionedOnAlbum = songDurationMeta.getText();
        System.out.println("Value=" +songDurationMeta.getText());
        //System.out.println("Attribute " +songDurationMeta.);
        String durationString= songDurationMeta.getText().replaceAll("[A-Za-z ·]", "");
        System.out.println("duration22 "+durationString);
        // Get song timer displayed on player
        String songTimer= songTimerOnPlayerElement.getText();
        // songTimerOnPlayerElement.getAttribute()
        System.out.println("Song timer "+songTimer);
        String timerArray[] =songTimer.split("/");
        String currentTimeOnPlayer=timerArray[0].trim();
        String songRunTimeOnPlayer=timerArray[1].trim();
        Assert.assertEquals(durationString,songRunTimeOnPlayer, "The runtimes displayed on the album meta and player element aren't equal");
        System.out.println("current time "+currentTimeOnPlayer +" and runtime "+songRunTimeOnPlayer);

    }


    public void verifySongProgress() throws InterruptedException {

        /*
        Verify the song progress by taking values from the DOM's style attribute. Those values are basically pixels of placement of the scrubber.
        We attribute the value of the style CSS attribute to a variable of type String called firstStyle.
        We wait a certain period of time, in this case two seconds.
        We then attribute the new, hopefully changed value of the style attribute to another variable called secondStyle.
        We then make an assertion that the two Strings are not equal. I also add a third argument to the assertNotEquals method, in the form of a message that will be displayed if the two strings are actually equal, to help when failing.
         */

        String firstStyle = scrubberElement.getAttribute("style");
        System.out.println("First style "+firstStyle);
        Thread.sleep(2000);
        String secondStyle = scrubberElement.getAttribute("style");
        System.out.println("Second style "+secondStyle);
        Assert.assertNotEquals(firstStyle, secondStyle, "There are no differences in the two styles");

        /*
        Verify the pause button after waiting for some seconds
         */
        Thread.sleep(5000);
        pauseButton.click();
        System.out.println("pause button clicked");


        firstStyle = scrubberElement.getAttribute("style");
        System.out.println("First style "+firstStyle);
        Thread.sleep(2000);
        secondStyle = scrubberElement.getAttribute("style");
        System.out.println("Second style "+secondStyle);
        Assert.assertEquals(firstStyle, secondStyle, "There are differences in the two styles");
        //Resetting it to play
        Thread.sleep(5000);
        playButton.click();
        System.out.println("play clicked again");
        Thread.sleep(3000);


    }

    public void verifyPlayerControls() throws InterruptedException {

        String nextSong="";
        String songNameCurrentPlaying=  songNameDisplayedOnPlayer.getAttribute("title");
        System.out.println("Song currently playing: "+songNameCurrentPlaying);
        this.webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        this.nextButton.click();
        // Thread.sleep(15000);
        Uninterruptibles.sleepUninterruptibly(15000, TimeUnit.MILLISECONDS);

        System.out.println("clicked next button");
        WebDriverWait wait=new WebDriverWait(driver, 30);
        String pattern="0:06 / 4:13";
        // wait.until(ExpectedConditions.textToBePresentInElement(songNameCurrentPlaying, Pattern.compile(pattern));
        nextSong=  songNameDisplayedOnPlayer.getAttribute("title");
            /*
            Using Thread.sleep for introducing a pause of few seconds
             */

        System.out.println("Next song playing:  "+nextSong);
        Assert.assertNotEquals(songNameCurrentPlaying, nextSong, "Both songs are same, ");

    }


    @Override
    public boolean isAt() {
        return false;
    }
}
