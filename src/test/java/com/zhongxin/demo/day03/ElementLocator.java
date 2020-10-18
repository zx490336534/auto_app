package com.zhongxin.demo.day03;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ElementLocator {
    private AndroidDriver androidDriver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "127.0.0.1:62001");
        capabilities.setCapability("appPackage", "com.lemon.lemonban");
        capabilities.setCapability("appActivity", "com.lemon.lemonban.activity.WelcomeActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        androidDriver = new AndroidDriver(url, capabilities);
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test01() {
//        androidDriver.findElement(MobileBy.id("com.lemon.lemonban:id/category_title")).click();
//        androidDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"全程班\")")).click();
//        androidDriver.findElement(MobileBy.className("android.widget.TextView")).click();
//        androidDriver.findElement(MobileBy.xpath("//android.widget.TextView[@text='全程班']")).click();
//        androidDriver.findElement(MobileBy.xpath("//android.widget.FrameLayout[@resource-id='com.lemon.lemonban:id/navigation_tiku']")).click();

//        TouchAction touchAction = new TouchAction(androidDriver);
//        PointOption pointOption = PointOption.point(445, 1539);
//        touchAction.press(pointOption).release().perform();

        androidDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        androidDriver.findElement(MobileBy.xpath("//*[contains(@text,'错误的账号信息')]"));

        WebDriverWait wait = new WebDriverWait(androidDriver, 5);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//*[contains(@text,'错误的账号信息')]")));
        String text = element.getText();
        System.out.println(text);


    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        androidDriver.quit();
    }
}
