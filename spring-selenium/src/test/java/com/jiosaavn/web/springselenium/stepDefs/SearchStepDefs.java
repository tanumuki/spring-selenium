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
//        this.homePage.getAlertComponent().waitForAlertToAppear();
//        System.out.println("it got the alert");
//        this.homePage.getAlertComponent().closeAlert();
//        System.out.println("closed the alert");
//        this.homePage.getAlertComponent().maximizeScreen();
//        this.homePage.goTo();
//        this.homePage.getAlertComponent().waitForAlertToAppear();
//        this.homePage.getAlertComponent().closeAlert();
    }

    @And("I search with the keyword {string}")
    public void iSearchWithTheKeyword(String searchKeyword) throws InterruptedException {
        this.homePage.getSearchComponent().search(searchKeyword);
        this.keyword = searchKeyword;
    }

    @Then("The search grid should appear")
    public void theSearchGridShouldAppear() {
        Assert.assertTrue(this.homePage.getSearchComponent().isAt());
        log.getLogger().info("Search is validated for keyword: "+this.keyword);

    }

    @And("I randomly clicked on View All of any facet")
    public void iRandomlyClickedOnViewAllOfAnyFacet() throws InterruptedException {
        Thread.sleep(2000);
        this.homePage.getSearchComponent().searchResultsFromViewAll();
    }

    @Then("I verify the search results of the keyword with {string}")
    public void iVerifyTheSearchResultsOfTheKeywordWith(String searchResultText) {
        this.homePage.getSearchResultComponent().isAt();
        String completeSearchResultText = this.homePage.getSearchResultComponent().getSearchResultText();
        Assert.assertTrue(completeSearchResultText.contains(this.keyword), "The texts don't match");
    }
}

