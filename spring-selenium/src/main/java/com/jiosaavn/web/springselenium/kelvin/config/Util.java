package com.jiosaavn.web.springselenium.kelvin.config;

import com.jiosaavn.web.springselenium.kelvin.annotations.LazyConfiguration;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Predicate;

import java.util.concurrent.TimeUnit;


public class Util  {


    @Autowired
    static WebDriver webDriver;

    @Autowired
    protected WebDriverWait wait;


    public void javaScriptExecutor(){


//        // wait for jQuery to load
//        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                try {
//                    return ((Long)executeJavaScript("return jQuery.active") == 0);
//                }
//                catch (Exception e) {
//                    return true;
//                }
//            }
//        };
//
//        // wait for Javascript to load
//        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return executeJavaScript("return document.readyState")
//                        .toString().equals("complete");
//            }
//        };
//
//        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    public static void implicitlyWait(){
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
