package com.mutamir.screens;

import com.mutamir.utils.ElementUtil;
import com.mutamir.utils.WaitUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static com.mutamir.base.Base.driver;
import static com.mutamir.utils.ScrollUtil.scrollUntilFound;

public class OmrahPathScreen  {

    public OmrahPathScreen(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }


    By StartOmrahBtn = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Start Umrah')]");
//---------------------------------------
    By StartOmrahCheck = By.xpath("d//XCUIElementTypeStaticText[contains(@name,'Guidelines')]");
//-----------------------------------------
By Tawaf = By.xpath("//*[contains(@name,'Kaaba')]");
//---------------------------------------------------
    By Tawaf_Completed =By.xpath("//XCUIElementTypeStaticText[contains(@name,'Tawaf Completed')]");
 //---------------------------------------------------------
// By Saii = By.xpath("//XCUIElementTypeStaticText[contains(@name,\"Sa'i\")]/..");
    @iOSXCUITFindBy(accessibility = "Sa'i →")
    WebElement Saiibtn;
   //--------------------------------------------------------
 //  By Saii_Completed =By.xpath("//XCUIElementTypeStaticText[contains(@name,'Completed']");
    @iOSXCUITFindBy(accessibility = "Sa'i Completed — Masha'Allah")
    WebElement Saii_Completed;
 //---------------------------------------------------------------------------
 // By Tahallulbtn =By.xpath("//XCUIElementTypeStaticText[contains(@name,'Tahallul]");
    @iOSXCUITFindBy(accessibility = "Tahallul →")
    WebElement Tahallulbtn;

//-----------------------------------------------------------------------
  // By Tahallul_Completed =By.xpath("//XCUIElementTypeStaticText[contains(@name,'Tahallul Steps']");
    @iOSXCUITFindBy(accessibility = "Tahallul Steps")
    WebElement Tahallul_Completed;
  //--------------------------------------------------------------

  By resetOmrahbtn =By.xpath("//XCUIElementTypeStaticText[contains(@name,'Reset Umrah Progress']");
    @iOSXCUITFindBy(accessibility = "Reset Umrah Progress")
    WebElement Reset_Umrah ;
 // @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name CONTAINS \\\"Reset\\\"`]")
   //  WebElement confirmresetomrah;
@iOSXCUITFindBy(iOSNsPredicate = "name == \"Reset Umrah Progress\" AND label == \"Reset Umrah Progress\" AND type == \"XCUIElementTypeButton\"")
 WebElement Reset_Umrah_confirm ;
   // By Reset_Umrah_confirm = By.xpath("//XCUIElementTypeButton[@y='481']");

    By confirmBtn = By.xpath("(//*[contains(@name,'Reset Umrah Progress')])[2]");
   //-------------------------------------

  //  By returnhome = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Home']");
    @iOSXCUITFindBy(accessibility = "Return to Home")
    WebElement returnhome;
    //------------------------------------------

   // By Completed_omrah = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Completed']");
    @iOSXCUITFindBy(accessibility = "Completed")
    WebElement Completed_omrah;


        public void StartOmrah(){
            WaitUtil.waitForElement(driver, StartOmrahBtn);
            ElementUtil.click(driver,StartOmrahBtn);
        }


    public String CheckStartOmrah() throws InterruptedException {
        WaitUtil.waitForElement(driver, StartOmrahCheck);
        String text =  ElementUtil.getText(driver,StartOmrahCheck);
        return text;
    }

    public void clickOpenTawaf() {

        scrollUntilFound(driver, Tawaf);

        driver.findElement(Tawaf).click();
    }







    public String clickUntilEndTawaf() {
        By nextBtn = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Next')]");
        while (true) {
            // إذا ما فيه Next → خلاص وصلنا النهاية
            if (driver.findElements(nextBtn).isEmpty()) {
                System.out.println("وصلت آخر صفحة ✅");
              return   ElementUtil.getText(driver,Tawaf_Completed);
            }
            driver.findElement(nextBtn).click();

            try {
                Thread.sleep(1500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

public void clickStartsaii_btn(){
ElementUtil.click(driver,Saiibtn);
}

    public String clickUntilEndSaii() {

        By nextBtn = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Next Round')]");

        while (true) {

            // إذا ما فيه Next → خلاص وصلنا النهاية
            if (driver.findElements(nextBtn).isEmpty()) {
                System.out.println("وصلت آخر صفحة ✅");
               return ElementUtil.getText(driver,Saii_Completed);

            }

            driver.findElement(nextBtn).click();

            try {
                Thread.sleep(1500);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }



    }
    public void clickTahallul_btn(){
        ElementUtil.click(driver,Tahallulbtn);
    }

    public String checkcompletetahlil(){
     return ElementUtil.getText(driver,Tahallul_Completed);
    }

//    public void restomrahbtn(){
//        WaitUtil.waitForElement(driver, resetOmrahbtn);
//        resetOmrahbtn.click();
//    }
//
//        public void confirmrestomrahbtn() {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(confirmBtn));
//            driver.findElement(confirmBtn).click();
//        }

    public void Go_Home_Page(){
        ElementUtil.click(driver,returnhome);
    }

    public void returnOmrah(){
ElementUtil.click(driver,Reset_Umrah);
    }

    public void confirmomrah(){
            ElementUtil.click(driver,Reset_Umrah_confirm);
    }




      public String checkcompleteomrah(){
        WaitUtil.waitForElement(driver, Completed_omrah);
        return   ElementUtil.getText(driver,Completed_omrah);
}
      }