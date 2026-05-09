package com.mutamir.screens;

import com.mutamir.utils.ElementUtil;
import com.mutamir.utils.ScrollUtil;
import com.mutamir.utils.WaitUtil;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OmrahPathScreen {

    private AppiumDriver driver;

    public OmrahPathScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private By startUmrahButton = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Start Umrah')]");
    private By startOmrahCheck = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Guidelines')]");
   // private By tawafButton = By.xpath("//*[contains(@name,'Kaaba')]");
   private By tawafCard = AppiumBy.iOSNsPredicateString(
           "type == 'XCUIElementTypeStaticText' AND visible == 1 AND name BEGINSWITH[c] 'Tawaf' AND name CONTAINS[c] 'Kaaba'"
   );

    private By tawafCompleted = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Completed')]");
    private By tawafCompleted1 = AppiumBy.accessibilityId("Tawaf Completed — Alhamdulillah");
    private By nextButton = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Next')]");
    private By nextRoundButton = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Next Round')]");
    private By saiiCompleted = AppiumBy.accessibilityId("Sa'i Completed — Masha'Allah");
    private By ResetOmrahText = AppiumBy.accessibilityId("Reset Umrah Progress");
private By resetOmrahbtn = AppiumBy.accessibilityId("Start Umrah");

    @iOSXCUITFindBy(accessibility = "Sa'i →")
    private WebElement saiiButton;


    @iOSXCUITFindBy(accessibility = "Tahallul →")
    private WebElement tahallulButton;

    @iOSXCUITFindBy(accessibility = "Tahallul Steps")
    private WebElement tahallulCompleted;

    @iOSXCUITFindBy(accessibility = "Reset Umrah Progress")
    private WebElement resetUmrahButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Reset Umrah Progress' AND label == 'Reset Umrah Progress' AND type == 'XCUIElementTypeButton'")
    private WebElement resetUmrahConfirmButton;

    @iOSXCUITFindBy(accessibility = "Return to Home")
    private WebElement returnHomeButton;

    @iOSXCUITFindBy(accessibility = "Completed")
    private WebElement completedOmrah;

    public void startOmrah() {
        WaitUtil.waitForElement(driver, startUmrahButton);
        ElementUtil.click(driver, startUmrahButton);
       // WaitUtil.waitForElement(driver, resetOmrahbtn);
      //  ElementUtil.click(driver,resetOmrahbtn);
    }

    public String getStartOmrahCheckText() {
        WaitUtil.waitForElement(driver, startOmrahCheck);
        return ElementUtil.getText(driver, startOmrahCheck);
    }


    public void openTawaf() {
        ScrollUtil.scrollDownUntilFound(driver, tawafCard);
        WaitUtil.waitForElement(driver, tawafCard);

        for (int i = 0; i < 3; i++) {
            try {
                ElementUtil.tapByElementCenter(driver, tawafCard);

                // If Tawaf opens, the Next button should appear
                WaitUtil.waitForElement(driver, nextButton);

                return; // success, stop retrying

            } catch (Exception e) {
                System.out.println("Tawaf tap failed, retry number: " + (i + 1));

                try {
                    Thread.sleep(700);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        throw new RuntimeException("Failed to open Tawaf after 3 attempts");
    }

    public String clickUntilEndTawaf() {
        for (int i = 0; i < 8; i++) {

            if (!driver.findElements(tawafCompleted1).isEmpty()) {
                return ElementUtil.getText(driver, tawafCompleted1);
            }

            if (driver.findElements(nextButton).isEmpty()) {
                break;
            }

            ElementUtil.click(driver, nextButton);

            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        WaitUtil.waitForElement(driver, tawafCompleted1);
        return ElementUtil.getText(driver, tawafCompleted1);
    }


    public void openSaii() {
        WaitUtil.waitForElement(driver, saiiButton);
        ElementUtil.click(driver, saiiButton);
    }

    public String clickUntilEndSaii() {
        for (int i = 0; i < 8; i++) {

            if (!driver.findElements(saiiCompleted).isEmpty()) {
                return ElementUtil.getText(driver, saiiCompleted);
            }

            if (driver.findElements(nextButton).isEmpty()) {
                break;
            }

            ElementUtil.click(driver, nextButton);

            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        WaitUtil.waitForElement(driver, saiiCompleted);
        return ElementUtil.getText(driver, saiiCompleted);
    }

    public void openTahallul() {
        WaitUtil.waitForElement(driver, tahallulButton);
        ElementUtil.click(driver, tahallulButton);
    }

    public String getTahallulCompletedText() {
        WaitUtil.waitForElement(driver, tahallulCompleted);
        return ElementUtil.getText(driver, tahallulCompleted);
    }

    public void goHomePage() {
        WaitUtil.waitForElement(driver, returnHomeButton);
        ElementUtil.click(driver, returnHomeButton);
    }

    public void resetOmrah() {
        WaitUtil.waitForElement(driver, resetUmrahButton);
        ElementUtil.click(driver, resetUmrahButton);
    }

    public void confirmResetOmrah() {
        WaitUtil.waitForElement(driver, resetOmrahbtn);
        ElementUtil.click(driver, resetOmrahbtn);
    }

    public String getCompletedOmrahText() {
        WaitUtil.waitForElement(driver, completedOmrah);
        return ElementUtil.getText(driver, completedOmrah);
    }
}