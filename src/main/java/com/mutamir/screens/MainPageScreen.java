package com.mutamir.screens;

import com.mutamir.utils.ElementUtil;
import com.mutamir.utils.WaitUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static com.mutamir.base.Base.driver;

public class MainPageScreen {


    public MainPageScreen(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]")
    WebElement Settingsbtn;
//==================================================================
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mutamir']")
    WebElement mainpagetext;
    @iOSXCUITFindBy(accessibility= "//XCUIElementTypeStaticText[@name='مُعْتَمِر']")
    WebElement Amainpagetext;

    By mainTitle = By.xpath("//XCUIElementTypeStaticText[@y='122']");

    //=============================================================
    @iOSXCUITFindBy(accessibility = "Umrah Path")
    WebElement umrahPath;
    By umrahPath_check = By.xpath("//XCUIElementTypeStaticText[@y='442']");


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Guidelines')]")
    WebElement Guidelines;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Supplications')]")
    WebElement Supplications;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Prayer')]")
    WebElement Prayer_Times;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Qibla')]")
    WebElement Qibla_Direction;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Adhkar')]")
    WebElement Adhkar;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Voluntary')]")
    WebElement Voluntary;


    @iOSXCUITFindBy(accessibility = "Start Umrah")
    WebElement startomrahbtn;

    @iOSXCUITFindBy(accessibility = "Guidelines")
    WebElement startomrahcheck;


    public void scrollUntilFound(By locator) {
        for (int i = 0; i < 5; i++) {
            if (driver.findElements(locator).size() > 0) {
                return;
            }
            driver.executeScript("mobile: swipe", Map.of("direction", "down"));
        }

        throw new RuntimeException("ما لقيت العنصر");
    }



    public String checkopenMainPage() {
        return ElementUtil.getText(driver,mainTitle);
    }


    public String CheckOmrahPath() {
        return ElementUtil.getText(driver,umrahPath_check);

    }

    public String CheckGuidelinesOption() {
        By locator = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Guidelines')]");
        scrollUntilFound(locator);
        return Guidelines.getText();
    }

    public String CheckSupplicationsOption() {
        By locator = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Supplications')]");
        scrollUntilFound(locator);
        return Supplications.getText();

    }

    public String CheckPrayer_TimesOption() {
        By locator = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Prayer')]");
        scrollUntilFound(locator);
        return Prayer_Times.getText();

    }

    public String CheckQibla_DirectionOption() {
        By locator = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Qibla')]");
        scrollUntilFound(locator);
        return Qibla_Direction.getText();

    }

    public String CheckAdhkarOption() {
        By locator = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Adhkar')]");
        scrollUntilFound(locator);
        return Adhkar.getText();


    }

    public String CheckVoluntaryOption() {
        By locator = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Voluntary')]");
        scrollUntilFound(locator);
        return Voluntary.getText();

    }
    public String CheckStartOmrahPathOption() {
        By locator = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Start')]");
        scrollUntilFound(locator);
        return startomrahbtn.getText();

    }


    public void CheckSettingsyOption() {
//        By locator = By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]");
//        scrollUntilFound(locator);
        WaitUtil.waitForElement(driver, Settingsbtn);
        Settingsbtn.click();

    }

}




//    public void StartOmrah(){
//        //  driver.executeScript("mobile: swipe", Map.of("direction", "down"));
//        WaitUtil.waitForElement(driver, startomrahbtn);
//        startomrahbtn.click();
//    }
//    public String checkopenstartomrah(){
//        WaitUtil.waitForElement(driver, startomrahcheck);
//        String text =  startomrahcheck.getText();
//        return text;
//    }



