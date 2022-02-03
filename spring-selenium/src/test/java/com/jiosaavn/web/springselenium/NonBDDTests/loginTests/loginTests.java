package com.jiosaavn.web.springselenium.NonBDDTests.loginTests;

import com.jiosaavn.web.springselenium.SpringBaseTestNGTest;
import com.jiosaavn.web.springselenium.page.login.HomePageLogin;
import com.jiosaavn.web.springselenium.kelvin.service.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.PreDestroy;
import java.io.IOException;

public class loginTests extends SpringBaseTestNGTest {

    @Autowired
    private HomePageLogin homePageLogin;

    @Autowired
    private ScreenshotService screenshotUtil;

    @Test
    public void testLoginWithoutCaptcha() throws IOException, InterruptedException {
        this.homePageLogin.goTo();
        System.out.println("It came to landing page");
        this.homePageLogin.getAlertComponent().waitForAlertToAppear();
        this.homePageLogin.getAlertComponent().closeAlert();
        System.out.println("alert is closed");
        this.homePageLogin.getLandingComponent().login();
        System.out.println("It came to login page");
        this.homePageLogin.getLoginPageComponent().loginWithCredentials("testsmdemo@gmail.com", "Saavn1234");
        this.homePageLogin.getLoginPageComponent().checkLoginUnsuccessful();
        Assert.assertTrue(this.homePageLogin.getLoginPageComponent().isAt(), "The user is still at login page.");
        this.screenshotUtil.takeScreenShot();
        logger.info("The test is completed and passed.");
    }

//    @PreDestroy
//    public void closeWindows(){
//        this.homePageLogin.closeBrowsers();
//    }

}
