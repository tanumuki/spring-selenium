package com.jiosaavn.web.springselenium.NonBDDTests.searchTest;

import com.jiosaavn.web.springselenium.SpringBaseTestNGTest;
import com.jiosaavn.web.springselenium.page.home.HomePage;
import com.jiosaavn.web.springselenium.kelvin.service.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchPageTest extends SpringBaseTestNGTest {


    @Autowired
    private HomePage homePage;

    @Lazy
    @Autowired
    private ScreenshotService screenshotUtil;


    @Test
    public void searchModuleTest() throws IOException, InterruptedException {

        this.homePage.goTo();
//        this.homePage.maximizeScreen();
        this.homePage.getAlertComponent().acceptCookie();
        this.homePage.getAlertComponent().waitForAlertToAppear();
        this.homePage.getAlertComponent().closeAlert();
      //  this.homePage.getAlertComponent().waitForAlertToDisappear();
        this.homePage.getSearchComponent().search("sanam");
        this.screenshotUtil.takeScreenShot();
        this.homePage.close();

    }
}
