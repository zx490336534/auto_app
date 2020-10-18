package com.zhongxin.page;

import com.zhongxin.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class IndexPage extends BasePage {
    private By homeBy = MobileBy.xpath("//*[@content-desc=\"我的柠檬\"]");

    public IndexPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void clickHome() {
        click(homeBy);
    }
}
