package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	String reportsName;

	public void onStart(ITestContext context) {
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportsName="Test-Report"+timeStamp+".html";
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\"+reportsName);
		System.out.println(System.getProperty("user.dir")+"\\reports\\"+reportsName);
		sparkReporter.config().setDocumentTitle("API Test Execution Report");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extentReport= new ExtentReports();
		extentReport.attachReporter(sparkReporter);	
		extentReport.setSystemInfo("Applicaiton", "Pet Store User API");
		extentReport.setSystemInfo("OperatingSystem", System.getProperty("os.name"));
		extentReport.setSystemInfo("UserName", System.getProperty("user.name"));
		extentReport.setSystemInfo("Environment", "QA");
		extentReport.setSystemInfo("User", "Asif");
	}

	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

	public void onTestSkipped(ITestResult result) {
		extentTest= extentReport.createTest(result.getName());
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.createNode(result.getName());
		extentTest.log(Status.SKIP,"Test Skipped");
		extentTest.log(Status.SKIP,result.getThrowable().getMessage());
	}

	public void onTestSuccess(ITestResult result) {
		extentTest= extentReport.createTest(result.getName());
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.createNode(result.getName());
		extentTest.log(Status.PASS,"Test Pass");
	}

	public void onTestFailure(ITestResult result) {
		extentTest= extentReport.createTest(result.getName());
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.createNode(result.getName());
		extentTest.log(Status.FAIL,"Test Failed");
		extentTest.log(Status.FAIL,result.getThrowable().getMessage());
		
	}

}
