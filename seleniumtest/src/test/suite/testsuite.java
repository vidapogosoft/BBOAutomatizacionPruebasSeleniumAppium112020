package test.suite;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.asserts.SoftAssert;

public class testsuite {

    @Test
    public void TestAssertFunctions()
    {
        System.setProperty("webdriver.chrome.driver"
                ,"E://Cursos//2020//SIPECOM//BBOTestNov2020//herramientas//chromedriver.exe");

        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.sysnnovasolutions.com/");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        //aplicando hard assert

        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Browser App test";
        //String ExpectedTitle = "Sysnnova Solutions";
        //Sysnnova Solutions

        Assert.assertEquals(ActualTitle, ExpectedTitle);;

        driver.close();

    }

    @Test
    public void TestAssertFunctionsCorrect()
    {
        System.setProperty("webdriver.chrome.driver"
                ,"E://Cursos//2020//SIPECOM//BBOTestNov2020//herramientas//chromedriver.exe");

        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.sysnnovasolutions.com/");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        //aplicando hard assert

        String ActualTitle = driver.getTitle();
        //String ExpectedTitle = "Browser App test";
        String ExpectedTitle = "Sysnnova Solutions";
        //Sysnnova Solutions

        Assert.assertEquals(ActualTitle, ExpectedTitle);;

    }

    @Test
    public void TestSoftAssertFunctions()
    {
        System.setProperty("webdriver.chrome.driver"
                ,"E://Cursos//2020//SIPECOM//BBOTestNov2020//herramientas//chromedriver.exe");

        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.sysnnovasolutions.com/");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Browser App test";
        //String ExpectedTitle = "Sysnnova Solutions";

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(ActualTitle, ExpectedTitle);


        driver.close();

        //visualiza todoas las asesrciones ejecutadas
        softAssert.assertAll();

    }

}
