package com.jiosaavn.web.springselenium.kelvin.config;

import com.jiosaavn.web.springselenium.kelvin.annotations.LazyConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.io.File;


@LazyConfiguration
public class WebDriverConfig {

    BrowserMobProxy proxy;
    WebDriver driver;


    @Value("${chrome}")
    private String chromeVersion;

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
    @Bean
    @Scope("browserScope")
    @ConditionalOnMissingBean
    public WebDriver chromeDriver(){

//        BrowserMobProxy proxy = new BrowserMobProxyServer();
//        proxy.start(0);
//        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//
//        // put our custom header to each request
//        proxy.addRequestFilter((request, contents, messageInfo)->{
//            request.headers().add("captcha-bypass", "6R1VzqByL1WCfSfTwiUcRWqO2YcftgB1u4");
//            System.out.println("Proxy22" +request.headers().entries().toString());
//            return null;
//        });
//
//        // Setting up Proxy for chrome
//        ChromeOptions opts = new ChromeOptions();
//        String proxyOption = "--proxy-server=" + seleniumProxy.getHttpProxy();
//        opts.addArguments(proxyOption);
//        System.setProperty("webdriver.chrome.driver", "/Users/tanumukherjee/Downloads/chromedriver");
//        driver = new ChromeDriver(opts);
//        ======new ======


        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/Users/tanumukherjee/Downloads/chromedriver"))
                .usingAnyFreePort()
                .build();
        ChromeOptions options = new ChromeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        // options.addArguments("load-extension=/Users/tanumukherjee/Downloads/CDN-Headers---Cookies.crx");
        options.addExtensions(new File("/Users/tanumukherjee/Downloads/CDN-Headers---Cookies.crx"));
        //options.addArguments("load-extension=/Users/tanumukherjee/Downloads/CDN-Headers---Cookies");
        options.merge(capabilities);
        ChromeDriver driver = new ChromeDriver(service, options);
        return driver;

//        WebDriverManager.chromedriver().version(chromeVersion).setup();
//        return new ChromeDriver();
    }





}
