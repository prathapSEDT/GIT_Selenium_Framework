package com.application_pages.Registration;

import com.application_pages.HomePage.HomePage;
import com.genericmethods.WebUtils;
import com.objectrepository.HomePage_OR.Home_OR;
import com.objectrepository.Registration_OR.Register_OR;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends WebUtils {
    private static RegistrationPage registrationPage;
    private static Register_OR register_or;
    private RegistrationPage(){
        register_or= PageFactory.initElements(driver,Register_OR.class);
    }
    public static RegistrationPage getInstance(){
        if(register_or==null) registrationPage=new RegistrationPage();
        return registrationPage;
    }
@Step("verify if the registartion page is displayed")
    public void verifyRegistrationPage(){
    verifyElementExist("Registartion Page","Headrer",register_or.register_Header);
    takeScreenShot();
    }
    @Step("Fill the registartion form")
    public void fillRegisterForm(){
        String gender=getData("data","Gender");
        waitForElement(register_or.gender_male,60);
        if(gender.equals("male")){
            register_or.gender_male.click();
        }else {
            register_or.gender_female.click();
        }
        String firstname=getData("data","FirstName");
        register_or.firstName.sendKeys(firstname);
        takeScreenShot();
    }


}
