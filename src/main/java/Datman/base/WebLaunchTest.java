package Datman.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import Datman.TestUtils.ExtentReportNG;


public class WebLaunchTest extends ExtentReportNG {

    public static AppiumDriver driver;

    @BeforeSuite
    public void setUpReport() {
        extent = ExtentReportNG.generateReport();
        
    }
  
    @BeforeClass(alwaysRun = true)
    public void setUp() throws MalformedURLException, URISyntaxException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("automation_testing_device");
        options.setAutomationName("UiAutomator2");
        options.setPlatformVersion("15.0");
        options.setPlatformName("Android");
        options.setApp("/Users/rohit/Downloads/app-datman-release_ws1.apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);


        // This is for implicit wait that will be Applied globally to all element searches.
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  
    @AfterClass(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    public static String getScreenshotPath(String testcaseName) throws IOException {
        TakesScreenshot ts =  WebLaunchTest.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String relativePath = "screenshots/" + testcaseName + ".png";
        String destinationPath = System.getProperty("user.dir") + "/reports/" + relativePath;

        // Create screenshots directory if it doesn't exist
        File directory = new File(System.getProperty("user.dir") + "/reports/screenshots");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File destinationFile = new File(destinationPath);
        FileUtils.copyFile(source, destinationFile);
        return relativePath;
    }

}

