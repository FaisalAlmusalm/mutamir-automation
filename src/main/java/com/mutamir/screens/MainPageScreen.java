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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageScreen {

    private AppiumDriver driver;

    public MainPageScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]")
    private WebElement settingsButton;

    @iOSXCUITFindBy(accessibility = "Umrah Path")
    private WebElement umrahPath;

    @iOSXCUITFindBy(accessibility = "Start Umrah")
    private WebElement startUmrahButton;
    private  By checkOpenPathOmrah = By.xpath(
            "//XCUIElementTypeStaticText[contains(@name,'correctly')]"
    );


    private  By ClickBacktoHomePage = By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther");

    private By mainTitle = By.xpath("//XCUIElementTypeStaticText[@name='Mutamir' or @name='مُعْتَمِر']");
    private By umrahPathTitle = By.xpath("//XCUIElementTypeStaticText[@name='Umrah Path' or @name='مسار العمرة']");
    private By guidelinesOption = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Guidelines') or contains(@name,'إرشادات')]");
    private By supplicationsOption = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Supplications') or contains(@name,'أدعية')]");
    private By CheckOpenSupplications = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Supplications')]");
    private By prayerTimesOption = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Prayer') or contains(@name,'المواقيت')]");
    private By CheckOpenPrayerTime = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Prayer Times')]");
    private By prayerBackHomePage = By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]");
    private By qiblaDirectionOption = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Qibla') or contains(@name,'اتجاه القبلة')]");
    private By qiblaBackHomePage = By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]");
    private By getText_Point_Qibla = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Point')]");
    private By adhkarOption = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Adhkar') or contains(@name,'الأذكار')]");
    private By adhkarText = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Adhkar')]");
    private By adhkarBackHomePage = By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]");
    private By voluntaryOption = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Voluntary') or contains(@name,'النافلة')]");
    private By startUmrahmain = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Start') or contains(@name,'ابدأ العمرة')]");
    private By startumrahbtn = By.xpath("//XCUIElementTypeButton[@name='Start Umrah']");
    private By ResetOmrahtext = By.xpath("//XCUIElementTypeStaticText[@name='Reset Umrah Progress']");
    private By Cancelbtn = AppiumBy.accessibilityId("Cancel");


    public boolean getSettingAvalible() {

       return ElementUtil.isPresent(driver,settingsButton);
    }



    public String getMainPageTitle() {
        return ElementUtil.getText(driver, mainTitle);
    }

    public String getUmrahPathText() {
        return driver.findElement(umrahPathTitle).getText();
    }

    public String getGuidelinesText() {
        ScrollUtil.scrollDownUntilFound(driver,guidelinesOption);
        return driver.findElement(guidelinesOption).getText();
    }


    public String getSupplicationsText() {
        ScrollUtil.scrollDownUntilFound(driver,supplicationsOption);

        return driver.findElement(supplicationsOption).getText();
    }

    public String getPrayerTimesText() {
        ScrollUtil.scrollDownUntilFound(driver,prayerTimesOption);
        return ElementUtil.getText(driver, prayerTimesOption);
    }

    public String getQiblaDirectionText() {
        ScrollUtil.scrollDownUntilFound(driver,qiblaDirectionOption);
        return ElementUtil.getText(driver, qiblaDirectionOption);

    }

    public String getAdhkarText() {
        ScrollUtil.scrollDownUntilFound(driver,adhkarOption);
        return ElementUtil.getText(driver, adhkarOption);
    }

    public String getVoluntaryText() {
        ScrollUtil.scrollDownUntilFound(driver,voluntaryOption);
        return ElementUtil.getText(driver, voluntaryOption);
    }

    public String getStartUmrahText() {
        ScrollUtil.scrollDownUntilFound(driver, startUmrahmain);
        return ElementUtil.getText(driver, startUmrahmain);
    }
    public String openStartUmrah() {

        ElementUtil.click(driver, startUmrahButton);

        if (ElementUtil.isPresent(driver, ResetOmrahtext)) {

            System.out.println("Reset Umrah popup appeared");

            WaitUtil.waitForElement(driver, startumrahbtn);

            ElementUtil.click(driver, startumrahbtn);
        }

        String text = ElementUtil.getText(driver, checkOpenPathOmrah);

        ElementUtil.click(driver, ClickBacktoHomePage);

        return text;
    }




    public String Guidelines(){
        ElementUtil.click(driver, guidelinesOption);
        String text = ElementUtil.getText(driver,checkOpenPathOmrah);
        ElementUtil.click(driver, ClickBacktoHomePage);
        return text;
    }


    public String supplications(){
        ElementUtil.click(driver, supplicationsOption);
        String text = ElementUtil.getText(driver,CheckOpenSupplications);
        ElementUtil.click(driver, ClickBacktoHomePage);

        return text;
    }

    public String Open_Prayer_Times(){
        ElementUtil.click(driver, prayerTimesOption);
        String text = ElementUtil.getText(driver,CheckOpenPrayerTime);
        ElementUtil.click(driver, prayerBackHomePage);

        return text;
    }
    public String Open_direction(){
       // ElementUtil.click(driver, qiblaDirectionOption);
        driver.findElement(qiblaDirectionOption).click();
   //    String text = ElementUtil.getText(driver,getText_Point_Qibla);
        String text =   new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(getText_Point_Qibla)).getText();
        ElementUtil.click(driver, qiblaBackHomePage);
        return text;
    }

    public String Opendadhkar(){
        driver.findElement(adhkarOption).click();
        String text =   new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(adhkarText)).getText();
            ElementUtil.click(driver, adhkarBackHomePage);
        return text;
    }





}








