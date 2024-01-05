package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	public static ExtentReports generateReports() {
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("ExtentReports.html");
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo( "version", "1.10");
		reports.setSystemInfo("Created By","priti");
		reports.setSystemInfo("Testing type","regression");
	return reports;

}
}
   