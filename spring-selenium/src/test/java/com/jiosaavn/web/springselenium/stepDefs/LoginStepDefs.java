package com.jiosaavn.web.springselenium.stepDefs;

import com.jiosaavn.web.springselenium.SpringBaseTestNGTest;
import com.jiosaavn.web.springselenium.kelvin.service.LoggerService;
import com.jiosaavn.web.springselenium.page.login.HomePageLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

@CucumberContextConfiguration
public class LoginStepDefs extends SpringBaseTestNGTest {

    @Autowired
    private LoggerService log;

    @Autowired
    private HomePageLogin homePageLogin;

    @Given("I am on the website")
    public void iAmOnTheWebsite() {
        this.homePageLogin.goTo();
        this.homePageLogin.getAlertComponent().waitForAlertToAppear();
        this.homePageLogin.getAlertComponent().closeAlert();
    }

    @When("I click on Login button")
    public void iClickOnLoginButton() {
        this.homePageLogin.getLandingComponent().login();
        Assert.assertTrue(this.homePageLogin.getLoginPageComponent().isAt());
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
}
