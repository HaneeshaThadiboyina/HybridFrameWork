package TestNG_Listeners;

import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter SparkReporter;
	public ExtentReports Reports;
	public ExtentTest Test;
	
	  public void onStart(ITestContext context)
	  {
		  SparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReports.html");
		  SparkReporter.config().setDocumentTitle("Automation Report");//title of the report
		  SparkReporter.config().setReportName("Functional Testing");// name of the report
		  SparkReporter.config().setTheme(Theme.DARK);
		  
		  Reports = new ExtentReports();
		  Reports.attachReporter(SparkReporter);
		  
		  Reports.setSystemInfo("Computer name", "Local Host");
		  Reports.setSystemInfo("Environment", "QA");
		  Reports.setSystemInfo("Tester Name", "Haneesha");
		  Reports.setSystemInfo("OS", "Windows10");
		  Reports.setSystemInfo("Browser Name", "Chrome");
		  
	  }
	  
	  public void onTestSuccess(ITestResult result)
	  {
		  Test = Reports.createTest(result.getName());
		  Test.log(Status.PASS, "Test case Passed is:" +result.getName());
	  }
	  
	  public void onTestFailure(ITestResult result)
	  {
		  Test = Reports.createTest(result.getName());
		  Test.log(Status.FAIL, "Test case Failed is:" +result.getName());
		  Test.log(Status.FAIL, "Test case Failed caused is:" +result.getThrowable());
	  }
	  
	  public void onTestSkipped(ITestResult result)
	  {
		  Test = Reports.createTest(result.getName());
		  Test.log(Status.SKIP, "Test case Skipped is:" +result.getName());
	  }
	  
	  public void onFinish(ITestContext context)
	  {
		  Reports.flush();
	  }

}
