package test;

import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestClassWinForm {

    private static  WindowsDriver NewSessionExe = null;

    @Test
    public void RegistroDatos()
    {

        try {

            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("app",
                    "E://Cursos//2020//SIPECOM//BBOTestNov2020//herramientas//Appium//AppWinForm1.exe");

            NewSessionExe = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);

            NewSessionExe.findElementByAccessibilityId("TxtIdentificacion").click();
            NewSessionExe.findElementByAccessibilityId("TxtIdentificacion").sendKeys("09191725551");

            NewSessionExe.findElementByAccessibilityId("TxtNombres").click();
            NewSessionExe.findElementByAccessibilityId("TxtNombres").sendKeys("Victor Daniel Portugal");

            NewSessionExe.findElementByAccessibilityId("TxtDireccion").click();
            NewSessionExe.findElementByAccessibilityId("TxtDireccion").sendKeys("Miraflores Avenida Primera");

            NewSessionExe.findElementByAccessibilityId("RdCasado").click();

            NewSessionExe.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            NewSessionExe.findElementByName("Confirmar Datos").click();

            NewSessionExe.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            String TextoIdentificacion = NewSessionExe.findElementByAccessibilityId("LblIdentificacion").getText();
            String TextoNombres = NewSessionExe.findElementByAccessibilityId("LblNombres").getText();
            String TextoDireccion = NewSessionExe.findElementByAccessibilityId("LblDireccion").getText();

            System.out.println(TextoIdentificacion);
            System.out.println(TextoNombres);
            System.out.println(TextoDireccion);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }finally {}

    }

    @AfterClass
    public static void Cerrar()
    {
        if (NewSessionExe != null)
        {
            NewSessionExe.quit();
        }
        NewSessionExe = null;
    }

}
