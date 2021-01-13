package test;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestClassMobile1 {

    private static RemoteWebDriver driver = null;

    @Test
    public void TestApp() {
        try {

            File app = new File("E://Cursos//2020//SIPECOM//BBOTestNov2020//herramientas//AppiumMobile//", "ContactManager.apk");

            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("device","RQ300729UE");
            //capabilities.setCapability(CapabilityType.VERSION,"8.0.0");
            capabilities.setCapability("app", app.getAbsolutePath());

            capabilities.setCapability("deviceName","G3223");
            capabilities.setCapability("platformName","Android");

            //capabilities.setCapability("app-package","com.example.android.contactmanager-1");
            //capabilities.setCapability("app-activity",".ContacManager");

            driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);


            System.out.println("App launched");
            // locate Add Contact button and click it
            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Add Contact\"]")).click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.TableLayout/android.widget.TableRow[4]/android.widget.EditText")).click();

            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.TableLayout/android.widget.TableRow[4]/android.widget.EditText")).sendKeys("vpr test appium");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }

    /*
    @AfterClass
    public static void Cerrar()
    {
        if (driver != null)
        {

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.quit();
        }
        driver = null;
    }
    */
}