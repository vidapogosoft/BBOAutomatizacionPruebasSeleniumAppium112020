package TestForFormWeb;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

        driver.get("https://demoqa.com/automation-practice-form");

    }

    @Test
    public void Controles() {

        try {

            driver.findElement(By.id(("firstName"))).sendKeys("Vpr");
            driver.findElement(By.id(("lastName"))).sendKeys("vidapogosoft");
            driver.findElement(By.id(("userEmail"))).sendKeys("vidapogosoft@gmail.com");
            driver.findElement(By.id(("userNumber"))).sendKeys("0960574445");
            driver.findElement(By.id(("subjectsInput"))).sendKeys("Curso de Automatizacion con Selenium");

        WebElement radioBtnMale = driver.findElement(By.id("gender-radio-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioBtnMale);


        WebElement ChekHobbie1 = driver.findElement(By.id("hobbies-checkbox-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", ChekHobbie1);


        WebElement ChekHobbie2 = driver.findElement(By.id("hobbies-checkbox-3"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", ChekHobbie2);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='dateOfBirthInput']")));
        actions.click();
        actions.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(3000);
        actions.sendKeys("12-10-1980");
        actions.sendKeys(Keys.ESCAPE);
        actions.build().perform();

            driver.findElement(By.id(("currentAddress"))).click();
            driver.findElement(By.id(("currentAddress"))).sendKeys("Miraflores");


            WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
            uploadElement.sendKeys("E://Cursos//2020//SIPECOM//BBOTestNov2020//image001.jpg");

            WebElement Select1 = driver.findElement(By.id("react-select-3-input"));
            Select1.sendKeys("NCR");
            Select1.sendKeys(Keys.TAB);

            WebElement Select2 = driver.findElement(By.id("react-select-4-input"));
            Select2.sendKeys("Delhi");
            Select2.sendKeys(Keys.TAB);

            driver.findElement(By.id(("submit"))).click();

            Thread.sleep(3000);



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
