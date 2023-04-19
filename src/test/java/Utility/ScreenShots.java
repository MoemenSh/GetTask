package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShots {

    public class takingScreenShoot {
        public static void takeScreenShoot(WebDriver driver , String screenShootName) throws IOException {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file,new File("test-output\\"+ screenShootName +".png"));
        }
    }
}
