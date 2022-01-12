package com.jiosaavn.web.springselenium.page;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

public abstract class BaseConfig {




    @Autowired
     protected WebDriver driver;

    @Autowired
   protected WebDriverWait webDriverWait;

    @PostConstruct
    private void init(){
//        BrowserMobProxy proxy = new BrowserMobProxyServer();
//        proxy.start(0);
//        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//
//        // put our custom header to each request
//        proxy.addRequestFilter((response, contents, messageInfo)->{
//            response.headers().add("captcha-bypass", "6R1VzqByL1WCfSfTwiUcRWqO2YcftgB1u4");
//            System.out.println(response.headers().entries().toString());
//            return null;
//        });
//
//        // Setting up Proxy for chrome
//        ChromeOptions opts = new ChromeOptions();
//        String proxyOption = "--proxy-server=" + seleniumProxy.getHttpProxy();
//        System.out.println(seleniumProxy.getHttpProxy()+"is the http proxy");
//        opts.addArguments(proxyOption);
////        System.setProperty("webdriver.chrome.driver", "E:/Dev/WebDrivers/chromedriver.exe");
//        this.driver = new ChromeDriver(opts);
        PageFactory.initElements(this.driver,this);
    }



    public abstract boolean isAt();


}
