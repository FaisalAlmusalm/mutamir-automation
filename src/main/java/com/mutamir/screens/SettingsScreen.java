package com.mutamir.screens;

import com.mutamir.utils.ElementUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static com.mutamir.base.Base.driver;

public class SettingsScreen {

    public SettingsScreen(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]")
    WebElement settingsBtn;

    @iOSXCUITFindBy(accessibility = "Settings")
    WebElement settingCheck;
    //======================================

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Language\\nEnglish\"`]")
    WebElement lanquage_btn;
    //   By languageOption = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Language\\nEnglish\"`]");

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"زبان\n" +
            "اردو\"`]")
    WebElement otherlanguage;
    By languageRow = By.xpath("(//XCUIElementTypeStaticText[@name='General']/following-sibling::XCUIElementTypeStaticText)[1]");
    By languageOptions = By.xpath("//XCUIElementTypeButton[@name!='']");
    //======================================

    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='الوضع الداكن']/following-sibling::XCUIElementTypeSwitch[1]")
    // WebElement themeSwitch;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`value == \"1\"`]")
    WebElement darkSwitch;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`value == \"0\"`][1]")
    WebElement lightSwitch;

//====================================================

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Select City')]")
    WebElement selectCity;

    @iOSXCUITFindBy(accessibility = "Search city...")
    WebElement Search_city;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name CONTAINS \"Dark Mode\"`]/**/XCUIElementTypeSwitch")
    WebElement location;

    @iOSXCUITFindBy(accessibility = "24-hour")
    WebElement TimeFormat;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`value == \"1\"`][2]")
    WebElement Athan;


    public void OpenSettingsPage() {
        ElementUtil.click(driver, settingsBtn);
    }

    public String checkopenSettingPage() {
        return ElementUtil.getText(driver, settingCheck);
    }

    public WebElement getLanguageRowElement() {

        List<WebElement> texts = driver.findElements(By.xpath("//XCUIElementTypeStaticText"));

        for (WebElement el : texts) {
            if (!el.isDisplayed()) {
                continue;
            }

            Rectangle r = el.getRect();
            String name = el.getAttribute("name");

            if (name == null || name.isEmpty()) {
                continue;
            }

            // صف اللغة في الإعدادات يكون عنصر كبير نسبيًا
            if (r.getX() >= 20 && r.getWidth() >= 300 && r.getHeight() >= 60 && r.getY() >= 150 && r.getY() <= 260) {
                return el;
            }
        }

        throw new RuntimeException("ما لقيت صف اللغة");
    }

    public String getCurrentLanguageValue() {
        return getLanguageRowElement().getAttribute("name");
    }

    public void openLanguageMenu() {
        getLanguageRowElement().click();
    }

    private String extractLanguageName(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        String[] parts = text.split("\\n");
        return parts[parts.length - 1].trim();
    }

    public void selectDifferentLanguage() {

        String oldLanguage = getCurrentLanguageValue().trim();
        String currentLangName = extractLanguageName(oldLanguage);

        System.out.println("اللغة الحالية: " + oldLanguage);
        System.out.println("اسم اللغة الحالية: " + currentLangName);

        openLanguageMenu();

        List<WebElement> options = driver.findElements(By.xpath("//XCUIElementTypeButton[@name!='']"));

        for (WebElement option : options) {
            String optionName = option.getAttribute("name");

            if (optionName == null || optionName.isEmpty()) {
                continue;
            }

            optionName = optionName.trim();
            String optionLangName = extractLanguageName(optionName);

            System.out.println("option = " + optionName);
            System.out.println("optionLangName = " + optionLangName);

            if (!optionLangName.equals(currentLangName)) {
                option.click();
                return;
            }
        }

        throw new RuntimeException("ما لقيت لغة مختلفة عن الحالية");
    }


    public void verifyLanguageChanged(String oldLanguage) {

        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String newLanguage = getCurrentLanguageValue().trim();

        Assert.assertNotEquals(
                extractLanguageName(newLanguage),
                extractLanguageName(oldLanguage),
                "اللغة ما تغيرت"
        );
    }

    By allSwitches = By.xpath("//XCUIElementTypeSwitch");

    public WebElement getThemeSwitch() {
        List<WebElement> switches = driver.findElements(allSwitches);

        for (WebElement sw : switches) {
            if (sw.isDisplayed()) {
                return sw;   // أول switch ظاهر = dark mode
            }
        }

        throw new RuntimeException("ما لقيت theme switch");
    }

    By themeSwitch = By.xpath("(//XCUIElementTypeSwitch[@visible='true'])[1]");

    public String getThemeValue() {
        return driver.findElement(themeSwitch).getAttribute("value");
    }

    public void toggleTheme() {

        WebElement sw = driver.findElement(themeSwitch);

        String before = sw.getAttribute("value");

        int x = sw.getRect().getX() + (sw.getRect().getWidth() / 2);
        int y = sw.getRect().getY() + (sw.getRect().getHeight() / 2);

        driver.executeScript("mobile: tap", Map.of(
                "x", x,
                "y", y
        ));

        try {
            Thread.sleep(1500);
        } catch (Exception e) {
        }

        String after = driver.findElement(themeSwitch).getAttribute("value");

        System.out.println("before = " + before);
        System.out.println("after = " + after);

        if (before.equals(after)) {
            throw new RuntimeException("الثيم ما تغير ❌");
        }
    }


    public WebElement getSelectCityRow() {

        By cityRowLocator = By.xpath(
                "//*[contains(@name,'Select City') " +
                        "or contains(@name,'City') " +
                        "or contains(@name,'اختر المدينة') " +
                        "or contains(@name,'المدينة') " +
                        "or contains(@name,'شہر') " +
                        "or contains(@name,'Makkah') " +
                        "or contains(@name,'مكة') " +
                        "or contains(@label,'Select City') " +
                        "or contains(@label,'City') " +
                        "or contains(@label,'اختر المدينة') " +
                        "or contains(@label,'المدينة') " +
                        "or contains(@label,'شہر') " +
                        "or contains(@label,'Makkah') " +
                        "or contains(@label,'مكة')]"
        );

        try {
            return new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(cityRowLocator));
        } catch (Exception e) {
            driver.executeScript("mobile: scroll", Map.of("direction", "down"));

            return new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(cityRowLocator));
        }
    }
    public void selectCity(String cityName) {

        By searchField = By.xpath("//XCUIElementTypeTextField");

        if (driver.findElements(searchField).isEmpty()) {
            getSelectCityRow().click();
        }

        WebElement search = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(searchField));

        search.click();
        search.clear();
        search.sendKeys(cityName);

        By cityResult = By.xpath(
                "//XCUIElementTypeButton[@name='" + cityName + "' or @label='" + cityName + "']"
        );

        WebElement city = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(cityResult));

        city.click();
    }









}


