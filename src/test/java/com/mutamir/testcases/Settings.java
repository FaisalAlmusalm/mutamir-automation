package com.mutamir.testcases;

import com.mutamir.base.Base;
import com.mutamir.screens.SettingsScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Settings extends Base {

    SettingsScreen settingsScreen;
    @BeforeMethod
    public void setUpScreen() {
        settingsScreen = new SettingsScreen(driver);
        settingsScreen.openSettingsPage();

    }
    @Test(priority = 1)
    public void openSettings() {
        String settingsTitle = settingsScreen.getSettingsPageTitle();
        Assert.assertTrue(
                settingsTitle.contains("Settings")
                        || settingsTitle.contains("الإعدادات"),
                "Settings or الاعدادت text Should appear"
        );


    }

    @Test(priority = 2)
    public void changeLanguage() {
        String oldLanguage = settingsScreen.getCurrentLanguageValue();

        settingsScreen.selectDifferentLanguage();

        String newLanguage = settingsScreen.getCurrentLanguageValue();

        Assert.assertNotEquals(
                settingsScreen.extractLanguageName(newLanguage),
                settingsScreen.extractLanguageName(oldLanguage),
                "Language did not change it "
        );
    }
    @Test(priority = 3)
    public void changeTheme() {
        boolean isThemeChanged = settingsScreen.toggleTheme();

        Assert.assertTrue(
                isThemeChanged,
                "Theme did not change"
        );
    }

    @Test(priority = 4)
    public void selectCity() {
        String deviceLanguage = settingsScreen.getCurrentLanguageValue();

        if (deviceLanguage.contains("العربية")) {
            settingsScreen.selectCity("الرياض");
        } else {
            settingsScreen.selectCity("Riyadh");
        }
    }

}