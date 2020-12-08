package DataPoolSQLServer1;


import TestDataExcel.ReadExcelFile;
import TestDataExcel.WriteExcelFile;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLException;


public class DataDriveTest {

    private WriteSQLServer writesql;
    private ReadSQLServer readsql;

    private WebDriver driver;

    private By searchBoxLocator = By.id("search_query_top");
    private By searchBtnLocator = By.name("submit_search");
    //span.heading-counter
    private By resultTextLocator = By.cssSelector("span.heading-counter");


    @Before
    public void Open()
    {
        writesql = new WriteSQLServer();
        readsql = new ReadSQLServer();

        System.setProperty("webdriver.chrome.driver"
                ,"E://Cursos//2020//SIPECOM//BBOTestNov2020//herramientas//chromedriver.exe");

        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");


    }

    @After
    public void Quit()
    {
        driver.close();
    }

    @Test
    public void test() throws SQLException, ClassNotFoundException
    {
        String search = readsql.GetValueTable(1);

        driver.findElement(searchBoxLocator).sendKeys(search);
        driver.findElement(searchBtnLocator).click();

        String resultado = driver.findElement(resultTextLocator).getText();

        writesql.WriteValueTable(1, resultado);

    }


}
