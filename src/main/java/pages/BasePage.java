package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BasePage {
public static WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    SoftAssert softAssert = new SoftAssert();
    public WebElement action(By locator) {
        return driver.findElement(locator);
    }
    public void waitElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void setText(By locator, String data) {
        waitElement(locator);
        action(locator).isEnabled();
        action(locator).clear();
        action(locator).sendKeys(data);
    }
    public void click(By locator) {
        waitElement(locator);
        action(locator).click();
    }
    public boolean isDisplayed(By locator) {
        return action(locator).isDisplayed();
    }
    public String getTextFromElement(By locator) {
        waitElement(locator);
        String data = action(locator).getText();
        return data;
    }
    public String setXpathByDataID(String source) {
        String dataId = "//*[@data-axis-test-id='" + source + "']";
        return dataId;
    }

    public String setXpathByContentDesc(String source, String content) {
        String dataId = "//*[@class = '" + source + "' and contains(@content-desc,'" + content + "')]";
        return dataId;
    }

    public String setXpathByContentDescAndIndex(String source, String content, int number) {
        String dataId = "(//" + source + "[@content-desc=\"" + content + "\"])[" + number + "]";
        return dataId;
    }

    public String setXpathByTextEqual(String Class, String text) {
        String dataId = "//*[@class = '" + Class + "' and contains(@text(),'" + text + "')]";
        return dataId;
    }

    public String setXpathByIndex(String source, String index) {
        String dataId = "//" + source + "[@index='" + index + "']";
        return dataId;
    }
    public static String getCurrentDate() {
        return new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(new Date());
    }

    public String setXpathByTextContains(String source) {
        String dataId = "//*[contains(text(),'" + source + "')]";
        return dataId;
    }

    public void softAssertionEqual(By locator, String expected) {
        waitElement(locator);
        softAssert.assertEquals(getTextFromElement(locator), expected);
        softAssert.assertAll();
    }

    public void softAssertionContain(By locator, String expected) {
        waitElement(locator);
        softAssert.assertTrue(getTextFromElement(locator).contains(expected));
        softAssert.assertAll();
    }

    public void softAssertionByMethod(By locator, String methodType, String expected) {
        waitElement(locator);
        softAssert.assertEquals(methodType + (locator), expected);
        softAssert.assertAll();
    }
    public String setXpathByClassContains(String className){
        String data="//*[contains(@class,'"+className+"')]";
        return data;
    }
    public String setXpathByName(String Name){
        String data="//*[contains(@Name,'"+Name+"')]";
        return data;
    }
}
