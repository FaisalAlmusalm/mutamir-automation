package com.mutamir.testcases;
import com.mutamir.base.Base;
import com.mutamir.screens.MainPageScreen;
import com.mutamir.screens.SettingsScreen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.mutamir.base.Base.driver;

public class MainPage extends Base {
    MainPageScreen mainPageScreen ;

    @Test
    public void testcase_01() {
        mainPageScreen  = new MainPageScreen(driver);
        String text = mainPageScreen.checkopenMainPage();
        System.out.println("Actual main page text = [" + text + "]");

        Assert.assertTrue(text.equals("Mutamir") || text.equals("مُعْتَمِر"), "Expected main page text to be Mutamir or مُعْتَمِر, but actual was: [" + text + "]");
    }


    @Test
    public void testcase_02(){
        mainPageScreen  = new MainPageScreen(driver);
        String text = mainPageScreen.CheckOmrahPath();
        System.out.println("Actual main page text = [" + text + "]");

        Assert.assertTrue(text.equals("Umrah Path") || text.equals("مسار العمرة"), "Expected main page text to be Umrah Path or مسار العمرة, but actual was: [" + text + "]");
    }

    @Test
    public void testcase_03(){
        mainPageScreen  = new MainPageScreen(driver);
        String text = mainPageScreen.CheckStartOmrahPathOption();
        Assert.assertEquals(text,"Start Umrah");
    }



    @Test
    public void testcase_04(){
        mainPageScreen  = new MainPageScreen(driver);
        String text = mainPageScreen.CheckGuidelinesOption();
        Assert.assertTrue(text.contains("Guidelines"));;
    }
    @Test
    public void testcase_05(){
        mainPageScreen  = new MainPageScreen(driver);
        String text = mainPageScreen.CheckSupplicationsOption();
        Assert.assertTrue(text.contains("Supplications"));;
    }
    @Test
    public void testcase_06(){
        mainPageScreen  = new MainPageScreen(driver);
        String text = mainPageScreen.CheckPrayer_TimesOption();
        Assert.assertTrue(text.contains("Prayer"));;
    }
    @Test
    public void testcase_07(){
        mainPageScreen  = new MainPageScreen(driver);
        String text = mainPageScreen.CheckQibla_DirectionOption();
        Assert.assertTrue(text.contains("Qibla"));;
    }
    @Test
    public void testcase_08(){
        mainPageScreen  = new MainPageScreen(driver);
        String text = mainPageScreen.CheckAdhkarOption();
        Assert.assertTrue(text.contains("Adhkar"));;
    }
    @Test
    public void testcase_09(){
        mainPageScreen  = new MainPageScreen(driver);
        String text = mainPageScreen.CheckVoluntaryOption();
        Assert.assertTrue(text.contains("Voluntary"));;
    }

    @Test
    public void testcase_10(){
        mainPageScreen  = new MainPageScreen(driver);
        mainPageScreen.CheckSettingsyOption();

    }

//    @Test
//    public void testcase_03(){
//        mainPageScreen  = new MainPageScreen(driver);
//        mainPageScreen.StartOmrah();
//        String text = mainPageScreen.checkopenstartomrah();
//        Assert.assertEquals(text,"Guidelines");
//
//    }




}
