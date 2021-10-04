package com.jiosaavn.web.springselenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverConfig {

    @Value("${chrome}")
    private String chrome_driver_version;

    @Value("${firefox}")
    private String firefox_driver_version;

    @Value("${timeout:30}")
    private int timeout;

    /**
     * If the bean is matching with the application.properties/commandline, it will launch firefox
     * @return FirefoxDriver
     */
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver fireFoxDriver(){
        WebDriverManager.firefoxdriver().version(firefox_driver_version).setup();
        return new FirefoxDriver();
    }

    /**
     * If the bean is missing, it will use the default one
     * @return ChromeDriver
     */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name="browser", havingValue = "chrome")
    public WebDriver chromeDriver(){
        WebDriverManager.chromedriver().version(chrome_driver_version).setup();
        return new ChromeDriver();
    }

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver){
        return new WebDriverWait(driver, this.timeout);
    }

}
