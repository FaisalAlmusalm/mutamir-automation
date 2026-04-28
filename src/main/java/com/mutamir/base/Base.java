package com.mutamir.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;

public class Base {
    public static AppiumDriver driver;
    protected FileInputStream inputStream;
    protected Properties prop;


    @Parameters({"deviceName", "platformName", "platformVersion"})
    @BeforeClass
    public void OpenApp(String deviceName, String platformName, String platformVersion) throws Exception {

        File propfile = new File("src/main/resources/config/config.properties");
        inputStream = new FileInputStream(propfile);
        prop = new Properties();
        prop.load(inputStream);

//       هذه الأربع أسطر معناها:
//
//       1. أحدد مكان الملف
//       2. أفتح الملف
//       3. أجهز كائن يخزن القيم
//       4. أحمّل القيم من الملف إلى الكائن


//
//       * File = مكان الملف
//               * FileInputStream = فتح الملف للقراءة
//* Properties = صندوق يحفظ القيم
//* load() = يعبّي الصندوق من الملف

        if (platformName.equalsIgnoreCase("iOS")) {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", deviceName);
            caps.setCapability("platformName", platformName);
            caps.setCapability("appium:platformVersion", platformVersion);
            caps.setCapability("appium:automationName", prop.getProperty("ios_automationName"));
            caps.setCapability("appium:udid", prop.getProperty("ios_udid"));
            caps.setCapability("appium:bundleId", prop.getProperty("bundleId"));

            driver = new IOSDriver(new URL("http://127.0.0.1:4723"), caps);
        } else if (deviceName.equalsIgnoreCase("Android")) {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", deviceName);
            caps.setCapability("platformName", platformName);
            caps.setCapability("platformVersion", platformVersion);
            caps.setCapability("appium:automationName", prop.getProperty("android_automationName"));
            caps.setCapability("appium:udid", prop.getProperty("android_udid"));
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

        }


// try {
//     driver = new IOSDriver(new URL("http://127.0.0.1:4723"), caps);
// }    catch(Exception e){
//     e.printStackTrace();
//
// }


//       // أو 2️⃣ لو عندك ملف app
//
//       // caps.setCapability("appium:app", "/path/to/app.app");
//
//       // ⚡ تحسينات
//
//       caps.setCapability("appium:noReset", true);   // لا يسوي reset للتطبيق
//
//       caps.setCapability("appium:newCommandTimeout", 300);
//
//       // 🚀 تشغيل الدرايفر

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

//
//    @AfterClass
//    public void closeapp() {
//        if (driver != null) {
//            driver.quit();
//        }


    }







