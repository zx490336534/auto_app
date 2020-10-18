package com.zhongxin.demo.day05;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WetChatAppTest {

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
        // 支持X5内核应用自动化配置
        capabilities.setCapability("recreateChromeDriverSession", true);
        // ChromeOptions 使用来定制启动选项，因为在appium中切换context识别webview的时候，
        // 把com.tencent.mm:toolsmp的webview识别成com.tencent.mm的webview
        // 为了规避这个问题，加上androidProcess: com.tencent.mm:toolsmp
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("androidProcess","com.tencent.mm:appbrand0");
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
        // 初始化会默认将chrome浏览器打开，需要将Browser置为空
        capabilities.setBrowserName("");
    }
    @Test
    public void test() throws InterruptedException {
        Thread.sleep(10000);

    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        androidDriver.quit();
    }

}
