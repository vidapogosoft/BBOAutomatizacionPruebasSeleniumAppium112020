package suite.test;

import org.junit.Assert;
import org.junit.Test;

import org.testng.asserts.SoftAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testasserts {

    @Test
    public void testAssertFunctions() {

        SoftAssert softAssert = new SoftAssert();

        System.setProperty("webdriver.chrome.driver", "E://Cursos//2020//SIPECOM//BBOTestNov2020//herramientas//chromedriver.exe");

        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.sysnnovasolutions.com/");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Browser app test";
        //Assert.assertEquals(ExpectedTitle, ActualTitle);

        softAssert.assertEquals(ActualTitle, ExpectedTitle);

        softAssert.assertAll();

    }

}
