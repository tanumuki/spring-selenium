package com.jiosaavn.web.springselenium.stepDefs;

import com.jiosaavn.web.springselenium.kelvin.service.LocatorActionService;
import com.jiosaavn.web.springselenium.kelvin.service.ScreenshotService;
import com.jiosaavn.web.springselenium.page.home.HomePage;
import com.jiosaavn.web.springselenium.page.home.UpgradePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.io.IOException;

public class HPBeforeLoginSteps extends LocatorActionService{

    @Autowired
    private HomePage homePage;

    @Autowired
    private UpgradePage upgradePageDriver;

    @Autowired
    private LocatorActionService actionService;

    @Autowired
    private ScreenshotService ss;

    SoftAssert sa;

    @When("I click on + New Playlist button")
    public void iClickOnButton() {
        clickElement(this.homePage.getLibraryComponent().getNewPlaylist());
    }

    @Then("I get the login modal popup")
    public void iGetTheLoginModalPopup() {
        sa = new SoftAssert();
        this.homePage.getLoginModalComponent().isAt();
        String text = getElementText(this.homePage.getLoginModalComponent().getWelcomeJiosaavnText());
        sa.assertEquals(text, "Welcome to Jiosaavn.", "The texts don't match.");
    }

    @When("I click on Songs button")
    public void iClickOnSongsButton() {
        clickElement(this.homePage.getLibraryComponent().getSongsButton());
    }

    @When("I scroll down till the end of the page")
    public void iScrollDownTillTheEndOfThePage() throws InterruptedException {
        this.homePage.getHpComponent().scrollTillTheEndOfPage();
    }

    @Then("I can see the footer of the page")
    public void iCanSeeTheFooterOfThePage() {
        WebElement footer = this.homePage.getHpComponent().getPageFooter();
        sa = new SoftAssert();
        Assert.assertTrue(isElementDisplayed(footer), "The footer is not displayed.");
        System.out.println("Test is complete");
    }

    @When("I click on Upgrade button")
    public void iClickOnUpgradeButton() throws InterruptedException {
        clickElement(this.homePage.getHpComponent().getUpgradeBtn());
        System.out.println("clicked upgrade");
        Thread.sleep(9000);
    }

    @Then("I can verify that new page opens on another tab")
    public void iCanVerifyThatNewPageOpensOnAnotherTab() throws IOException {
        this.homePage.getHpComponent().handleNewTab();
        Boolean status = isElementDisplayed(this.upgradePageDriver.getUpgradeComponent().getMyAccountBtn());
        sa = new SoftAssert();
        sa.assertTrue(status, "My Account button is not displayed.");
        ss.takeScreenShot();
    }

    @When("I click on Browse button")
    public void iClickOnBrowseButton() {
        clickElement(this.homePage.getHpComponent().getBrowseBtn());
    }

    @Then("I can verify that the browse page opens on the website")
    public void iCanVerifyThatTheBrowsePageOpensOnTheWebsite() {
        sa = new SoftAssert();
       sa.assertTrue(isElementDisplayed(this.homePage.getBrowseComponent().getSurpriseBtn()), "The surprise button is not present.");

    }

    @And("I click on Surprise button button")
    public void iClickOnSurpriseButton() throws InterruptedException {
        clickElement(this.homePage.getBrowseComponent().getSurpriseBtn());
        Thread.sleep(3000);
    }

    @Then("The player should start playing a song")
    public void thePlayerShouldStartPlayingASong() {
        sa = new SoftAssert();
        sa.assertTrue(isElementDisplayed(this.homePage.getBrowseComponent().getTimestamp()), "Timestamp is not present");
    }
}
