package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.Page;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import com.jiosaavn.web.springselenium.page.search.SearchComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class HomePage extends BaseConfig {


    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private AlertComponent alertComponent;

    @Autowired
    private LanguageComponent languageComponent;

    @Autowired
    private LibraryComponent libraryComponent;

    @Autowired
    private TrendingNowComponent trendingNowComponent;







    @Value("${application.url}")
    private String baseUrl;

    public void goTo(){
        this.driver.get(baseUrl);
    }

    public void maximizeScreen(){
       // driver.manage().window().fullscreen();
        driver.manage().window().maximize();
    }

    public void close(){
        this.driver.quit();
    }


    public SearchComponent getSearchComponent() {
        return searchComponent;
    }



    public AlertComponent getAlertComponent() {
        return alertComponent;
    }

    public LanguageComponent getLanguageComponent(){
        return languageComponent;
    }

    public LibraryComponent getLibraryComponent(){
        return libraryComponent;
    }

    public TrendingNowComponent getTrendingNowComponent(){
        return trendingNowComponent;
    }




    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }
}
