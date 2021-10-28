package com.jiosaavn.web.springselenium.kelvin.config;

import com.jiosaavn.web.springselenium.kelvin.annotations.LazyConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@LazyConfiguration
public class WebDriverConfig {

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
        WebDriverManager.chromedriver().version(chromeVersion).setup();
        return new ChromeDriver();
    }




}
