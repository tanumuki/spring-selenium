package com.jiosaavn.web.springselenium.page.EditProfile;

import com.jiosaavn.web.springselenium.entity.Cookies;
import com.jiosaavn.web.springselenium.kelvin.annotations.Page;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import com.jiosaavn.web.springselenium.repository.CookiesRepository;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

@Page
public class UserProfileUpdate extends BaseConfig {


    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='last_name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    @Autowired
    private CookiesRepository cookiesRepository;

    BrowserMobProxy proxy;

    public void setUp(){
//        setUpProxy();
//        FirefoxOptions ffOptions = new FirefoxOptions();
//        ffOptions.setProxy(ClientUtil.createSeleniumProxy(proxy));
//        driver = new FirefoxDriver(ffOptions);
        FirefoxProfile profile = new FirefoxProfile();
        File modifyHeaders = new File(System.getProperty("user.dir") + "/src/main/resources/modify_header.xpi");

        profile.addExtension(modifyHeaders);
        profile.setPreference("modifyheaders.headers.count", 1);
        profile.setPreference("modifyheaders.headers.action0", "Add");
        profile.setPreference("modifyheaders.headers.name0", "Value");
        profile.setPreference("modifyheaders.headers.value0", "numeric value");
        profile.setPreference("modifyheaders.headers.enabled0", true);
        profile.setPreference("modifyheaders.config.active", true);
        profile.setPreference("modifyheaders.config.alwaysOn", true);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);

        WebDriver driver = new FirefoxDriver(capabilities);
        driver.get("https://www.jiosaavn.com/me/account");
    }

    public void goTjo(){
        setUp();
        driver.get("https://www.jiosaavn.com/me/account");
    }

    public void setUpProxy(){
        proxy = new BrowserMobProxyServer();
        String authHeader = "6R1VzqByL1WCfSfTwiUcRWqO2YcftgB1u4";
        proxy.addHeader("captcha-bypass", authHeader);
        proxy.start(0);
    }


//    public void goTo(){
//        driver.get("https://www.jiosaavn.com/me/account");
//    }

    public void goTo(){
        ChromeOptions opts = new ChromeOptions();
//        opts.addExtensions(new File("src/main/resources/modheader.crx"));
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, opts);

//        driver.get("chrome-extension://idgpnmonknjnojddfkpgkljpfnnfcklj/_generated_background_page.html");

        proxy = new BrowserMobProxyServer();
//        String authHeader = "6R1VzqByL1WCfSfTwiUcRWqO2YcftgB1u4";
//        proxy.addHeader("captcha-bypass", authHeader);
        proxy.addRequestFilter((response, contents, messageInfo)->{
            response.headers().add("captcha-bypass", "6R1VzqByL1WCfSfTwiUcRWqO2YcftgB1u4");
            System.out.println(response.headers().entries().toString());
            return null;
        });
        proxy.start(0);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // put our custom header to each request
//        proxy.addRequestFilter((response, contents, messageInfo)->{
//            response.headers().add("captcha-bypass", "6R1VzqByL1WCfSfTwiUcRWqO2YcftgB1u4");
//            System.out.println(response.headers().entries().toString());
//            return null;
//        });
        System.out.println(seleniumProxy);
        System.out.println(proxy);

        // Setting up Proxy for chrome
        String proxyOption =  seleniumProxy.getHttpProxy();
        System.out.println(proxyOption+"is the http proxy");
        opts.addArguments(proxyOption);
//        System.setProperty("webdriver.chrome.driver", "E:/Dev/WebDrivers/chromedriver.exe");
        this.driver = new ChromeDriver(opts);
//        System.out.println(opts);
        driver.get("https://www.jiosaavn.com/me/account");
    }



    public void addCookies() throws InterruptedException {
        List<Cookies> cookies = cookiesRepository.findAll();
//        System.out.println(String.valueOf(cookies));
        Thread.sleep(5000);
        org.openqa.selenium.Cookie c;
        for (int i = 0; i < cookies.size(); i++) {
            c = new org.openqa.selenium.Cookie(cookies.get(i).getName(),cookies.get(i).getValue());
            driver.manage().addCookie(c);
        }

//        for (Cookie cookie: cookies){
//            driver.manage().addCookie(cookie);
//        }
        driver.navigate().refresh();
        Thread.sleep(5000);
        System.out.println(driver.manage().getCookieNamed("I"));
//        Cookie cookie = new Cookie("I", "9k5D%2By7UHiQG30G5wt1AuhjeOwqNyfasPb6G9f2F6UkiGxtz4HzvNkh7s0XL2KeOaxPz6p%2F4nSD474a011D6A2M%2FlMKVqL3130zoERWAdYgxZtoU2MU1DBvq3kodN12BFsyVDKyyheenKkJIeVaVHQTmucUvWRSpBHUj%2B1AifZoffFVaUr5FQaI4m2fV2WdmfZ1Y33mHfWXfMvR%2BmyTIA3Ua%2BY4GtD9%2BPbT4GdxgaemgaF0qx0enQPa0gmeWC79wafKO2ohLUidpycCD0R%2FKK70HoI3jIlpKzNOkugZ9qSbzDHkexcvOGrY%2B1MmVACEIUAkTmrJ4L70%3D");
//        Cookie cookie = new Cookie("Cookie", "I=9k5D%2By7UHiQG30G5wt1AuhjeOwqNyfasPb6G9f2F6UkiGxtz4HzvNkh7s0XL2KeOaxPz6p%2F4nSD474a011D6A2M%2FlMKVqL3130zoERWAdYgxZtoU2MU1DBvq3kodN12BFsyVDKyyheenKkJIeVaVHQTmucUvWRSpBHUj%2B1AifZoffFVaUr5FQaI4m2fV2WdmfZ1Y33mHfWXfMvR%2BmyTIA3Ua%2BY4GtD9%2BPbT4GdxgaemgaF0qx0enQPa0gmeWC79wafKO2ohLUidpycCD0R%2FKK70HoI3jIlpKzNOkugZ9qSbzDHkexcvOGrY%2B1MmVACEIUAkTmrJ4L70%3D");
//        driver.manage().addCookie(cookie);
//        Thread.sleep(500);
//        driver.navigate().refresh();
//        Thread.sleep(2000);
    }


    public void setNames(String firstName, String lastName){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
    }
    public void setEmail(String email){
        this.email.sendKeys(email);
    }
    public void submit(){
        this.submit.click();
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d)->this.submit.isDisplayed());
    }
}
