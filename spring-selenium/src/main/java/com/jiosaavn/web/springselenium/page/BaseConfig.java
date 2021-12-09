package com.jiosaavn.web.springselenium.page;

import org.openqa.selenium.WebDriver;
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
        PageFactory.initElements(this.driver,this);
    }




    public abstract boolean isAt();


}
