package com.jiosaavn.web.springselenium.stepDefs;

import com.jiosaavn.web.springselenium.page.home.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class HPBeforeLoginSteps {

    @Autowired
    private HomePage homePage;

    SoftAssert sa;

    @When("I click on + New Playlist button")
    public void iClickOnButton() {
        this.homePage.getLibraryComponent().clickNewPlaylist();
    }

    @Then("I get the login modal popup")
    public void iGetTheLoginModalPopup() {
        sa = new SoftAssert();
        this.homePage.getLoginModalComponent().isAt();
        String text = this.homePage.getLoginModalComponent().getWelcomeJiosaavnText().getText();
        sa.assertEquals(text, "Welcome to Jiosaavn.", "The texts don't match.");
    }

    @When("I click on {string} button")
    public void iClickOnHistoryButton(String btn) {
        
//        this.homePage.getLibraryComponent().clickHistoryButton();
    }

    @When("I click on Songs button")
    public void iClickOnSongsButton() {
        this.homePage.getLibraryComponent().clickSongsButton();
    }

    @When("I scroll down till the end of the page")
    public void iScrollDownTillTheEndOfThePage() throws InterruptedException {
        this.homePage.getHpComponent().scrollTillTheEndOfPage();
    }

    @Then("I can see the footer of the page")
    public void iCanSeeTheFooterOfThePage() {
        WebElement footer = this.homePage.getHpComponent().getPageFooter();
        sa = new SoftAssert();
        Assert.assertTrue(footer.isDisplayed(), "The footer is not displayed.");
        System.out.println("Test is complete");
    }
}
