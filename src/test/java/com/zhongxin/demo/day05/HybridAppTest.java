package com.zhongxin.demo.day05;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

// 混合app应用网页测试
public class HybridAppTest {
    private AndroidDriver androidDriver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "127.0.0.1:62001");
        capabilities.setCapability("appPackage", "com.lemon.lemonban");
        capabilities.setCapability("appActivity", "com.lemon.lemonban.activity.WelcomeActivity");
        capabilities.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        androidDriver = new AndroidDriver(url, capabilities);
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        androidDriver.findElement(MobileBy.xpath("//*[@text='柠檬社区']")).click();
        System.out.println(androidDriver.getContextHandles());//[NATIVE_APP, WEBVIEW_com.lemon.lemonban]
        //切换到WEBVIEW_com.lemon.lemonban
        androidDriver.context("WEBVIEW_com.lemon.lemonban");
        //进入web页面
        androidDriver.findElement(MobileBy.xpath("//span[contains(text(),'注册')]")).click();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        androidDriver.quit();
    }
}
