package test;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class TestClassMobile3 {

    private static RemoteWebDriver driverApp = null;

    @Test
    public void TestAppInstalled()
    {

        DesiredCapabilities capability = new DesiredCapabilities();

        capability.setCapability("device","RQ300729UE");
        capability.setCapability("deviceName","G3223");
        capability.setCapability("platformName","Android");
        capability.setCapability("noSign",true);
        capability.setCapability("autoGrantPermissions",true);
        capability.setCapability("allowTestPackages",true);

        capability.setCapability("appPackage","com.example.componentes");
        capability.setCapability("appActivity",".MainActivity");

        try {

            driverApp = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capability);

            System.out.println("App installed launch");

            driverApp.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //click sobre un lemento de la lista

            driverApp.findElement(By.xpath("//android.view.View[@content-desc=\"Inputs\"]")).click();

            driverApp.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]"))
                    .click();

            driverApp.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]"))
                    .sendKeys("Vpr vidapogosoft");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

}
