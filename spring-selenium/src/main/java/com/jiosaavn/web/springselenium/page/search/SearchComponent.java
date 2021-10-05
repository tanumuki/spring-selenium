package com.jiosaavn.web.springselenium.page.search;

import com.jiosaavn.web.springselenium.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@PageFragment
public class SearchComponent extends BaseConfig {



    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchBox;



    public void search( String query){
        System.out.println("yoyoy 2");
        this.searchBox.click();
        this.searchBox.sendKeys(query);
        this.searchBox.sendKeys(Keys.RETURN);
    }
    @Override
    public boolean isAt() {
        return this.webDriverWait.until(d->this.searchBox.isDisplayed());
    }

}