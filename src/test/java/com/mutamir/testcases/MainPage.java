package com.mutamir.testcases;

import com.mutamir.base.Base;
import com.mutamir.screens.MainPageScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPage extends Base {
    MainPageScreen mainPageScreen ;

    @BeforeMethod
    public void setUpScreen() {
        mainPageScreen = new MainPageScreen(driver);
    }
    @Test(priority = 1)
    public void Home_screen_loads() throws InterruptedException {

// Settings
        boolean isAvalibleSettting = mainPageScreen.getSettingAvalible();

        Assert.assertTrue(isAvalibleSettting,"Settings button should appear");

        Assert.assertTrue(mainPageScreen.getMainPageTitle().contains("Mutamir") || mainPageScreen.getMainPageTitle().contains("مُعْتَمِر"), "Main page title is not correct");

 // UmrahPath
        String actualUmrahPathText = mainPageScreen.getUmrahPathText().trim();
        System.out.println("Actual Umrah Path text = [" + actualUmrahPathText + "]");
        Assert.assertTrue(
                actualUmrahPathText.toLowerCase().contains("umrah path")
                        || actualUmrahPathText.contains("مسار العمرة"),
                "Umrah Path text Should appear");

        // Guidelines

        String actualGuidelines = mainPageScreen.getGuidelinesText().trim();
        System.out.println("Actual Guidelines text = [" + actualGuidelines + "]");
        Assert.assertTrue(
                mainPageScreen.getGuidelinesText().contains("Guidelines")
                        || mainPageScreen.getGuidelinesText().contains("إرشادات"),
                "Guidelines Path text Should appear");

//Supplications
        String actualSupplications = mainPageScreen.getSupplicationsText();
        System.out.println("Actual Supplications text = [" + actualSupplications + "]");
        Assert.assertTrue(
                mainPageScreen.getSupplicationsText().contains("Supplications")
                        || mainPageScreen.getSupplicationsText().contains("أدعية"),
                "Supplications text Should appear");


       // Prayer Times
        String actualSPrayerTimesText = mainPageScreen.getPrayerTimesText().trim();
        System.out.println("Actual Prayer Times text = [" + actualSPrayerTimesText + "]");
        Assert.assertTrue(
                mainPageScreen.getPrayerTimesText().contains("Prayer Times")
                        || mainPageScreen.getPrayerTimesText().contains("أوقات الصلاة"),
                "Prayer Times text Should appear");

        //actualQibla
        String actualQibla = mainPageScreen.getQiblaDirectionText().trim();
        System.out.println("Actual Qibla Direction text = [" + actualQibla + "]");
        Assert.assertTrue(
                mainPageScreen.getQiblaDirectionText().contains("Qibla Direction")
                        || mainPageScreen.getQiblaDirectionText().contains("اتجاه القبلة"),
                "Qibla Direction text Should appear");

        //actualAdhkar
        String actualAdhkar = mainPageScreen.getAdhkarText().trim();
        System.out.println("Actual Adhkar text = [" + actualAdhkar + "]");
        Assert.assertTrue(
                mainPageScreen.getAdhkarText().contains("Adhkar")
                        || mainPageScreen.getAdhkarText().contains("الأذكار"),
                "Adhkar text Should appear");

        //Voluntary
        String actualVoluntary = mainPageScreen.getVoluntaryText().trim();
        System.out.println("Actual Voluntary text = [" + actualVoluntary + "]");
        Assert.assertTrue(
                mainPageScreen.getVoluntaryText().contains("Voluntary")
                        || mainPageScreen.getVoluntaryText().contains("النافلة"),
                "Voluntary text Should appear");

        //actualStartUmrah
        String actualStartUmrah  = mainPageScreen.getStartUmrahText().trim();
        System.out.println("Actual Start Umrah text = [" + actualStartUmrah + "]");
        Assert.assertTrue(
                mainPageScreen.getStartUmrahText().contains("Start Umrah")
                        || mainPageScreen.getStartUmrahText().contains("ابدأ العمرة"),
                "Start Umrah text Should appear"
        );





}
    @Test(priority = 2)
    public void Open_Umrah_Guide_from_Home() throws InterruptedException {
        String Open_Umrah_Guide_from_Home = mainPageScreen.openStartUmrah();
        System.out.println("Actual umrah guide = [" + Open_Umrah_Guide_from_Home + "]");
        Assert.assertTrue(
                Open_Umrah_Guide_from_Home.contains("Your steps to perform Umrah correctly"),
                "Umrah guide page did not open");
    }

    @Test(priority = 3)
    public void Open_Guidelines(){
        String Open_Guidelines= mainPageScreen.Guidelines();
        System.out.println("Actual Open Guidelines = [" + Open_Guidelines + "]");
        Assert.assertTrue(
                Open_Guidelines.contains("Your steps to perform Umrah correctly"),
                "Guidelines page did not open ");
    }

    @Test(priority = 4)
    public void Open_Supplications(){
        String Open_Supplications= mainPageScreen.supplications();
        System.out.println("Actual Open Supplications = [" + Open_Supplications + "]");
        Assert.assertTrue(
                Open_Supplications.contains("Supplications"),
                "Supplications page did not open");
    }
    @Test(priority = 5)
    public void Open_PrayerTime(){
        String Open_PryerTime= mainPageScreen.Open_Prayer_Times();
        System.out.println("Actual Open PrayerTime = [" + Open_PryerTime + "]");
        Assert.assertTrue(
                Open_PryerTime.contains("Prayer Times"),
                "Prayer Times page did not open");
    }
    @Test(priority = 6)
    public void Open_direction_qibla(){
        String Open_DirectQibla= mainPageScreen.Open_direction();
        System.out.println("Actual Open OpenDirection = [" + Open_DirectQibla + "]");
        Assert.assertTrue(
                Open_DirectQibla.contains("Qibla"),
                "Qibla page did not open");
    }
    @Test(priority = 7)
    public void Open_Adhkar(){
        String Open_Adhkar= mainPageScreen.Opendadhkar();
        System.out.println("Actual Open OpenDirection = [" + Open_Adhkar + "]");
        Assert.assertTrue(
                Open_Adhkar.contains("Adhkar"),
                "Adhkar page did not open");
    }



}









