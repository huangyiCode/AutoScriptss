package com.mike.auto.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * Created by 44096281 on 2018/1/24.
 */
public class AppiumUtils {

    /**
     * 获取错误页面
     *
     * @param driver
     * @throws IOException
     */
    public static void screenshots(RemoteWebDriver driver) throws IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("DBBMobileApp-yyyy-MM-ddHH:mm:ss");

        String dataString = formatter.format(new Date());

        String dirName = System.getProperty("user.dir") + File.separator + "errorPicture";

        if (!(new File(dirName).isDirectory())) {
            new File(System.getProperty("user.dir"), "errorPicture").mkdir();
        }

        File screen = driver.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screen, new File(dirName, dataString + ".jpg"));
    }

    public static void tap(AppiumDriver driver, int x, int y) {
        (new TouchAction(driver)).tap(PointOption.point(x, y)).perform();
    }

    public static void swipe(AppiumDriver driver, int fromX, int fromY, int toX, int toY) {
        (new TouchAction(driver))
                .press(PointOption.point(fromX, fromY))
                .moveTo(PointOption.point(toX, toY))
                .release()
                .perform();
    }

    public static void scrollDown(AppiumDriver driver) {
        int fromX = 0;
        int toX = 0;
        int fromY = 5 * driver.manage().window().getSize().height / 6;
        int toY = driver.manage().window().getSize().height / 6;
        System.out.println("fromX: " + fromX + " fromY: " + fromY + " toX: " + toX + " toY: " + toY);
        swipe(driver, fromX, fromY, toX, toY);
    }

    public static void scrollUp(AppiumDriver driver) {
        int fromX = 0;
        int toX = 0;

        int fromY = driver.manage().window().getSize().height / 6;

        int toY = fromY * 2;
        System.out.println("fromX: " + fromX + " fromY: " + fromY + " toX: " + toX + " toY: " + toY);
        swipe(driver, fromX, fromY, toX, toY);
    }

    public static void scrollTop(AppiumDriver driver) {
        int fromX = driver.manage().window().getSize().width / 6;
        int toX = driver.manage().window().getSize().width / 6;
        int fromY = driver.manage().window().getSize().height / 6;
        int toY = 4 * driver.manage().window().getSize().height / 6;
        System.out.println("fromX: " + fromX + " fromY: " + fromY + " toX: " + toX + " toY: " + toY);
        swipe(driver, fromX, fromY, toX, toY);
    }

    public static void waitPagerSourceDisplay(AppiumDriver driver, String source) {
        while (!driver.getPageSource().contains(source)) {
            System.out.println(String.format("Loading... wait %s source display", source));
        }
    }


    public static void scrollToElement(AppiumDriver driver, WebElement element) {
        (new Actions(driver)).moveToElement(element).perform();
    }

    public static String getLastContext(AppiumDriver driver) {
        Set<String> contexts = driver.getContextHandles();
        System.out.println("Contexts: " + contexts);
        return contexts.size() > 0 ? contexts.toArray()[contexts.size() - 1].toString() : "NATIVE_APP";
    }

    public static void waitSecond() {
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public static void waitSecond(long waitSeconds) {
        try {
            Thread.sleep(waitSeconds * 1000);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
