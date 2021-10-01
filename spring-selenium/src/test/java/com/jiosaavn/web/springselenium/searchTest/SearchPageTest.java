package com.jiosaavn.web.springselenium.searchTest;

import com.jiosaavn.web.springselenium.SpringBaseTestNGTest;
import com.jiosaavn.web.springselenium.page.home.HomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTest extends SpringBaseTestNGTest {


    @Autowired
    private HomePage homePage;


    @Test
    public void searchModuleTest(){

        this.homePage.goTo();
        this.homePage.maximizeScreen();
        this.homePage.getAlertComponent().acceptCookie();
        this.homePage.getSearchComponent()
        this.homePage.getAlertComponent().acceptAlertToast();
        Assert.assertTrue(this.homePage.isAt());
        this.homePage.getSearchComponent().search("sanam");

    }
}
