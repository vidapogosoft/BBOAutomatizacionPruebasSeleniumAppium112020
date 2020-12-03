package SuiteTest;


//Clase con metodos de prueba

import org.junit.*;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class TestLogin {

    private static WebDriver driver = null;


    @BeforeClass
    public static void OpenWebbrowser()
    {
        System.setProperty("webdriver.chrome.driver"
                ,"E://Cursos//2020//SIPECOM//BBOTestNov2020//herramientas//chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.openfactapp.com");

    }

    @Test
    public void VerificarDireccionWeb()
    {
            String ActualWeb = "";
            String ExpectedWeb = "http://18.218.178.167/OpenFact/Account/Login.aspx";

             ActualWeb = driver.getCurrentUrl();

             //Assert.assertEquals(ExpectedWeb,ActualWeb);
    }

    @Test
    public void LoginWeb()
    {

        WebElement TxtUser = driver.findElement(By.id("LoginUser_UserName"));

        TxtUser.click();

        driver.findElement(By.id(("LoginUser_UserName"))).sendKeys("demo");
        driver.findElement(By.id(("LoginUser_Password"))).sendKeys("0430");

        driver.findElement(By.id("LoginUser_LoginButton")).click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void verificoIngreso()
    {
        String UrlValida = "http://18.218.178.167/OpenFact/Default.aspx";
        String UrlIngreso = "";

        UrlIngreso = driver.getCurrentUrl();

        //Assert.assertEquals(UrlValida,UrlIngreso);
    }

    @Test
    public void IrMenuClientes()  {
        //driver.navigate().to("http://18.218.178.167/OpenFact/FastFactEmisor/frmCliente.aspx");

        try {


            Thread.sleep(5000);

            driver.findElement(By.id("liClientes")).click();

        }  catch (InterruptedException e) {
        e.printStackTrace();
        }

    }

    @Test
    public void IngresarNuevCliente()  {

        /*
        //boton nuevo cliente: MainContent_btnAdd
        //cajas de texto: MainContent_txtNombreCliente
        //MainContent_txtIdentificacion
        //MainContent_txtTelefonoCelular
        //MainContent_txtDireccion
        //MainContent_txtMailDefecto
        //MainContent_ddlTipoIdentificacion
        //boton guardar cliente: MainContent_btnGuardarCliente

        //var BtnCliente = driver.findElement(By.xpath("//input[@name='submit']")).getAttribute("Agregar Nuevo Cliente");
        //System.out.println(BtnCliente);
        */

        //Thread.sleep(5000);

        WebDriverWait wait= new WebDriverWait(driver, 20);

        driver.findElement(By.id("MainContent_btnAdd")).click();


        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Selects en drop down list

        Select identificacion = new Select(driver.findElement(By.id("MainContent_ddlTipoIdentificacion")));
        identificacion.selectByVisibleText("Pasaporte");
        //identificacion.selectByIndex(2);


        Select estado = new Select(driver.findElement(By.id("MainContent_ddlEstado")));
        estado.selectByVisibleText("Activo");

        //Cehckbox
        WebElement chkBienvenida = driver.findElement(By.id("MainContent_cbxEnviarBienvenida"));
        chkBienvenida.click();


    }


    @AfterClass
    public static void CloseBrowser()
    {
        //driver.quit();
    }
}
