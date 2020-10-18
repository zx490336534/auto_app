package com.zhongxin.page;

import com.zhongxin.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class PaperPage extends BasePage {
    private By arrowBy = MobileBy.id("com.lemon.lemonban:id/suit_subject_arrow");

    public PaperPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void randomClickPaper() {
        waitElementClickable(arrowBy);
        List<WebElement> elements = androidDriver.findElements(arrowBy);
        Random random = new Random();
        int index = random.nextInt(elements.size());
        WebElement element = elements.get(index);
        element.click();

    }
}
