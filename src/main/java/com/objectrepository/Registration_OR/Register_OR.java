package com.objectrepository.Registration_OR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register_OR {
    @FindBy(xpath = "//input[@id='gender-male']")
    public WebElement gender_male;
    @FindBy(xpath = "//input[@id='gender-female']")
    public WebElement gender_female;
    @FindBy(xpath = "//input[@id='FirstName']")
    public WebElement firstName;
    @FindBy(xpath = "//input[@id='LastName']")
    public WebElement LastName;
    @FindBy(xpath = "//h1[text()='Register']")
    public WebElement register_Header;

}
