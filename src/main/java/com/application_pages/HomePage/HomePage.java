package com.application_pages.HomePage;

import com.genericmethods.WebUtils;
import com.objectrepository.HomePage_OR.Home_OR;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebUtils {
    private static HomePage homePage;
    private static Home_OR home_or;
    private HomePage(){
        home_or= PageFactory.initElements(driver,Home_OR.class);
    }
    public static HomePage getInstance(){
       if(homePage==null) homePage=new HomePage();
       return homePage;
    }
    @Step("Click on the login link")
    public void clickLogin(){
        home_or.login.click();
    }
    public void clickRegisterLink(){
        home_or.register.click();
        takeScreenShot();
    }
}
