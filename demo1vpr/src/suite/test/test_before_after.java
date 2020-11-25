package suite.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import org.junit.Assert;

import org.junit.After;

import org.junit.Before;


public class test_before_after {

    private static WebDriver driver = null;

    @Before
    public void openbrowser() {
        System.out.print("\nBrowser open");
        // set geckodriver path.
        System.setProperty("webdriver.chrome.driver", "E://Cursos//2020//SIPECOM//BBOTestNov2020//herramientas//chromedriver.exe");
        //initialize firefox driver.
        driver  = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.sysnnovasolutions.com/");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

    }


    @After
    public void closebrowser() {
        System.out.print("\nBrowser close");
        System.out.print("\nFinaliza todo el proceso");
        driver.quit();
    }



    @Test
    public void testAssertFunctions() {

        try {

            //SoftAssert softAssert = new SoftAssert();

            String ActualTitle = driver.getTitle();

            String ExpectedTitle = "Sysnnova Solutions";

            Assert.assertEquals(ExpectedTitle, ActualTitle);

            //softAssert.assertEquals(ActualTitle, ExpectedTitle);

            Thread.sleep(2000);

            System.out.print("\nEjecuto metodo @test");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
