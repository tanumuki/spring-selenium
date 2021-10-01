package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.page.BaseConfig;
import com.jiosaavn.web.springselenium.page.search.SearchComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BaseConfig {


    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private AlertComponent alertComponent;





    @Value("${base.url}")
    private String baseUrl;

    public void goTo(){
        this.driver.get(baseUrl);
    }

    public void maximizeScreen(){
       // driver.manage().window().fullscreen();
        driver.manage().window().maximize();
    }


    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public AlertComponent getAlertComponent() {
        return alertComponent;
    }




    @Override
    public boolean isAt() {
        return  this.searchComponent.isAt();
    }
}
