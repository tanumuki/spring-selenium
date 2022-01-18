package com.jiosaavn.web.springselenium.stepDefs;

import com.jiosaavn.web.springselenium.page.home.HomePage;
import com.jiosaavn.web.springselenium.page.login.HomePageLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerTests {

    @Autowired
    private HomePage homePage;

    @Autowired
    private HomePageLogin homePageLogin;



    @And("^I click a song$")
    public void i_click_a_song() throws Throwable {

        //Go to login page
        homePageLogin.goToLoginPage();
        Thread.sleep(3000);

        /*
        Player test cases flow are commented here just to check the captcha bypass flow
         */

//        System.out.println("clicking play button");
//        this.homePage.getPlayerComponent().clickPlayButton();
//        System.out.println(" play button clicked");
//        this.homePage.getPlayerComponent().clickSongMetaOnPlayer();
//        System.out.println("meta");
//        this.homePage.getPlayerComponent().getSongDuration();
//        this.homePage.getPlayerComponent().verifySongProgress();
//        this.homePage.getPlayerComponent().verifyPlayerControls();

    }



}
