package com.jiosaavn.web.springselenium.page.search;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


@PageFragment
public class SearchResultComponent extends BaseConfig {


    @FindBy(partialLinkText = "Search results for ")
    private WebElement searchText;

    @FindBy(className = "c-nav__list")
    private WebElement entityList;

    @FindBy(className = "u-h1 u-weight-normal u-ellipsis u-margin-bottom-none@sm u-visible@lg")
    private WebElement searchResultHeader;


    public String getSearchResultText(){
        System.out.println(this.searchResultHeader.getText());
        return this.searchResultHeader.getText();
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until(d->this.entityList.isDisplayed());
    }

}