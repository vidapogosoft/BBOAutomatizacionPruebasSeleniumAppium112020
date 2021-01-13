package test;

import org.junit.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.io.File;

public class TestClassMobile1 {

    private static RemoteWebDriver driver = null;

    @Test
    public void TestApp() {
        try {

            File app = new File("E://Cursos//2020//SIPECOM//BBOTestNov2020//herramientas//AppiumMobile//", "ContactManager.apk");

            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("device", "Android");
            capabilities.setCapability(CapabilityType.VERSION,"8.0.0");
            capabilities.setCapability("app", app.getAbsolutePath());

            capabilities.setCapability("deviceName","G3223");
            capabilities.setCapability("platformName","Android");

            capabilities.setCapability("app-package","com.example.android.contactmanager-1");
            capabilities.setCapability("app-activity",".ContacManager");

            driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723"), capabilities);




        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }
}