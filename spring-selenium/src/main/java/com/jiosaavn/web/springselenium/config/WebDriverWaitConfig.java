package com.jiosaavn.web.springselenium.config;

import com.jiosaavn.web.springselenium.annotations.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class WebDriverWaitConfig {



    @Value("${default.timeout:10}")
    private int timeOut;

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver){
        return new WebDriverWait(driver, this.timeOut);

    }
}
