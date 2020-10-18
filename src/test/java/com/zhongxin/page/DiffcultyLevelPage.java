package com.zhongxin.page;

import com.zhongxin.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiffcultyLevelPage extends BasePage {
    private By level1By = MobileBy.xpath("com.lemon.lemonban:id/first_level");
    private By level2By = MobileBy.xpath("com.lemon.lemonban:id/second_level");
    private By level3By = MobileBy.xpath("com.lemon.lemonban:id/third_level");

    public DiffcultyLevelPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void randomClickLevel() {
        List<By> levelyList = new ArrayList<>();
        levelyList.add(level1By);
        levelyList.add(level2By);
        levelyList.add(level3By);
        Random random = new Random();
        int index = random.nextInt(levelyList.size());
        By levelBy = levelyList.get(index);
        click(levelBy);
    }
}
