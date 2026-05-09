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

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class SettingsScreen {

    private AppiumDriver driver;

    public SettingsScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    private By settingsTitle = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Settings') or contains(@name,'الإعدادات')]");
    private By themeSwitch = By.xpath("(//XCUIElementTypeSwitch[@visible='true'])[1]");


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]")
    private WebElement settingsButton;


    public void openSettingsPage() {
        ElementUtil.click(driver, settingsButton);
    }

    public String getSettingsPageTitle() {
        return ElementUtil.getText(driver, settingsTitle);
    }

    public WebElement getLanguageRowElement() {
        List<WebElement> texts = driver.findElements(By.xpath("//XCUIElementTypeStaticText"));

        for (WebElement element : texts) {
            if (!element.isDisplayed()) {
                continue;
            }

            Rectangle rectangle = element.getRect();
            String name = element.getAttribute("name");

            if (name == null || name.isEmpty()) {
                continue;
            }

            if (rectangle.getX() >= 20
                    && rectangle.getWidth() >= 300
                    && rectangle.getHeight() >= 60
                    && rectangle.getY() >= 150
                    && rectangle.getY() <= 260) {
                return element;
            }
        }

        throw new RuntimeException("Language row was not found");
    }

    public String getCurrentLanguageValue() {
        return getLanguageRowElement().getAttribute("name");
    }

    public void openLanguageMenu() {
        getLanguageRowElement().click();
    }

    public String extractLanguageName(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        String[] parts = text.split("\\n");
        return parts[parts.length - 1].trim();
    }

    public void selectDifferentLanguage() {
        String oldLanguage = getCurrentLanguageValue().trim();
        String currentLanguageName = extractLanguageName(oldLanguage);

        openLanguageMenu();

        List<WebElement> options = driver.findElements(
                By.xpath("//XCUIElementTypeButton[@name!='']")
        );

        for (WebElement option : options) {
            String optionName = option.getAttribute("name");

            if (optionName == null || optionName.isEmpty()) {
                continue;
            }

            optionName = optionName.trim();
            String optionLanguageName = extractLanguageName(optionName);

            if (!optionLanguageName.equals(currentLanguageName)) {
                option.click();
                return;
            }
        }

        throw new RuntimeException("No different language option was found");
    }

    public String getThemeValue() {
        return driver.findElement(themeSwitch).getAttribute("value");
    }

    public boolean toggleTheme() {
        WebElement switchElement = driver.findElement(themeSwitch);

        String before = switchElement.getAttribute("value");

        int x = switchElement.getRect().getX() + (switchElement.getRect().getWidth() / 2);
        int y = switchElement.getRect().getY() + (switchElement.getRect().getHeight() / 2);

        driver.executeScript("mobile: tap", Map.of(
                "x", x,
                "y", y
        ));

        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String after = driver.findElement(themeSwitch).getAttribute("value");

        return !before.equals(after);
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