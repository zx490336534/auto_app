package com.zhongxin.listener;

import com.zhongxin.common.BaseCase;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;


public class AllureScreenShotListener implements IHookable {
    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        iHookCallBack.runTestMethod(iTestResult);
        if (iTestResult.getThrowable() != null) {
            //发生异常
            Object object = iTestResult.getInstance();
            //把Case强转为为父类BaseCase
            BaseCase baseCase = (BaseCase) object;
            TakesScreenshot screenshot = (TakesScreenshot) baseCase.androidDriver;
            byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
            saveScreenshot(screenshotAs);
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
