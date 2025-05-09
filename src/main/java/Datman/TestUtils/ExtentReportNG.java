package Datman.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;

public class ExtentReportNG extends Listeners {
    public static ExtentReports extent;

    public static ExtentReports generateReport() {
        String reportDir = System.getProperty("user.dir") + "/reports";
        String path = reportDir + "/index.html";
        System.out.println("Generating report at: " + path);

        File directory = new File(reportDir);
        if (!directory.exists()) {
            System.out.println("Creating reports directory: " + reportDir);
            directory.mkdirs();
        }

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("Web Automation");
        reporter.config().setReportName("Web Automation Testing");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Rohit");
        System.out.println("ExtentReports initialized successfully");
        return extent;
    }
    
}
