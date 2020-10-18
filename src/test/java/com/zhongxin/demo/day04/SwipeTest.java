package com.zhongxin.demo.day04;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SwipeTest {
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
    public void test01() throws InterruptedException {
        Thread.sleep(2000);
        // 滑动操作 = 点击屏幕某一点 + 移动 + 松开
        // 点击 (365,170) 拖动(365,966)
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getWidth();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(width / 2, height / 4);
        PointOption endPoint = PointOption.point(width / 2, 3 * height / 4);
        // 滑动决定因素：滑动距离 滑动时间
        Duration duration = Duration.ofMillis(2000);
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }

    /**
     * 向下滑动
     *
     * @param times：等待时间
     */
    public void swipeDown(long times) {
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getWidth();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(width / 2, height / 4);
        PointOption endPoint = PointOption.point(width / 2, 3 * height / 4);
        Duration duration = Duration.ofMillis(times);
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }

    /**
     * 向上滑动
     *
     * @param times：等待时间
     */
    public void swipeUp(long times) {
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getWidth();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(width / 2, 3 * height / 4);
        PointOption endPoint = PointOption.point(width / 2, height / 4);
        Duration duration = Duration.ofMillis(times);
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }

    /**
     * 向左滑动
     *
     * @param times：等待时间
     */
    public void swipeLeft(long times) {
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getWidth();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(width / 4, height / 2);
        PointOption endPoint = PointOption.point(3 * width / 4, height / 2);
        Duration duration = Duration.ofMillis(times);
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }

    /**
     * 向右滑动
     *
     * @param times：等待时间
     */
    public void swipeRight(long times) {
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getWidth();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(3 * width / 4, height / 2);
        PointOption endPoint = PointOption.point(width / 4, height / 2);
        Duration duration = Duration.ofMillis(times);
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        androidDriver.quit();
    }
}
