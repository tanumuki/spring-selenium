package com.jiosaavn.web.springselenium.stepDefs;

import com.jiosaavn.web.springselenium.kelvin.service.LoggerService;
import com.jiosaavn.web.springselenium.page.home.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class SearchStepDefs {

    String keyword;

    @Autowired
    private LoggerService log;

    @Autowired
    private HomePage homePage;

    @When("I accept all the cookies and alert toast")
    public void iAcceptAllTheCookiesAndAlertToast() throws InterruptedException {
        this.homePage.getAlertComponent().maximizeScreen();
    }

    @And("I search with the keyword {string}")
    public void iSearchWithTheKeyword(String searchKeyword) {
        this.homePage.getSearchComponent().search(searchKeyword);
        this.keyword = searchKeyword;
    }

    @Then("The search grid should appear")
    public void theSearchGridShouldAppear() {
        Assert.assertTrue(this.homePage.getSearchComponent().isAt());
        log.getLogger().info("Search is validated for keyword: "+this.keyword);

    }
}
