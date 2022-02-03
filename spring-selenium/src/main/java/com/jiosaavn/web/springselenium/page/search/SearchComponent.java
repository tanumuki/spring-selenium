package com.jiosaavn.web.springselenium.page.search;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

@PageFragment
public class SearchComponent extends BaseConfig {


    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchBox;

    @FindBy(className = "u-subhead u-subhead--alt u-action-header")
    private List<WebElement> topResult;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/header/aside/div[2]")
    private WebElement searchGrid;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/header/aside/span[1]/strong")
    private WebElement clearBtn1;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/header/aside/span[2]/i")
    private WebElement crossBtn;

    @FindBy(partialLinkText = "View All")
    public List<WebElement> viewAllBtn;

    @FindBy(partialLinkText = "Clear")
    public WebElement clearBtn;

    @FindBy(xpath = "//*[@id='root']/div[2]/header/aside/div[2]/div/div[1]/article/div[1]/figure/figcaption/h4")
    public WebElement sanamband;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/header/aside/div[1]/div[1]/input[1]")
    public WebElement searchBoxLoggedInState;



    public void search(String query) throws InterruptedException {
        this.searchBox.click();
        this.searchBox.sendKeys(query);
        System.out.println("sent the query");
        Thread.sleep(1500);
        this.searchBox.sendKeys(Keys.TAB);
//        this.searchBox.sendKeys(Keys.ENTER);
        System.out.println("It clicked on REturn tab");
        Thread.sleep(1500);
    }

    public void searchResultsFromViewAll(){
//        int lengthofviewall = this.viewAllBtn.size();
        System.out.println(this.viewAllBtn.size());
        System.out.println(this.viewAllBtn);
//        Random rand = new Random();
//        WebElement w = this.viewAllBtn.get(rand.nextInt(lengthofviewall));
//        w.click();
        this.viewAllBtn.get(1).click();
    }

    public boolean getSearchResults(){
        return this.searchGrid.isDisplayed();
    }

    public WebElement getSearchBox(){ return this.searchBoxLoggedInState; }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until(d->this.searchBox.isDisplayed());
    }

}