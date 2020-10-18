package com.zhongxin.demo.day04;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MultiSwipeTest {
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
    public void test01() throws InterruptedException {
        //手指1
        TouchAction action1 = new TouchAction(androidDriver);
        //手指2
        TouchAction action2 = new TouchAction(androidDriver);
        int y = androidDriver.manage().window().getSize().getHeight();
        int x = androidDriver.manage().window().getSize().getWidth();
        PointOption pointA = PointOption.point(x / 5, y / 5);
        PointOption pointB = PointOption.point(x * 2 / 5, y * 2 / 5);
        PointOption pointC = PointOption.point(x * 3 / 5, y * 3 / 5);
        PointOption pointD = PointOption.point(x * 4 / 5, y * 4 / 5);
        // 放大 B->A C->D
        action1.press(pointB).moveTo(pointA).release();
        action2.press(pointC).moveTo(pointD).release();
        MultiTouchAction multiTouchAction = new MultiTouchAction(androidDriver);
        multiTouchAction.add(action1);
        multiTouchAction.add(action2);
        multiTouchAction.perform();
    }

    /**
     * 放大
     */
    public void zoom() {
        //手指1
        TouchAction action1 = new TouchAction(androidDriver);
        //手指2
        TouchAction action2 = new TouchAction(androidDriver);
        int y = androidDriver.manage().window().getSize().getHeight();
        int x = androidDriver.manage().window().getSize().getWidth();
        PointOption pointA = PointOption.point(x / 5, y / 5);
        PointOption pointB = PointOption.point(x * 2 / 5, y * 2 / 5);
        PointOption pointC = PointOption.point(x * 3 / 5, y * 3 / 5);
        PointOption pointD = PointOption.point(x * 4 / 5, y * 4 / 5);
        // 放大 B->A C->D
        action1.press(pointB).moveTo(pointA).release();
        action2.press(pointC).moveTo(pointD).release();
        MultiTouchAction multiTouchAction = new MultiTouchAction(androidDriver);
        multiTouchAction.add(action1);
        multiTouchAction.add(action2);
        multiTouchAction.perform();
    }


    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        androidDriver.quit();
    }
}
