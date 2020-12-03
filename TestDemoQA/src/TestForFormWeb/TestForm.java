package TestForFormWeb;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
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


        WebElement radioBtnMale = driver.findElement(By.id("gender-radio-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioBtnMale);


        WebElement ChekHobbie1 = driver.findElement(By.id("hobbies-checkbox-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", ChekHobbie1);


        WebElement ChekHobbie2 = driver.findElement(By.id("hobbies-checkbox-3"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", ChekHobbie2);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='dateOfBirth']")));
        actions.click();
        actions.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(3000);
        actions.sendKeys("10 Dec 1980");
        actions.sendKeys(Keys.TAB);
        actions.build().perform();


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
