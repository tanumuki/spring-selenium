package com.jiosaavn.web.springselenium.page.login;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import com.jiosaavn.web.springselenium.page.home.AlertComponent;
import com.jiosaavn.web.springselenium.page.home.CaptchaComponent;
import com.jiosaavn.web.springselenium.page.home.HPComponent;
import com.jiosaavn.web.springselenium.page.home.LibraryComponent;
import com.jiosaavn.web.springselenium.page.library.CreatePlaylistComponent;
import com.jiosaavn.web.springselenium.page.search.SearchComponent;
import org.openqa.selenium.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@PageFragment
public class HomePageLogin extends BaseConfig {

    @Autowired
    protected LandingComponent landingComponent;

    @Autowired
    protected LoginPageComponent loginPageComponent;

    @Autowired
    protected AlertComponent alertComponent;

    @Autowired
    protected CaptchaComponent captchaComponent;

    @Autowired
    protected HPComponent hpComponent;

    @Autowired
    protected SearchComponent searchComponent;

    @Autowired
    protected CreatePlaylistComponent createPlaylistComponent;

    @Autowired
    protected LibraryComponent libraryComponent;

    @Value("${application.url: https://staging.jiosaavn.com}")
    private String application_url;

    public void goTo(){
        System.out.println("Opening extension");
        System.out.println("Refresh successfully");
        this.driver.get(application_url);
        System.out.println("opened "+application_url);
    }
    public void goToLoginPage(){
        this.driver.get(application_url);
        loginPageComponent.clickLoginButton();
        this.driver.manage().addCookie(new Cookie("captcha-bypass" ,"6R1VzqByL1WCfSfTwiUcRWqO2YcftgB1u4"));
        this.driver.navigate().refresh();
    }

    public void maximizeScreen(){ this.driver.manage().window().maximize();}

    public LandingComponent getLandingComponent(){
        return landingComponent;
    }

    public LoginPageComponent getLoginPageComponent(){
        return loginPageComponent;
    }

    public AlertComponent getAlertComponent(){
        return alertComponent;
    }

    public CaptchaComponent getCaptchaComponent(){
        return captchaComponent;
    }

    public HPComponent getHpComponent(){ return hpComponent; }

    public SearchComponent getSearchComponent(){ return searchComponent; }

    public CreatePlaylistComponent getCreatePlaylistComponent(){ return createPlaylistComponent; }

    public LibraryComponent getLibraryComponent(){ return libraryComponent; }

    @PreDestroy
    public void closeBrowsers(){
        driver.close();
    }

    @Override
    public boolean isAt() {
        return this.getLoginPageComponent().isAt();
    }
}
