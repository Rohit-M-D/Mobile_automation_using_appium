package Datman.TestUtils;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import Datman.base.WebLaunchTest;

public class Listeners implements ITestListener { 
    ExtentReports extent = ExtentReportNG.generateReport(); 
    public static ExtentTest test;

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }
    
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
        captureScreenshot( result,"Success");
    }

    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, result.getMethod().getMethodName());
        test.fail(result.getThrowable());
        captureScreenshot( result,"Failure");
    }

    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        System.out.println("Starting Test Suite: " + context.getName());
    }

    public void onFinish(ITestContext context) { 
        System.out.println("Finished Test Suite: " + context.getName());
        if (extent != null) {
            extent.flush(); 
        } else {
            System.out.println("ExtentReports is null in onFinish!");
        }
        
    }

    protected String captureScreenshot(ITestResult result, String status) {
        try {
            if (WebLaunchTest.driver != null) {
                String screenshotPath = WebLaunchTest.getScreenshotPath(result.getMethod().getMethodName());
                test.addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
                System.out.println("Screenshot captured: " + screenshotPath);
                return screenshotPath;
            } else {
                System.out.println("Driver is null, unable to capture screenshot.");
            }
        } catch (Exception e) {
            System.out.println("An unexpected exception occurred while capturing the screenshot.");
            e.printStackTrace();
        }
        return null;
    }

    public static void logScreenshot(Status status, String label) {
    try {
        String screenshotPath = WebLaunchTest.getScreenshotPath(label);  
        test.log(status, label, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    } catch (IOException e) {
        System.out.println("Failed to log screenshot");
        e.printStackTrace();
    }
}



    
        
    
    
    
}
