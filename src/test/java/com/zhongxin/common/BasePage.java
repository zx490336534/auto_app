package com.zhongxin.common;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    private static Logger logger = Logger.getLogger(BaseCase.class);
    public AndroidDriver androidDriver;

    public BasePage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /**
     * 等待元素可见
     */
    public WebElement waitElementVisible(By by) {
        logger.info("元素定位信息：" + by);
        WebDriverWait wait = new WebDriverWait(androidDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * 等待元素可点击
     */
    public WebElement waitElementClickable(By by) {
        logger.info("元素定位信息：" + by);
        WebDriverWait wait = new WebDriverWait(androidDriver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * 等待元素存在
     */
    public WebElement waitElementPresence(By by) {
        logger.info("元素定位信息：" + by);
        WebDriverWait wait = new WebDriverWait(androidDriver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * 点击android回退按钮
     */
    public void pressBack() {
        KeyEvent keyEvent = new KeyEvent(AndroidKey.BACK);
        androidDriver.pressKey(keyEvent);
    }

    /**
     * 获取toast文本信息
     */
    public String getToastText(String toastText) {
        return waitElementPresence(MobileBy.xpath("//*[contains(@text,'" + toastText + "')]")).getText();
    }

    /**
     * 输入文本
     */
    public void input(By by, String message) {
        waitElementVisible(by).sendKeys(message);
    }

    /**
     * 获取文本
     */
    public String getText(By by) {
        return waitElementVisible(by).getText();
    }

    /**
     * 点击操作
     */
    public void click(By by) {
        waitElementClickable(by).click();
    }
}
