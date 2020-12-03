package SuiteTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class TestForm {

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

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }

    @Test
    public void DireccionarWeb()
    {

        driver.navigate().to("https://demoqa.com/elements");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");

        driver.findElement(By.id("item-0")).click();


    }


    @Test
    public void SelectData() {

        //driver.findElement(By.id(("firstName"))).sendKeys("Victor");

        //driver.findElement(By.id("hobbies-checkbox-1")).click();

        /*
        WebElement Rdb = driver.findElement(By.id("gender-radio-1"));
        boolean stateselect = Rdb.isSelected();
        if(stateselect == false)
        {
            //Rdb.click();
        }
        */
        //Rdb.isSelected();
        //Rdb.getAttribute("checked");

        //Select estado = new Select(driver.findElement(By.id("MainContent_ddlEstado")));
        //estado.selectByVisibleText("Activo");

        //valu de fecha

        /*
        WebElement fecha = driver.findElement(By.id("dateOfBirthInput"));
        fecha.clear();
        fecha.sendKeys("10 Dec 1900");
        fecha.click();
        */

        //seleccionar elemntos de una tabla

        //driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div/div[1]")).getText();

    }


    @Test
    public void Upload()
    {
        /*
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));

        Actions MoveBuilder = new Actions(driver);
        Action  mouseOver = MoveBuilder.moveToElement(uploadElement).build();

        uploadElement.sendKeys("E://Cursos//2020//SIPECOM//BBOTestNov2020//image001.jpg");
        */
    }

}
