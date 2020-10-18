package com.zhongxin.cases;

import com.zhongxin.common.BaseCase;
import com.zhongxin.page.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TikuCase extends BaseCase {
    @BeforeTest
    public void setUp() throws MalformedURLException {
        openApp();
        LoginPage loginPage = new LoginPage(androidDriver);
        loginPage.loginSuccessFlow("13323234545", "234545", "歪歪");
    }

    @Test
    public void testShowAnser() {
        //1.点击题库按钮
        TikuPage tikuPage = new TikuPage(androidDriver);
        DiffcultyLevelPage diffcultyLevelPage = new DiffcultyLevelPage(androidDriver);
        PaperPage paperPage = new PaperPage(androidDriver);
        AnswerSheetPage answerSheetPage = new AnswerSheetPage(androidDriver);
        tikuPage.clickTiku();
        //2.随机选科目
        tikuPage.randomClickCategory();
        //3.随机选择难度
        diffcultyLevelPage.randomClickLevel();
        //4.随机选择套题列表
        paperPage.randomClickPaper();
        //5.点击显示答案按钮
        answerSheetPage.clickShowAnswerBtn();
        //6.断言答案是否显示
        boolean flag = answerSheetPage.answerDisplay();
        Assert.assertTrue(flag);
        //7.向左滑动一次
        answerSheetPage.swipeLeft(1000);
        //8.点击显示答案按钮,断言答案是否显示
        answerSheetPage.clickShowAnswerBtn();
        boolean flag1 = answerSheetPage.answerDisplay();
        Assert.assertTrue(flag1);


    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        quit();
    }
}
