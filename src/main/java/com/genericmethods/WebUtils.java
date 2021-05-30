package com.genericmethods;

import com.excelplugin.ExcelPlugin;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebUtils extends ExcelPlugin {
    public static WebDriver driver;
    public static Properties properties;
    public void launchBrowser() throws Exception {
        //get the browser type, url
        String browser=getConfigDetails("BROWSER");
        String url=getConfigDetails("URL");
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "ff":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                throw new Exception("Invalid browser type, must eith chrome or ff");
        }

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
    }

    public void loadConfigFile() throws IOException {
        File file=new File("src/main/resources/configuration/application-properties.properties");
        FileInputStream fis=new FileInputStream(file);
        properties=new Properties();
        properties.load(fis);
    }
    public String getConfigDetails(String key) throws IOException {
        if (properties==null)loadConfigFile();
        return properties.getProperty(key);
    }

    public void verifyElementExist(String pageName,String elementName,WebElement element){
        try{
            Assert.assertEquals(element.isDisplayed(),true,"The Element "+elementName+" is not dispalyed on the page "+pageName);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void waitForElement(WebElement element,int sec){
        WebDriverWait wait=new WebDriverWait(driver,sec);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @Attachment
    public byte[] takeScreenShot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }


}
