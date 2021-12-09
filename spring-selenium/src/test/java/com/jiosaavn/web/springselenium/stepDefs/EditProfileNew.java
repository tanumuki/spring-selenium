package com.jiosaavn.web.springselenium.stepDefs;

import com.jiosaavn.web.springselenium.kelvin.config.WebDriverWaitConfig;
import com.jiosaavn.web.springselenium.page.EditProfile.UserProfileUpdate;
import com.jiosaavn.web.springselenium.page.login.HomePageLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class EditProfileNew {

    @Autowired
    private HomePageLogin homePageLogin;
    @Autowired
    private UserProfileUpdate userProfileUpdate;
    @Autowired
    private WebDriverWaitConfig webDriverWaitConfig;

    @Given("I am on edit profile page")
    public void i_am_on_edit_profile_page() {
        homePageLogin.goToLoginPage();
    }
    @When("I set the cookie")
    public void i_set_the_cookie() throws InterruptedException {
       // new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

        homePageLogin.getCaptchaComponent().clickCaptchaBox();
        Thread.sleep(2000);

        //userProfileUpdate.addCookies();
        //userProfileUpdate.goTo();
        System.out.println("refresh!");
    }
    @Then("I refresh the screen")
    public void i_refresh_the_screen() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
