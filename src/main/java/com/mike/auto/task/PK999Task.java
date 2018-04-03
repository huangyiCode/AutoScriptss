package com.mike.auto.task;

import com.mike.auto.util.AppiumUtils;
import com.mike.auto.util.Print2D;
import io.appium.java_client.android.AndroidDriver;

public class PK999Task {

    private static final Print2D SOCIAL_POINT = new Print2D(988, 1492);

    private static final Print2D FRIEND_LIST_POINT = new Print2D(172, 1074);

    private static final Print2D FRIEND_POINT = new Print2D(190, 589);

    private static final Print2D PK_POINT = new Print2D(328, 1219);

    private static final Print2D SKIP_POINT = new Print2D(960, 1850);

    private static final Print2D BLOCK_POINT = new Print2D(603, 1791);

    public void startPK(AndroidDriver driver) {
        int times = 0;

        try {
            System.out.println("-------打开列表-------");
            AppiumUtils.tap(driver, SOCIAL_POINT.getX(), SOCIAL_POINT.getY());
            AppiumUtils.waitSecond(5);
            System.out.println("-------打开好友列表-------");
            AppiumUtils.tap(driver, FRIEND_LIST_POINT.getX(), FRIEND_LIST_POINT.getY());
            AppiumUtils.waitSecond(5);


            while (times < 200) {
                System.out.println("-------选择好友-------");
                AppiumUtils.tap(driver, FRIEND_POINT.getX(), FRIEND_POINT.getY());
                AppiumUtils.waitSecond(5);
                System.out.println("-------进行PK-------");
                AppiumUtils.tap(driver, PK_POINT.getX(), PK_POINT.getY());
                AppiumUtils.waitSecond(8);
                System.out.println("-------跳过-------");
                AppiumUtils.tap(driver, SKIP_POINT.getX(), SKIP_POINT.getY());
                AppiumUtils.waitSecond(2);
                System.out.println("-------下一步-------");
                AppiumUtils.tap(driver, BLOCK_POINT.getX(), BLOCK_POINT.getY());
                AppiumUtils.waitSecond(5);

                times++;

                System.out.println("成功---->times=" + times);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("强制中断---->times=" + times);
        }


    }
}
