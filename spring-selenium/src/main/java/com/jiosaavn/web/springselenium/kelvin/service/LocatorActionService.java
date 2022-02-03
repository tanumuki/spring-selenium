package com.jiosaavn.web.springselenium.kelvin.service;

import com.jiosaavn.web.springselenium.kelvin.config.WebDriverConfig;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
public class LocatorActionService {

    @Autowired
    private WebDriverConfig driver;

    /**
     * To click the element when enabled
     */
    @Bean
    public static void clickElement(WebElement webElement) {
        if(webElement.isEnabled()) {
            webElement.click();
        }
    }

    /**
     * Check if the element is displayed
     * @param webElement
     * @return Boolean
     */
    @Bean
    public static Boolean isElementDisplayed(WebElement webElement){
        return webElement.isDisplayed();
    }

    /**
     * Get the text displayed on UI of the element
     * @param webElement
     * @return String
     */
    @Bean
    public static String getElementText(WebElement webElement){
        return webElement.getText();
    }
}
