package com.jiosaavn.web.springselenium.LibraryTests;

import com.jiosaavn.web.springselenium.SpringBaseTestNGTest;
import com.jiosaavn.web.springselenium.page.home.HomePage;
import com.jiosaavn.web.springselenium.page.home.LibraryComponent;
import com.jiosaavn.web.springselenium.page.library.LibraryMainPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryTest extends SpringBaseTestNGTest {

    private static final Logger logger = LoggerFactory.getLogger(LibraryTest.class);

    @Autowired
    private HomePage homePage;

    @Autowired
    private LibraryDetails libraryDetails;

    @Autowired
    private LibraryMainPage libraryMainPage;

    @Autowired
    private LibraryComponent libraryComponent;


        @Test
    public void testLibraryOnHome() throws InterruptedException {

       List<String> labelList=this.libraryDetails.getLibraryLabels().stream().collect(Collectors.toList());
        System.out.println("label list " +labelList);

        List<String> textList =  new ArrayList<>();

        this.homePage.goTo();
        this.homePage.maximizeScreen();
        this.homePage.getAlertComponent().acceptCookie();
        this.homePage.getAlertComponent().waitForAlertToAppear();
        this.homePage.getAlertComponent().closeAlert();
        List<String> list=this.homePage.getLibraryComponent().getLabels();
        //    this.libraryComponent.getLibraryMainPage().getListeningHistory().openHistoryPageInNewTab();
            Thread.sleep(1000);
         //   this.libraryComponent.getLibraryMainPage().getSongs().openSongsPageInNewTab();
        //    this.libraryComponent.getLibraryMainPage().getAlbums().openAlbumPageInNewTab();
           // Thread.sleep(1000);
        this.homePage.getTrendingNowComponent().clickAllTiles();

//       // libraryItemsList.stream().forEach(libElement->textList.add(libElement.getText()));
//        System.out.println("List is "+ list +" and size is " +list.size());
//        logger.debug("list size is2 "+list.size());
//        list.remove(0);
//        list.remove(list.size());
//        logger.info("list size is "+list.size());
//        System.out.println("List2 is "+ list);
//        logger.warn("list size is  333"+list.size());
//        //Assert.assertEquals("list 1", "list 2");
       // this.homePage.close();

    }

//    @Test
//    public void testSwitchingLibraryPages() throws InterruptedException {
//        this.homePage.goTo();
//        this.homePage.maximizeScreen();
//        this.homePage.getAlertComponent().acceptCookie();
//        this.homePage.getAlertComponent().waitForAlertToAppear();
//        this.homePage.getAlertComponent().closeAlert();
////        this.libraryComponent.getLibraryMainPage().getSongs().openSongsPageInNewTab();
////        this.libraryComponent.getLibraryMainPage().getAlbums().openAlbumPageInNewTab();
////        this.libraryComponent.getLibraryMainPage().getListeningHistory().openHistoryPageInNewTab();
//        this.libraryComponent.getLibraryMainPage().getListeningHistory().openHistoryPageInNewTab();
//        Thread.sleep(5000);


    }
//}





