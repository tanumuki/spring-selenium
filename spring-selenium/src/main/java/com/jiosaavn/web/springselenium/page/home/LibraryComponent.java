package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import com.jiosaavn.web.springselenium.page.library.Albums;
import com.jiosaavn.web.springselenium.page.library.LibraryMainPage;
import com.jiosaavn.web.springselenium.page.library.ListeningHistory;
import com.jiosaavn.web.springselenium.page.library.Songs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@PageFragment
public class LibraryComponent extends BaseConfig {

    @FindBy(xpath = "//aside[@class='c-aside c-aside--fixed']")
    private List<WebElement> libraryText;

    @Autowired
    private LibraryMainPage libraryMainPage;

//    public List<WebElement> getLibraryItemsList(){
//        return libraryText;
//    }

    public LibraryMainPage getLibraryMainPage() {
        return  libraryMainPage;
    }



    public List<String> getLabels(){
       List<String> list= libraryText.stream().map(WebElement::getText).map(String::trim).collect(Collectors.toList());
        return list;
    }

    public List<WebElement> getLibraryLinks(){
        return libraryText;
    }

//    @Autowired
//    private ListeningHistory listeningHistoryPage;
//
//    @Autowired
//    private Songs songsPage;
//
//    @Autowired
//    private Albums albumsPage;
//
//
//    public void clickListeningHistory(){
//
//    }


    @Override
    public boolean isAt() {
        return false;
    }
}
