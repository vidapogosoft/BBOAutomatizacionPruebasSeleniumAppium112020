package DataPoolSQLServer;

import TestDataExcel.ReadExcelFile;
import TestDataExcel.WriteExcelFile;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.sql.SQLException;

public class DataDrivetest {

    private WebDriver driver;
    private WriteSqlServer writesql;
    private ReadSqlServer readsql;

    private By searchBoxLocator = By.id("search_query_top");
    private By searchBtnLocator = By.name("submit_search");
    //span.heading-counter
    private By resultTextLocator = By.cssSelector("span.heading-counter");

    @Before
    public void Open()
    {
        writesql = new WriteSqlServer();
        readsql = new ReadSqlServer();

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
    public void test() throws SQLException, ClassNotFoundException {

        String searchtext = readsql.GetValue(1);

        driver.findElement(searchBoxLocator).sendKeys(searchtext);

        driver .findElement(searchBtnLocator).click();

        String resulttext = driver.findElement(resultTextLocator).getText();

        System.out.println("Resultado: " + resulttext);

        writesql.WriteValue(1,resulttext);

    }



}
