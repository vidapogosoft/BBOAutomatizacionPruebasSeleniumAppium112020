package TestDataExcel;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class DataDriveTest {

    private WebDriver driver;
    private WriteExcelFile writeFile;
    private ReadExcelFile readFile;

    private By searchBoxLocator = By.id("search_query_top");
    private By searchBtnLocator = By.name("submit_search");
    //span.heading-counter
    private By resultTextLocator = By.cssSelector("span.heading-counter");


    @Before
    public void Open()
    {
        writeFile = new WriteExcelFile();
        readFile = new ReadExcelFile();

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
    public void test() throws IOException
    {
        String filepath = "E:\\Cursos\\2020\\SIPECOM\\BBOTestNov2020\\herramientas\\Test.xlsx";

        String searchtext = readFile.getCellValue(filepath, "Hoja1",0,0);

        driver.findElement(searchBoxLocator).sendKeys(searchtext);

        driver .findElement(searchBtnLocator).click();

        String resulttext = driver.findElement(resultTextLocator).getText();

        System.out.println("Resultado: " + resulttext);

        //readFile.readExcel(filepath,"Hoja2");

        writeFile.writeCellValue(filepath,"Hoja2",0,1,resulttext);

    }

    @Test
    public void test2() throws IOException
    {
        String filepath = "E:\\Cursos\\2020\\SIPECOM\\BBOTestNov2020\\herramientas\\Test.xlsx";

        String searchtext = readFile.getCellValue(filepath, "Hoja1",1,0);

        driver.findElement(searchBoxLocator).sendKeys(searchtext);

        driver .findElement(searchBtnLocator).click();

        String resulttext = driver.findElement(resultTextLocator).getText();

        System.out.println("Resultado: " + resulttext);

        //readFile.readExcel(filepath,"Hoja2");

        writeFile.writeCellValue(filepath,"Hoja2",1,1,resulttext);

    }
}
