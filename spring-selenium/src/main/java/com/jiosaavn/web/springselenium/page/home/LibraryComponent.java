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
import java.util.Random;
import java.util.stream.Collectors;

@PageFragment
public class LibraryComponent extends BaseConfig {

    @FindBy(xpath = "//aside[@class='c-aside c-aside--fixed']")
    private List<WebElement> libraryText;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/aside[2]/div/span")
    private WebElement newPlaylist;

    @FindBy(xpath = "//span[@class='o-list-block__item u-color-js-gray u-padding-vertical-tiny@sm c-btn-modal']")
    private List<WebElement> libraryButtons;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/aside[2]/nav/ul/li[2]/span")
    private WebElement songsButton;

    @Autowired
    private LibraryMainPage libraryMainPage;

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

    public void clickNewPlaylist(){
       this.newPlaylist.click();
    }

//    public void clickHistoryButton(WebElement we){
//        Random rand = new Random();
//        WebElement w = this.libraryButtons.get(rand.nextInt(5));
//        w.click();
//    }

    public void clickSongsButton(){
        this.songsButton.click();
    }

    public List<WebElement> getLibraryText() {
        return libraryText;
    }

    public WebElement getNewPlaylist() {
        return newPlaylist;
    }

    public List<WebElement> getLibraryButtons() {
        return libraryButtons;
    }

    public WebElement getSongsButton() {
        return songsButton;
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
        return this.webDriverWait.until((d)->this.newPlaylist.isDisplayed());
    }
}
