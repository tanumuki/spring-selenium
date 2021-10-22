package com.jiosaavn.web.springselenium.page.library;

import com.jiosaavn.web.springselenium.kelvin.annotations.Page;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Page
public class ListeningHistory extends BaseConfig {

        @FindBy(xpath = "//i[@class='o-icon-history o-icon--large u-margin-right-tiny@sm']")
        private WebElement historyText;

        public void openHistoryPageInNewTab() throws InterruptedException {
//            String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
//            this.historyText.sendKeys(selectLinkOpeninNewTab);
            this.historyText.click();
            boolean flag=isClicked(historyText);
            System.out.println("Value of flag is  "+flag);
            System.out.println("meow2");
            Thread.sleep(2000);
        }

    public boolean isClicked(WebElement element)
    {
        try {
            this.webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
            return true;
        } catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until(d->this.historyText.isDisplayed());
    }
}
