package com.objectrepository.HomePage_OR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_OR {
    @FindBy(xpath ="//a[text()='Register']")
    public WebElement register;
    @FindBy(xpath ="//a[text()='Log in']")
    public WebElement login;
}
