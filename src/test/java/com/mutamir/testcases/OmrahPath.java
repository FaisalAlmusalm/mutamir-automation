package com.mutamir.testcases;

import com.mutamir.base.Base;
import com.mutamir.screens.OmrahPathScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OmrahPath extends Base {
    OmrahPathScreen omrahPathScreen;

    @BeforeMethod
    public void setUpScreen() {
        omrahPathScreen = new OmrahPathScreen(driver);
    }

    @Test(priority = 1)
    public void StartOmrah() throws InterruptedException {
        omrahPathScreen.startOmrah();
        String text = omrahPathScreen.getStartOmrahCheckText();
        Assert.assertTrue(text.contains("Guidelines"));
        ;
        Thread.sleep(1000);


        omrahPathScreen.openTawaf();
        String textCompleted = omrahPathScreen.clickUntilEndTawaf();
        Assert.assertTrue(textCompleted.contains("Completed"), "tawaf did not complete");


        omrahPathScreen.openSaii();
        String textSaii = omrahPathScreen.clickUntilEndSaii();
        Assert.assertTrue(textSaii.contains("Sa'i"), "Saii did not complete ");


        omrahPathScreen.openTahallul();
        String textTahallul = omrahPathScreen.getTahallulCompletedText();
        Assert.assertTrue(textTahallul.contains("Tahallul Steps"));

    }


    }











