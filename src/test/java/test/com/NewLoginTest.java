/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author cash point
 */
public class NewLoginTest {
      WebDriver driver;
    public NewLoginTest() {
          this.driver = driver;
    }

    @FindBy(xpath = ".//*[@name='name']")
    private WebElement username;

    @FindBy(xpath = ".//*[@name='password']")
    private WebElement password;

    @FindBy(xpath = ".//*[@name='submit']")
    private WebElement submit_btn;
    
public void loginToWalgreens(String uName, String pWord)
            throws Exception {
        try {
            driver.get("https://www.walgreens.com/");
            username.sendKeys(uName);
            password.sendKeys(pWord);
            submit_btn.click();
            //   LoginPage login = new LoginPage(driver);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
