package com.jiosaavn.web.springselenium.searchTest;

import com.jiosaavn.web.springselenium.SpringBaseTestNGTest;
import com.jiosaavn.web.springselenium.page.home.HomePage;
import com.jiosaavn.web.springselenium.util.ScreenshotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchPageTest extends SpringBaseTestNGTest {


    @Autowired
    private HomePage homePage;

    @Lazy
    @Autowired
    private ScreenshotUtil screenshotUtil;


    @Test
    public void searchModuleTest() throws IOException {

        this.homePage.goTo();
        this.homePage.maximizeScreen();
        this.homePage.getAlertComponent().acceptCookie();
        this.homePage.getAlertComponent().waitForAlertToAppear();
        this.homePage.getAlertComponent().closeAlert();
        System.out.println("yoyoy 1");
      //  this.homePage.getAlertComponent().waitForAlertToDisappear();
        System.out.println("yoyoy M");
        this.screenshotUtil.takeScreenshot();
        this.homePage.getSearchComponent().search("sanam");

    }
}
