package com.zhongxin.page;

import com.zhongxin.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;

public class AnswerSheetPage extends BasePage {
    private By switchBtnBy = MobileBy.id("com.lemon.lemonban:id/switch_button");
    private By tvBodyBy = MobileBy.id("com.lemon.lemonban:id/tvBody");

    public AnswerSheetPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void clickShowAnswerBtn() {
        click(switchBtnBy);
    }

    public boolean answerDisplay() {
        try {
            return waitElementVisible(tvBodyBy).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 向左滑动
     *
     * @param times：等待时间
     */
    public void swipeLeft(long times) {
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getWidth();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(width / 4, height / 2);
        PointOption endPoint = PointOption.point(3 * width / 4, height / 2);
        Duration duration = Duration.ofMillis(times);
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }
}
