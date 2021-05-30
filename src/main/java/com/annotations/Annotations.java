package com.annotations;

import com.excelplugin.ExcelPlugin;
import com.genericmethods.WebUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class Annotations {
    @BeforeSuite
    public void beforeSuite() throws IOException {
        WebUtils webUtils=new WebUtils();
        webUtils.loadConfigFile();
        ExcelPlugin excelPlugin=new ExcelPlugin();
        excelPlugin.loadExcelFile();
    }
    @BeforeMethod
    public void beforeMethod(Method method){
    ExcelPlugin.testcaseName=method.getName();
    }
}
