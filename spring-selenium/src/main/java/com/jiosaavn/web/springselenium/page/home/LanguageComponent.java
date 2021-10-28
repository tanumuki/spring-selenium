package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class LanguageComponent extends BaseConfig {


    @FindBy(xpath = "//aside[@class='c-aside c-aside--fixed']")
    private List<WebElement> languageList;


    public List<WebElement> getLanguageList(){
        return languageList;
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
