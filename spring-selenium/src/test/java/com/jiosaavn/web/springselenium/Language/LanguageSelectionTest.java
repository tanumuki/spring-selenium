package com.jiosaavn.web.springselenium.Language;

import com.jiosaavn.web.springselenium.SpringBaseTestNGTest;
import com.jiosaavn.web.springselenium.page.home.HomePage;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LanguageSelectionTest extends SpringBaseTestNGTest {


    @Autowired
    private HomePage homePage;


    @Test
    public void testLanguageSelection() throws InterruptedException {

        List<String> textList =  new ArrayList<>();

        this.homePage.goTo();
        this.homePage.maximizeScreen();
        this.homePage.getAlertComponent().acceptCookie();
        this.homePage.getAlertComponent().waitForAlertToAppear();
        this.homePage.getAlertComponent().closeAlert();
        List<WebElement> languageList = this.homePage.getLanguageComponent().getLanguageList();
        languageList.stream().forEach(e-> System.out.println("meow2  "+e.getText()));
        languageList.stream().forEach(languageElement->textList.add(languageElement.getText()));
        System.out.println("meow "+ textList);
        this.homePage.close();

    }


}
