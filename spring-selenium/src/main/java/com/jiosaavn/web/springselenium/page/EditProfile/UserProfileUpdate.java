package com.jiosaavn.web.springselenium.page.EditProfile;

import com.jiosaavn.web.springselenium.kelvin.annotations.Page;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class UserProfileUpdate extends BaseConfig {


    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='last_name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    public void goTo(){
        driver.get("https://www.jiosaavn.com/me/account");
    }

    public void setNames(String firstName, String lastName){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
    }
    public void setEmail(String email){
        this.email.sendKeys(email);
    }
    public void submit(){
        this.submit.click();
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
