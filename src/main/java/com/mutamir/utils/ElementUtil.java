package com.mutamir.utils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static com.mutamir.base.Base.driver;

public class ElementUtil {
    public static void click(AppiumDriver driver, By locator) {

       WaitUtil.waitForElement(driver, locator);

        driver.findElement(locator).click();

    }
    public static void click(AppiumDriver driver, WebElement element){

        WaitUtil.waitForElement(driver,  element);
        element.click();


    }


    public static String getText(AppiumDriver driver, By locator) {

        WaitUtil.waitForElement(driver, locator);

        return driver.findElement(locator).getText();

    }

    public static String getText(AppiumDriver driver, WebElement e) {

        WaitUtil.waitForElement(driver, e);

        return e.getText();

    }

    public static boolean isPresent(AppiumDriver driver, By locator) {

        return !driver.findElements(locator).isEmpty();

    }

}
