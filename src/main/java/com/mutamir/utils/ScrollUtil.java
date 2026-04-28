package com.mutamir.utils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class ScrollUtil {
    public static void fastSwipeUp(AppiumDriver driver) {
        driver.executeScript("mobile: swipe", Map.of("direction", "up"));
    }

    public static void scrollUntilFound(AppiumDriver driver, By locator) {
        int attempts = 0;

        while (driver.findElements(locator).isEmpty()) {
            if (attempts == 10) {
                throw new RuntimeException("ما لقيت العنصر");
            }

            fastSwipeUp(driver);

            try {
                Thread.sleep(400);
            } catch (Exception e) {
                e.printStackTrace();
            }

            attempts++;
        }
    }
    }





