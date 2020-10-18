package com.zhongxin.demo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppDemo {
    public static void main(String[] args) throws MalformedURLException {
        //需要先执行 adb connect 127.0.0.1:62001
        //adb devices提示127.0.0.1:62001	device则成功
        //配置设备信息
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //1.设备平台
        capabilities.setCapability("platformName", "Android");
        //2.设备名称
        capabilities.setCapability("deviceName", "127.0.0.1:62001");
        //3.APP包名
        capabilities.setCapability("appPackage", "com.lemon.lemonban");
        //4.App activity名称
        capabilities.setCapability("appActivity", "com.lemon.lemonban.activity.WelcomeActivity");

        // 把信息发送给Appium Server
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        // 创建Android驱动
        AndroidDriver driver = new AndroidDriver(url, capabilities);
    }
}
