package com.mike.auto.task;

import com.mike.auto.util.AppiumUtils;
import com.mike.auto.util.Print2D;
import io.appium.java_client.android.AndroidDriver;


public class GoToHomePagerTask {

    private static final Print2D CHOOSE_USER_POINT = new Print2D(374, 1367);

    private static final Print2D START_GAME_POINT = new Print2D(544, 1561);

    private static final Print2D ANNOUNCEMENT_POINT = new Print2D(553, 1548);

    private static final Print2D UPDATE_POINT = new Print2D(514, 1762);


    /**
     * 跳转到主界面
     * 1.等待进入游戏  wait(10s)
     * 2.等待进入游戏按钮可见wait(10s)wait(10s)
     * 3.点击进入游戏按钮wait(10s)
     * 4.等待进入游戏主界面wait(10s)
     */
    public void goToHomePager(AndroidDriver driver) {
        AppiumUtils.waitSecond(20);
//        AppiumUtils.tap(driver, CHOOSE_USER_POINT.getX(), CHOOSE_USER_POINT.getY());
////        System.out.println("-------忽略--------");
////        AppiumUtils.waitSecond(10);
        AppiumUtils.tap(driver, ANNOUNCEMENT_POINT.getX(), ANNOUNCEMENT_POINT.getY());
        System.out.println("-------过目--------");
        AppiumUtils.waitSecond(2);
//        AppiumUtils.tap(driver, UPDATE_POINT.getX(), UPDATE_POINT.getY());
////        AppiumUtils.waitSecond(10);
        AppiumUtils.tap(driver, START_GAME_POINT.getX(), START_GAME_POINT.getY());
        System.out.println("-------开始游戏--------");
        AppiumUtils.waitSecond(30);


        System.out.println("-------进入主界面-------");



        System.out.println("-----");
        System.out.println("---" + driver.getPageSource() + "---");
    }

}
