package com.mike.auto.mian;

import com.mike.auto.task.GoToHomePagerTask;
import com.mike.auto.task.PK999Task;
import com.mike.auto.util.AndroidStep;
import com.mike.auto.util.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class AndroidAuto extends AndroidStep {


    @Before
    public void before() {
        try {
            prepareAndroidForAppium();
        } catch (MalformedURLException e) {
            System.out.println("初始化设置失败!");
            e.printStackTrace();
        }
    }


    @Test
    public void goStart() {
        new GoToHomePagerTask().goToHomePager(driver);

        new PK999Task().startPK(driver);

    }


    @After
    public void after() {
        driver.quit();
    }


}
