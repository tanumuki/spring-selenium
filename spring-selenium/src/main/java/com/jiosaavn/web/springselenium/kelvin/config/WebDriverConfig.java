package com.jiosaavn.web.springselenium.kelvin.config;

import com.jiosaavn.web.springselenium.kelvin.annotations.LazyConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.TimeUnit;


@LazyConfiguration
public class WebDriverConfig {

    BrowserMobProxy proxy;
    WebDriver driver;




    @Value("${chrome}")
    private String chromeVersion;

    @Bean
    @Scope("browserScope")
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
 //       System.out.println("debug 1");
//        FirefoxProfile profile = new FirefoxProfile();
//        File modifyHeaders = new File(System.getProperty("user.dir") + "/Users/tanumukherjee/Downloads/modify_header.xpi");
//        System.out.println("debug 2");
//        profile.addExtension(modifyHeaders);
//        profile.setPreference("modifyheaders.headers.count", 1);
//        profile.setPreference("modifyheaders.headers.action0", "Add");
//        profile.setPreference("modifyheaders.headers.name0", "Value");
//        profile.setPreference("modifyheaders.headers.value0", "numeric value");
//        profile.setPreference("modifyheaders.headers.enabled0", true);
//        profile.setPreference("modifyheaders.config.active", true);
//        profile.setPreference("modifyheaders.config.alwaysOn", true);
//        System.out.println("debug 3");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("firefox");
//        capabilities.setCapability("marionette", true);
//        System.out.println("debug 4");
//        capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
//        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
//        System.out.println("debug 5");
       // WebDriver driver = new FirefoxDriver(capabilities);
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setCapability("marionette", true);
//        System.out.println("debug 6");
//        driver = new FirefoxDriver(firefoxOptions);

//
//        System.setProperty("webdriver.gecko.driver","/Users/tanumukherjee/Downloads/geckodriver"); // Setting system properties of FirefoxDriver
//        WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
//        System.out.println("debug 7");
////        driver.manage().window().maximize();
////        System.out.println("debug 8");
//        return driver;

    }
    @Bean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver(){

//        /*
//        Technique 1: using proxy to start the browser and pass header
//         */
//
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

        //setting up proxy for firefox
//
//        System.setProperty("webdriver.gecko.driver", "/Users/tanumukherjee/Downloads/geckodriver");
//        FirefoxOptions ffOptions = new FirefoxOptions();
//        ffOptions.setProxy(ClientUtil.createSeleniumProxy(proxy));
//        driver = new FirefoxDriver(ffOptions);


//        ======new ======

/*
Technique 3:  where the extension file is added to the chrome but the values aren't copied over to the new automated browser
 */

//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//
//        ChromeDriverService service = new ChromeDriverService.Builder()
//                .usingDriverExecutable(new File("/Users/tanumukherjee/Downloads/chromedriver"))
//                .usingAnyFreePort()
//                .build();
//        ChromeOptions options = new ChromeOptions();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        // options.addArguments("load-extension=/Users/tanumukherjee/Downloads/CDN-Headers---Cookies.crx");
//        options.addExtensions(new File("/Users/tanumukherjee/Downloads/CDN-Headers---Cookies.crx"));
//        //options.addArguments("load-extension=/Users/tanumukherjee/Downloads/CDN-Headers---Cookies");
//        options.merge(capabilities);
//        ChromeDriver driver = new ChromeDriver(service, options);


//        WebDriverManager.chromedriver().version(chromeVersion).setup();
//        return new ChromeDriver();


        /*
        Option 4: Firefox XPI file
         */

//        FirefoxProfile profile = new FirefoxProfile();
//        File modifyHeaders = new File(System.getProperty("user.dir") + "/Users/tanumukherjee/Downloads/modify_header.xpi");
//
//        profile.addExtension(modifyHeaders);
//        profile.setPreference("modifyheaders.headers.count", 1);
//        profile.setPreference("modifyheaders.headers.action0", "Add");
//        profile.setPreference("modifyheaders.headers.name0", "Value");
//        profile.setPreference("modifyheaders.headers.value0", "numeric value");
//        profile.setPreference("modifyheaders.headers.enabled0", true);
//        profile.setPreference("modifyheaders.config.active", true);
//        profile.setPreference("modifyheaders.config.alwaysOn", true);
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("firefox");
//        capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
//        capabilities.setCapability(FirefoxDriver.PROFILE, profile);

        //WebDriver driver = new FirefoxDriver(capabilities);


        /*
        Options 5: Simple firefox geckodriver
         */
//
       System.setProperty("webdriver.chrome.driver", "/Users/tanumukherjee/Downloads/chromedriver");
         driver = new ChromeDriver();

         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }






}
