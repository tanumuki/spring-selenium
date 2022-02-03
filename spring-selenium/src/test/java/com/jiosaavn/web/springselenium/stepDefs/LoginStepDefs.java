package com.jiosaavn.web.springselenium.stepDefs;

import com.jiosaavn.web.springselenium.SpringBaseTestNGTest;
import com.jiosaavn.web.springselenium.kelvin.service.LoggerService;
import com.jiosaavn.web.springselenium.page.home.HomePage;
import com.jiosaavn.web.springselenium.page.login.HomePageLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

@CucumberContextConfiguration
public class LoginStepDefs extends SpringBaseTestNGTest {

    @Autowired
    private LoggerService log;

    @Autowired
    private HomePageLogin homePageLogin;

    @Autowired
    private HomePage homePage;

    SoftAssert sa;

    @Given("I am on the website")
    public void iAmOnTheWebsite() throws InterruptedException {
        //with captcha flow
        this.homePageLogin.goTo();
        //For blocking captcha flow
        //this.homePageLogin.goToLoginPage();
//        this.homePageLogin.getAlertComponent().waitForAlertToAppear();
//        this.homePageLogin.getAlertComponent().closeAlert();
        this.homePageLogin.maximizeScreen();
    }

    @When("I click on Login button")
    public void iClickOnLoginButton() throws InterruptedException {
//        this.homePageLogin.getLandingComponent().login();
        this.homePageLogin.goToLoginPage();
        Thread.sleep(3000);
    }

    @And("I login with the credentials {string} and {string} without solving captcha")
    public void iLoginWithTheCredentialsAndWithoutSolvingCaptcha(String email, String password) {
        this.homePageLogin.getLoginPageComponent().loginWithCredentials(email,password);
    }

    @Then("I should not be able to login")
    public void iShouldNotBeAbleToLogin() {
        this.homePageLogin.getLoginPageComponent().checkLoginUnsuccessful();
        Assert.assertTrue(this.homePageLogin.isAt());
        log.getLogger().info("Homepage login without captcha is validated");
    }

    @And("I enter email {string} and password {string}")
    public void iEnterEmailAndPassword(String email, String password) {
        this.homePageLogin.getLoginPageComponent().loginWithCredentials(email, password);
    }


    @Then("I verify that I am logged in")
    public void iVerifyThatIAmLoggedIn() throws InterruptedException {
        Boolean status = this.homePageLogin.getHpComponent().getHomeHeading().isDisplayed();
        sa = new SoftAssert();
        Thread.sleep(1000);
        sa.assertEquals(String.valueOf(status), true, "The logged in icon is not displayed.");
    }

    @When("I click on Login button without disabling captcha")
    public void iClickOnLoginButtonWithoutDisablingCaptcha() {
        this.homePageLogin.getLoginPageComponent().clickLoginButton();
    }

    @Then("I click on header user menu button")
    public void iClickOnHeaderUserMenuButton() throws InterruptedException {
        if(this.homePageLogin.getHpComponent().getHeaderUserMenu().isEnabled()) {
            this.homePageLogin.getHpComponent().getHeaderUserMenu().click();
        }
        Thread.sleep(3000);
        this.homePageLogin.getHpComponent().isAt();
    }

    @And("I try to create a new playlist")
    public void iTryToCreateANewPlaylist() throws InterruptedException {
        if(this.homePageLogin.getLibraryComponent().getNewPlaylist().isEnabled()) {
            this.homePageLogin.getLibraryComponent().getNewPlaylist().click();
        }
        this.homePageLogin.getCreatePlaylistComponent().createPlaylist();
        System.out.println("is empty " + this.homePageLogin.getHpComponent().getPlaylistList().isEmpty());
        Assert.assertFalse(this.homePageLogin.getHpComponent().getPlaylistList().isEmpty(), "There are no new playlist");
    }
}
