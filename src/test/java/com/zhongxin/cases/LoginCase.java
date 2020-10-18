package com.zhongxin.cases;

import com.zhongxin.common.BaseCase;
import com.zhongxin.page.HomePage;
import com.zhongxin.page.IndexPage;
import com.zhongxin.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginCase extends BaseCase {

    @BeforeTest
    public void setUp() throws MalformedURLException {
        openApp();
    }


    @Test
    public void loginFailed() {
        IndexPage indexPage = new IndexPage(androidDriver);
        HomePage homePage = new HomePage(androidDriver);
        LoginPage loginPage = new LoginPage(androidDriver);
        indexPage.clickHome();
        homePage.clickNickName();
        loginPage.inputMobile("13323234545");
        loginPage.inputPassword("123456");
        loginPage.clickLoginBtn();

        String actual = loginPage.getToastText("错误的账号信息");
        Assert.assertEquals(actual, "错误的账号信息");
    }

    @Test
    public void loginSuccess() {
        IndexPage indexPage = new IndexPage(androidDriver);
        HomePage homePage = new HomePage(androidDriver);
        LoginPage loginPage = new LoginPage(androidDriver);
        indexPage.clickHome();
        homePage.clickNickName();
        loginPage.inputMobile("13323234545");
        loginPage.inputPassword("234545");
        loginPage.clickLoginBtn();

        String actual = homePage.getNickName();
        Assert.assertEquals(actual, "歪歪");
    }

    @Test(dataProvider = "datas")
    public void loginFailed02(String mobile, String password, String toastExpected) {
        IndexPage indexPage = new IndexPage(androidDriver);
        HomePage homePage = new HomePage(androidDriver);
        LoginPage loginPage = new LoginPage(androidDriver);
        indexPage.clickHome();
        homePage.clickNickName();
        loginPage.inputMobile(mobile);
        loginPage.inputPassword(password);
        loginPage.clickLoginBtn();

        String actual = loginPage.getToastText(toastExpected);
        Assert.assertEquals(actual, toastExpected);
    }

    @DataProvider
    public Object[][] datas() {
        Object[][] datas = {
                {"", "", "手机号码或密码不能为空"},
                {"13213123", "123123", "手机号码格式不正确"},
                {"13323234545", "", "手机号码或密码不能为空"},
                {"", "123123123", "手机号码或密码不能为空"},
        };
        return datas;
    }


    @AfterTest
    public void tearDown() throws InterruptedException {
        quit();
    }
}
