package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.PageFragment;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFragment
public class HomepageHeaderComponent extends BaseConfig {




    @FindBy(xpath = "//span[contains(text(),'Upgrade')]")
    private WebElement upgradeButton;



    public void clickUpgradeBtn(){
        upgradeButton.click();
    }

    @Override
    public boolean isAt() {
        return false;
    }

}
