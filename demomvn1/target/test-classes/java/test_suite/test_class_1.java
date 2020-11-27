package test_suite;

import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_class_1 {

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
        //String ExpectedTitle = "Browser App test";
        String ExpectedTitle = "Sysnnova Solutions";
        //Sysnnova Solutions

        Assert.assertEquals(ActualTitle, ExpectedTitle);;

        driver.close();

    }

}
