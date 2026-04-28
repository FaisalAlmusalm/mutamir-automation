package com.mutamir.utils;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;

public class ScreenshotUtil {

    public static String takeScreenshot(AppiumDriver driver, String name) {
        File src = driver.getScreenshotAs(OutputType.FILE);
        String path = "reports/" + name + ".png";

        try {
            FileUtils.copyFile(src, new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}