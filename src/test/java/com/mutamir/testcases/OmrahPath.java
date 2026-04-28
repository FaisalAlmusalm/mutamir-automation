package com.mutamir.testcases;
import com.mutamir.base.Base;
import com.mutamir.screens.OmrahPathScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.awt.SystemColor.text;

public class OmrahPath extends Base {
    OmrahPathScreen omrahPathScreen;


    @Test
    public void testcase_01() throws InterruptedException {
        omrahPathScreen  = new OmrahPathScreen(driver);
        omrahPathScreen.StartOmrah();
        String text = omrahPathScreen.CheckStartOmrah();
        Assert.assertTrue(text.contains("Guidelines"));;
        Thread.sleep(1000);

    }


    @Test
    public void testcase_02()  {
        omrahPathScreen  = new OmrahPathScreen(driver);
        omrahPathScreen.clickOpenTawaf();


    }

    @Test
    public void testcase_03(){
        omrahPathScreen  = new OmrahPathScreen(driver);
        String text = omrahPathScreen.clickUntilEndTawaf();
        Assert.assertTrue(text.contains("Completed"));;


    }
@Test
    public void testcase_04()  {
    omrahPathScreen  = new OmrahPathScreen(driver);
    omrahPathScreen.clickStartsaii_btn();

}
    @Test
    public void testcase_05(){
        omrahPathScreen  = new OmrahPathScreen(driver);
        String text = omrahPathScreen.clickUntilEndSaii();
        Assert.assertTrue(text.contains("Sa'i"));


    }

    @Test
    public void testcase_06() throws InterruptedException {
        omrahPathScreen  = new OmrahPathScreen(driver);
        omrahPathScreen.clickTahallul_btn();


    }

    @Test
    public void testcase_07() throws InterruptedException {
        omrahPathScreen  = new OmrahPathScreen(driver);
        String text =    omrahPathScreen.checkcompletetahlil();
        Assert.assertTrue(text.contains("Tahallul Steps"));
        Thread.sleep(1000);


    }

    @Test
    public void testcase_08() throws InterruptedException {
        omrahPathScreen = new OmrahPathScreen(driver);
        omrahPathScreen.returnOmrah();
        Thread.sleep(1000);
        omrahPathScreen.confirmomrah();
    }

//    @Test
//    public void testcase_08() throws InterruptedException {
//        omrahPathScreen  = new OmrahPathScreen(driver);
//        omrahPathScreen.restomrahbtn();
//
//
//
//    }
//
//    @Test
//    public void testcase_09() throws InterruptedException {
//        omrahPathScreen  = new OmrahPathScreen(driver);
//        omrahPathScreen.confirmrestomrahbtn();
//
//
//
//    }
//    @Test
//    public void testcase_10() throws InterruptedException {
//        omrahPathScreen  = new OmrahPathScreen(driver);
//        omrahPathScreen.confirmrestomrahbtn();
//
//
//
//    }

//    @Test
//    public void testcase_11() throws InterruptedException {
//        omrahPathScreen  = new OmrahPathScreen(driver);
//        omrahPathScreen.Go_Home_Page();
//        Thread.sleep(1000);}



//    @Test
//    public void testcase_12() throws InterruptedException {
//        omrahPathScreen  = new OmrahPathScreen(driver);
//        String text =    omrahPathScreen.checkcompleteomrah();
//        Assert.assertTrue(text.contains("Completed"));
//        Thread.sleep(1000);}




}










