package com.jiosaavn.web.springselenium.page.EditProfile;

import com.jiosaavn.web.springselenium.entity.Cookies;
import com.jiosaavn.web.springselenium.kelvin.annotations.Page;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import com.jiosaavn.web.springselenium.repository.CookiesRepository;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

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

    public void goTo(){
        driver.get("https://www.jiosaavn.com/me/account");
    }


    public void addCookies() throws InterruptedException {
        List<Cookies> cookies = cookiesRepository.findAll();
//        System.out.println("cookies2:" +cookies);
        Thread.sleep(5000);
        org.openqa.selenium.Cookie c;
        for (int i = 0; i < cookies.size(); i++) {
//            c = new org.openqa.selenium.Cookie(cookies.get(i).getName(),cookies.get(i).getValue());
//            System.out.println("cookies:" + c);
            System.out.println(driver.manage().getCookieNamed(cookies.get(i).getName()));
            driver.manage().addCookie(new Cookie(cookies.get(i).getName(), cookies.get(i).getValue()));
//            driver.manage().addCookie(c);
        }

//        for (Cookie cookie: cookies){
//            driver.manage().addCookie(cookie);
//        }
        driver.navigate().refresh();
        Thread.sleep(5000);
//        System.out.println(driver.manage().getCookieNamed("I"));
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
