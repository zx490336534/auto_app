package com.zhongxin.common;

import com.zhongxin.common.Constants;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseCase {
    private static Logger logger = Logger.getLogger(BaseCase.class);
    public AndroidDriver androidDriver;


    public void openApp() throws MalformedURLException {
        logger.info("========================打开APP==============================");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", Constants.PLATFORMNAME);
        capabilities.setCapability("deviceName", Constants.DEVICENAME);
        capabilities.setCapability("appPackage", Constants.APP_PACKAGE);
        capabilities.setCapability("appActivity", Constants.APP_ACTIVITY);
        capabilities.setCapability("noReset", true);
        URL url = new URL(Constants.REMOTEURL);
        androidDriver = new AndroidDriver(url, capabilities);
    }

    public void quit() {
        try {
            logger.info("========================关闭APP==============================");
            Thread.sleep(3000);
            androidDriver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
