package capa2;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;

public class clase2 {

    public static void main(String[] args)
    {

        try {

            //System.setProperty("webdriver.gecko.driver", "E://Selenium//Selenium_Jars//geckodriver.exe");
            System.setProperty("webdriver.chrome.driver", "E://Cursos//2020//SIPECOM//BBOTestNov2020//herramientas//chromedriver.exe");

            WebDriver driver  = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://www.openfactapp.com");
            driver.findElement(By.id("LoginUser_UserName")).sendKeys("demo");
            driver.findElement(By.id("LoginUser_Password")).sendKeys("0430");

            Thread.sleep(5000);

            driver.findElement(By.id("LoginUser_LoginButton")).click();
            System.out.println(driver.getTitle());

            //http://18.218.178.167/OpenFact/FastFactEmisor/DocumentosEmitidos.aspx

            driver.get("http://18.218.178.167/OpenFact/FastFactEmisor/DocumentosEmitidos.aspx");

            //Fichero Temporal
             File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            System.out.println(f.getAbsolutePath());

            FileOutputStream fileOutput = new FileOutputStream("E://Cursos//2020//SIPECOM//BBOTestNov2020//Selenium//captures//"
            + System.currentTimeMillis() + ".png");

            BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);

            bufferedOutput.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));

            bufferedOutput.close();

            Thread.sleep(5000);
            driver.close();

        } catch (InterruptedException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
