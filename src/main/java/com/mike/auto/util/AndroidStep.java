package com.mike.auto.util;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidStep {

    protected AndroidDriver driver;

    public static final String PACKAGE_NAME = "com.playcrab.dazhangmen2.huawei";

    public static final String MAIN_ACTIVITY = "org.cocos2dx.lua.AppActivity";

    protected void prepareAndroidForAppium() throws MalformedURLException {
        /* setup the app file path */
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File androidApp = new File(appDir, "dazhangMen.apk");
        if (!androidApp.exists()) {
            System.out.println("Android apk not found");
        }
        /* setup automation test variables */
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("sessionOverride", true);
        capabilities.setCapability("noSign", true);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);
        /* Android settings */
//        if (!driver.isAppInstalled(PACKAGE_NAME)) {
//////            capabilities.setCapability("app", androidApp.getAbsolutePath());
//////        }
        capabilities.setCapability("deviceName", "A7J5T15B12002165");
        capabilities.setCapability("appPackage", PACKAGE_NAME);
        capabilities.setCapability("appActivity", MAIN_ACTIVITY);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        /* End Android settings */
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


}
