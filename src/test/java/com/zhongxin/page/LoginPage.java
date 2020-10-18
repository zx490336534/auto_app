package com.zhongxin.page;

import com.zhongxin.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private By mobileBy = MobileBy.xpath("com.lemon.lemonban:id/et_mobile");
    private By passwordBy = MobileBy.xpath("com.lemon.lemonban:id/et_password");
    private By loginBtnBy = MobileBy.xpath("com.lemon.lemonban:id/btn_login");

    public LoginPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void inputMobile(String mobile) {
        input(mobileBy, mobile);
    }

    public void inputPassword(String password) {
        input(passwordBy, password);
    }

    public void clickLoginBtn() {
        click(loginBtnBy);
    }

    /**
     * 登录成功流程
     */
    public void loginSuccessFlow(String mobile, String password, String toastText) {
        IndexPage indexPage = new IndexPage(androidDriver);
        HomePage homePage = new HomePage(androidDriver);
        LoginPage loginPage = new LoginPage(androidDriver);
        indexPage.clickHome();
        homePage.clickNickName();
        loginPage.inputMobile(mobile);
        loginPage.inputPassword(password);
        loginPage.clickLoginBtn();
        String actual = loginPage.getToastText(toastText);
        Assert.assertEquals(actual, toastText);
    }

    /**
     * 登录失败流程
     */
    public void loginFailedFlow(String mobile, String password) {
        IndexPage indexPage = new IndexPage(androidDriver);
        HomePage homePage = new HomePage(androidDriver);
        LoginPage loginPage = new LoginPage(androidDriver);
        indexPage.clickHome();
        homePage.clickNickName();
        loginPage.inputMobile(mobile);
        loginPage.inputPassword(password);
        loginPage.clickLoginBtn();
        String actual = homePage.getNickName();
        Assert.assertEquals(actual, "歪歪");
    }

}
