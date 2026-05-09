package com.mutamir.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class ScrollUtil {



    public static void scrollDownUntilFound(AppiumDriver driver, By locator) {

        int attempts = 0;

        while (attempts < 6) {

            List<WebElement> elements = driver.findElements(locator);

            if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
                return;
            }

            smallSwipeUp(driver);
            attempts++;
        }

        throw new RuntimeException("Element not found after scrolling: " + locator);
    }
    private static void smallSwipeUp(AppiumDriver driver) {

        Dimension size = driver.manage().window().getSize();

        int x = size.width / 2;

        int startY = (int) (size.height * 0.60);
        int endY   = (int) (size.height * 0.45);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), x, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));
    }
    public static void scrollUpUntilFound(AppiumDriver driver, By locator) {

        for (int i = 0; i < 10; i++) {

            List<WebElement> elements = driver.findElements(locator);

            if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
                return;
            }

            smallSwipeDown(driver);
        }

        throw new RuntimeException("Element not found after scrolling up: " + locator);
    }

    private static void smallSwipeDown(AppiumDriver driver) {

        Dimension size = driver.manage().window().getSize();

        int x = size.width / 2;

        int startY = (int) (size.height * 0.45);
        int endY   = (int) (size.height * 0.60);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), x, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));
    }
    }