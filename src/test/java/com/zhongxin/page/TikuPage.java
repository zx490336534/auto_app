package com.zhongxin.page;

import com.zhongxin.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TikuPage extends BasePage {
    private By tikuBy = MobileBy.xpath("//*[@resource-id='com.lemon.lemonban:id/smalLabel' and @text='题库']");
    //分类图片
    private By categoryImageBy = MobileBy.id("com.lemon.lemonban:id/fragment_category_cover");

    public TikuPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void clickTiku() {
        click(tikuBy);
    }

    public void randomClickCategory() {
        waitElementVisible(categoryImageBy);
        List<WebElement> elements = androidDriver.findElements(categoryImageBy);
//        for (WebElement element : elements) {
//            System.out.println(element.getAttribute("resource-id"));
//        }
        //1.随机一个索引
//        Random random = new Random();
//        int index = random.nextInt(elements.size());
//        WebElement element = elements.get(index);
//        element.click();
        //2.打乱集合的顺序，获取第一个
        Collections.shuffle(elements);
        WebElement element = elements.get(0);
        element.click();
    }

}

