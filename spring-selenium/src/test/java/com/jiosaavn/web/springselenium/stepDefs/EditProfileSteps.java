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
import org.testng.Assert;


public class EditProfileSteps extends SpringBaseTestNGTest {

    @Autowired
    private UserProfileUpdate userProfileUpdate;
    @Autowired
    private HomePageLogin homePageLogin;


    @Given("^I am on edit profile screen$")
    public void launchSite() throws Throwable {

            //userProfileUpdate.u
            userProfileUpdate.goTo();
            Assert.assertTrue(userProfileUpdate.isAt());
    }

//    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
//    public void enterCredentials(String firstName, String lastName) throws Throwable {
//        userProfileUpdate.setNames(firstName, lastName);
//
//
//    }

    @When("I enter credentials {string} {string} and {string}")
    public void iEnterCredentialsAnd(String arg0, String arg1, String arg2) {
        System.out.println("enter creds");

    }

//    @And("I enter email as {string}")
//    public void iEnterEmailAs(String email) {
//        this.userProfileUpdate.setEmail(email);
//
//    }

    @Then("^I click submit button$")
    public void clickSubmit() throws Throwable {
        this.userProfileUpdate.submit();

    }


}
