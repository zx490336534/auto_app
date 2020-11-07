package com.zhongxin.listener;

import com.zhongxin.common.BaseCase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenShotListener implements IHookable {


    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        iHookCallBack.runTestMethod(iTestResult);
        if (iTestResult.getThrowable() != null) {
            //发生异常
            Object object = iTestResult.getInstance();
            //把Case强转为为父类BaseCase
            BaseCase baseCase = (BaseCase) object;
            TakesScreenshot screenshot = (TakesScreenshot) baseCase.androidDriver;
            File fileSrc = screenshot.getScreenshotAs(OutputType.FILE);
            File fileDest = new File("src/test/resources/" + System.currentTimeMillis() + ".png");
            try {
                FileUtils.copyFile(fileSrc, fileDest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
