package test.suite;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class test_before_after {

    private static WebDriver driver = null;

    @Before
    public void openbrowser()
    {
        System.out.print("Browser Open");

        System.setProperty("webdriver.chrome.driver"
                ,"E://Cursos//2020//SIPECOM//BBOTestNov2020//herramientas//chromedriver.exe");

        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.sysnnovasolutions.com/");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

    }

    @After
    public void closebrowser()
    {
        System.out.print("\nBrowser close");
        System.out.print("\nFinaliza todo el proceso");

        driver.quit();
    }


    @Test
    public void TestHardAssert()
    {
        System.out.println("Ejecuto test hard assert");

        String ActualTitle = driver.getTitle();
        //String ExpectedTitle = "Browser App test";
        String ExpectedTitle = "Sysnnova Solutions";

        Assert.assertEquals(ExpectedTitle,ActualTitle);
    }

    @Test
    public void TestSoftAssert()
    {
        System.out.println("Ejecuto test soft assert");
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Browser App test";

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(ActualTitle, ExpectedTitle);

        //visualiza todoas las asesrciones ejecutadas
        softAssert.assertAll();

    }

}
