package com.jiosaavn.web.springselenium.userProfileTest;

import com.jiosaavn.web.springselenium.SpringBaseTestNGTest;
import com.jiosaavn.web.springselenium.entity.User;
import com.jiosaavn.web.springselenium.page.EditProfile.UserProfileUpdate;
import com.jiosaavn.web.springselenium.repository.UserRepo;
import org.openqa.selenium.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

public class EditProfileTest extends SpringBaseTestNGTest {


    @Autowired
    private UserRepo repo;

    @Autowired
    private UserProfileUpdate userProfileUpdate;

    @Test(dataProvider = "getData")
    public void profileTest(User user) throws InterruptedException {


        //List<User> userList = this.repo.findAll().stream().limit(2).collect(Collectors.toList());


        this.userProfileUpdate.goTo();
        this.userProfileUpdate.addCookies();
        this.userProfileUpdate.setNames(user.getFirstName(), user.getLastName());
        this.userProfileUpdate.setEmail(user.getEmailAddress());
        this.userProfileUpdate.submit();


    }

    @DataProvider
    public Object[] getData(){
        return this.repo.findByFirstNameStartingWith("tanu").stream().limit(2).toArray();
    }


}
