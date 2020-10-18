package com.zhongxin.page;

import com.zhongxin.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By nickNameBy = MobileBy.id("com.lemon.lemonban:id/fragment_my_lemon_avatar_title");

    public HomePage(AndroidDriver androidDriver) {
        super(androidDriver);
    }


    public void clickNickName() {
        waitElementClickable(nickNameBy).click();
    }

    public String getNickName() {
        return getText(nickNameBy);
    }
}
