package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

import java.util.concurrent.TimeUnit;

public class Steps {

    WebDriver driver;

    @Given("Abre el web browser Chrome y direcciona a la aplicacion$")
    public void open_the_web_browser() throws Throwable
    {
        System.setProperty("webdriver.chrome.driver"
                ,"E://Cursos//2020//SIPECOM//BBOTestNov2020//herramientas//chromedriver.exe");

        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://openfactapp.com");

    }

    /*
    @When("Ingresa el username y password$")
    public void enter_credentials() throws Throwable
    {
        driver.findElement(By.id("LoginUser_UserName")).sendKeys("demo");
        driver.findElement(By.id("LoginUser_Password")).sendKeys("0430");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.id("LoginUser_LoginButton")).click();

    }*/

    @When("Ingresa el username \"(.*)\" y password \"(.*)\"$")
    public void enter_credentials_user_pwd(String user, String pwd) throws Throwable
    {
        driver.findElement(By.id("LoginUser_UserName")).sendKeys(user);
        driver.findElement(By.id("LoginUser_Password")).sendKeys(pwd);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.id("LoginUser_LoginButton")).click();

    }


    @Then("Estamos en la pagina principal$")
    public void Navigate() throws Throwable
    {
        Assert.assertEquals("OpenFact - Modulo de Administracion", driver.getTitle());
        driver.navigate().to("http://18.218.178.167/OpenFact/Default.aspx");
    }


    @And("Cierro web browser$")
    public void Quit ()throws Throwable
    {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.quit();
    }

}
