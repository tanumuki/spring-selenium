package com.jiosaavn.web.springselenium.stepDefs;

import com.jiosaavn.web.springselenium.SpringBaseTestNGTest;
import com.jiosaavn.web.springselenium.kelvin.config.WebDriverWaitConfig;
import com.jiosaavn.web.springselenium.page.EditProfile.UserProfileUpdate;
import com.jiosaavn.web.springselenium.page.login.HomePageLogin;
import com.jiosaavn.web.springselenium.repository.CookiesRepository;
import com.jiosaavn.web.springselenium.repository.UserRepo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;


@CucumberContextConfiguration
public class EditProfileSteps  {

    @Autowired
    private UserProfileUpdate userProfileUpdate;
    @Autowired
    private HomePageLogin homePageLogin;
    @Autowired
    private CookiesRepository cookiesRepository;
    @Autowired
    private WebDriverWaitConfig wait;



    @Given("^I am on edit profile screen$")
    public void launchSite() throws Throwable {
        userProfileUpdate.goTo();


    }

    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterCredentials(String firstName, String lastName) throws Throwable {
//        userProfileUpdate.setNames(firstName, lastName);


    }

    @And("I enter email as {string}")
    public void iEnterEmailAs(String email) {
//        this.userProfileUpdate.setEmail(email);

    }

    @Then("^I click submit button$")
    public void clickSubmit() throws Throwable {
//        this.userProfileUpdate.submit();

    }


//    @Given("I have the cookie for the following user")
//    public void iHaveTheCookieForTheFollowingUser() {
//    }
}
