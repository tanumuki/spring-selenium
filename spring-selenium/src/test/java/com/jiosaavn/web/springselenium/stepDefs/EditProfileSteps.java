package com.jiosaavn.web.springselenium.stepDefs;

import com.jiosaavn.web.springselenium.SpringBaseTestNGTest;
import com.jiosaavn.web.springselenium.page.EditProfile.UserProfileUpdate;
import com.jiosaavn.web.springselenium.page.login.HomePageLogin;
import com.jiosaavn.web.springselenium.repository.UserRepo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberContextConfiguration
public class EditProfileSteps extends SpringBaseTestNGTest {

    @Autowired
    private UserProfileUpdate userProfileUpdate;
    @Autowired
    private HomePageLogin homePageLogin;


    @Given("^I am on edit profile screen$")
    public void launchSite() throws Throwable {

            userProfileUpdate.goTo();
            Assert.assertTrue(userProfileUpdate.isAt());
    }

    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterCredentials(String firstName, String lastName) throws Throwable {
        userProfileUpdate.setNames(firstName, lastName);


    }

    @And("I enter email as {string}")
    public void iEnterEmailAs(String email) {
        this.userProfileUpdate.setEmail(email);

    }

    @Then("^I click submit button$")
    public void clickSubmit() throws Throwable {
        this.userProfileUpdate.submit();

    }



}