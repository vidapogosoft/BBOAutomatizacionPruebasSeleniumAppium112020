package test;

import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestClass {

        private static WindowsDriver CalculatorSession = null;
        private static WebElement CalculatorResult = null;

        @BeforeClass
        public static void Setup() {

            try{

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
                //capabilities.setCapability("app", "C://Windows//System32//notepad.exe");
                CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);

                CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

                CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");

                Assert.assertNotNull(CalculatorResult);


            }catch (Exception e)
            {
                e.printStackTrace();
            }finally {}

        }

        @Test
        public void Suma()
        {
            CalculatorSession.findElementByName("Uno").click();
            CalculatorSession.findElementByName("Más").click();
            CalculatorSession.findElementByName("Siete").click();
            CalculatorSession.findElementByName("Es igual a").click();

            Assert.assertEquals("8", GetCalculatoResult());

        }

        @Test
        public void resta()
        {
            CalculatorSession.findElementByName("Nueve").click();
            CalculatorSession.findElementByName("Menos").click();
            CalculatorSession.findElementByName("Dos").click();
            CalculatorSession.findElementByName("Es igual a").click();

            Assert.assertEquals("7", GetCalculatoResult());

        }

        public String GetCalculatoResult()
        {
            return CalculatorResult.getText().replace("La pantalla muestra","").trim();
        }

}
