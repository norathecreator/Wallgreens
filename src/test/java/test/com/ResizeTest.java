/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.io.File;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author cash point
 */
public class ResizeTest {
  private WebDriver driver;
     private String baseUrl;
     
    public ResizeTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl = "https://www.walgreens.com";
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
         driver.close();
    }
   
    
//    driver.manage().window().maximize();
//    driver.manage().window().getSize();
//    Dimension dm = new Dimension(450,630);
//    driver.manage().window().setSize(dm);

    
    @Test
    public void testResizePage() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Back'])[207]/following::strong[1]")).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.findElement(By.xpath("//a[@id='pf-dropdown-signin']/strong")).click();
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
    
    driver.findElement(By.id("user_name")).click();
    driver.findElement(By.id("user_name")).clear();
    driver.findElement(By.id("user_name")).sendKeys("nurgul.hahn@outlook.com");
    
    WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(30));  //30 sec
    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password")));
    
    driver.findElement(By.id("user_password")).click();
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("0607Asani");
    driver.findElement(By.id("submit_btn")).click();
   
    
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
    FileUtils.copyFile(scrFile, new File("./image.png"));
    Thread.sleep(10);
}
}
