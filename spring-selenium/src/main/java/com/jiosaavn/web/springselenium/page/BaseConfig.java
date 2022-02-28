package com.jiosaavn.web.springselenium.page;

import com.jiosaavn.web.springselenium.kelvin.config.WebDriverWaitConfig;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

public abstract class BaseConfig {




    @Autowired
    public WebDriver driver;

    @Autowired
    protected WebDriverWait webDriverWait;

    @PostConstruct
    private void init(){
        System.out.println("driver is here "+driver);
        PageFactory.initElements(driver,this);
    }








    public abstract boolean isAt();


}
