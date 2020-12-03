package TestForElementsWeb;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;

public class TestForElements {

    private static WebDriver driver = null;


    @BeforeClass
    public static void OpenBrowser()
    {
        System.setProperty("webdriver.chrome.driver"
                ,"E://Cursos//2020//SIPECOM//BBOTestNov2020//herramientas//chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");

        //Espera a que la pagina procese en su backend
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }

    @Test
    public void NavegarWeb()
    {

        //  driver.navigate().forward();
        // driver.navigate().back();
        //driver.navigate().refresh();

        driver.navigate().to("https://demoqa.com/elements");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");

        try {

            driver.findElement(By.id("item-3")).click();

            Thread.sleep(5000);  //pausar la ejecucion a travez del hilo principal

            driver.findElement(By.id("item-1")).click();

            Thread.sleep(5000);

            driver.findElement(By.id("item-0")).click();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void Controles()
    {

        WebElement TxtFullName = driver.findElement(By.id("userName"));
        TxtFullName.sendKeys("Victor Daniel Portugal");

        driver.findElement(By.id(("userEmail"))).sendKeys("vidapogosoft@gmail.com");

        driver.findElement(By.id(("currentAddress"))).sendKeys("Miraflores Ave. Primera");

        driver.findElement(By.id(("permanentAddress"))).sendKeys("Solar 6413 Piso 2");

        try {
            Thread.sleep(5000);

            driver.navigate().to("https://demoqa.com/radio-button");

            driver.findElement(By.id("item-2")).click();

            //driver.findElement(By.id("yesRadio")).click();

            //driver.findElement(By.name("like")).click();

            //driver.findElement(By.cssSelector("input[id='yesRadio']")).click();

            //driver.findElement(By.xpath("//div/input[@id='yesRadio']")).click();

            WebElement radioBtn1 = driver.findElement(By.id("yesRadio"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioBtn1);


            Thread.sleep(5000);


            driver.navigate().to("https://demoqa.com/checkbox");

            //utilizamos xpath para obtner le valor del elemento web
            WebElement btnExpand = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
            btnExpand.click();

            WebElement Check = driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > span > label > span.rct-checkbox > svg"));
            Check.click();

            Thread.sleep(5000);

            //carga de elemetos en web
            driver.navigate().to("https://demoqa.com/upload-download");

            WebElement uploadElement = driver.findElement(By.id("uploadFile"));
            uploadElement.sendKeys("E://Cursos//2020//SIPECOM//BBOTestNov2020//image001.jpg");

            Thread.sleep(5000);

            driver.navigate().to("https://demoqa.com/select-menu");

            Select se = new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));

            //select by descripcion visible en pantalla
            se.selectByVisibleText("Magenta");

            // Select the option by index
            //se.selectByIndex(3);

            //selectByIndex
            //selectByValue
            //selectByVisibleText

            //Seleccion multiple
            Select oSel = new Select(driver.findElement(By.id("cars")));
            oSel.selectByValue("volvo");
            oSel.selectByValue("audi");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @AfterClass
    public static void CloseBrowser()
    {
        //driver.quit();  //cierra la pantalla actual
        //driver.close(); //cierra todas laventanas abiertas
    }


}
