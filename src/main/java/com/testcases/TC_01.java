package com.testcases;

import com.annotations.Annotations;
import com.application_pages.HomePage.HomePage;
import com.application_pages.Registration.RegistrationPage;
import com.genericmethods.WebUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_01 extends Annotations {
    @Test
    public void Tc_01_RegisterUser() throws Exception {
        WebUtils webUtils=new WebUtils();
        webUtils.launchBrowser();

        HomePage homePage=HomePage.getInstance();
        homePage.clickRegisterLink();

        RegistrationPage registrationPage=RegistrationPage.getInstance();
        registrationPage.verifyRegistrationPage();
        registrationPage.fillRegisterForm();
    }
}
