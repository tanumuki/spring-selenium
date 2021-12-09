package com.jiosaavn.web.springselenium.stepDefs;

import com.jiosaavn.web.springselenium.page.home.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerTests {

    @Autowired
    private HomePage homePage;



    @And("^I click a song$")
    public void i_click_a_song() throws Throwable {

        System.out.println("clicking play button");
        this.homePage.getPlayerComponent().clickPlayButton();
        System.out.println(" play button clicked");
        this.homePage.getPlayerComponent().clickSongMetaOnPlayer();
        System.out.println("meta");
        this.homePage.getPlayerComponent().getSongDuration();

    }



}
