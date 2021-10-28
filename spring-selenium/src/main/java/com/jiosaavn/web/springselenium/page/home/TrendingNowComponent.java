package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@PageFragment
public class TrendingNowComponent extends BaseConfig {



    @FindBy(xpath = "//div[@class='o-layout u-margin-bottom@sm']")
    private List<WebElement> trendingTiles;


    public void clickAllTiles() throws InterruptedException {
        for(int i=0 ;i <trendingTiles.size() ;i++){
          //  System.out.println("tetttt "+this.trendingTiles.get(i).getText());
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
            Thread.sleep(2000);
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1)); //switches to new tab
            driver.get("https://www.jiosaavn.com/featured/most-searched-songs---hindi/csv-SfcHUmHc1EngHtQQ2g__");
            driver.switchTo().window(tabs.get(0)); // switch back to main screen
           // this.trendingTiles.get(i).click();
            Thread.sleep(2000);
            break;
        }
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
