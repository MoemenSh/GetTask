package Tests;

import Utility.ScreenShots;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.SignUp;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class BaseTest {
    public WebDriver driver;
    SignUp signUp;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        String browserName = "chrome";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();


        String url = "https://codenboxautomationlab.com/registration-form/";
        driver.navigate().to(url);
        signUp = new SignUp(driver);
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()){
            ScreenShots.takingScreenShoot.takeScreenShoot(driver, result.getName());
        }
        //   driver.close();
    }


}
