package com.mutamir.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

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



        if (platformName.equalsIgnoreCase("iOS")) {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", deviceName);
            caps.setCapability("platformName", platformName);
            caps.setCapability("appium:platformVersion", platformVersion);
            caps.setCapability("appium:automationName", prop.getProperty("ios_automationName"));
            caps.setCapability("appium:udid", prop.getProperty("ios_udid"));
            caps.setCapability("appium:bundleId", prop.getProperty("bundleId"));

            driver = new IOSDriver(new URL("http://127.0.0.1:4723"), caps);
        } else if (platformName.equalsIgnoreCase("Android")) {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", deviceName);
            caps.setCapability("platformName", platformName);
            caps.setCapability("platformVersion", platformVersion);
            caps.setCapability("appium:automationName", prop.getProperty("android_automationName"));
            caps.setCapability("appium:udid", prop.getProperty("android_udid"));
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @AfterClass
    public void closeApp() {
        if (driver != null) {
            driver.quit();
        }
    }

    }







