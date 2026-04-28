package com.mutamir.testcases;

import com.mutamir.base.Base;
import com.mutamir.screens.SettingsScreen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Settings extends Base {
    SettingsScreen SettingsScreen;
    String oldLanguage;
    @Test
    public void testcase_01(){
        SettingsScreen  = new SettingsScreen(driver);
        SettingsScreen.OpenSettingsPage();
    }

    @Test
    public void testcase_02() throws InterruptedException {

        String oldLanguage = SettingsScreen.getCurrentLanguageValue();

        SettingsScreen.selectDifferentLanguage();

        SettingsScreen.verifyLanguageChanged(oldLanguage);

        Thread.sleep(1000);
    }

    @Test
    public void testcase_03() {

        SettingsScreen.toggleTheme();
    }

    @Test
    public void testcase_04() {

        String deviceLanguage = SettingsScreen.getCurrentLanguageValue();

        if (deviceLanguage.contains("العربية")) {
            SettingsScreen.selectCity("الرياض");
        } else {
            SettingsScreen.selectCity("Riyadh");
        }
    }




}
