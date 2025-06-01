//package utilities;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//public class ExtentReportUtilities  implements ITestListener {
//	public ExtentSparkReporter sparkreporter; 
////	UI of the report
//	public ExtentReports extentreports;   
////	responsible to populate common info on the report (browser, enviroment, tester name)
//	  public ExtentTest extenttest;
////	populating , updating and adding screen shot into report
//	
//	 public void onStart(ITestContext context) {
//		 sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/Reports/MyReport.html");
//		 sparkreporter.config().setDocumentTitle("Automation Report");
//		 sparkreporter.config().setReportName("Sanity Testing");
//		 sparkreporter.config().setTheme(Theme.DARK);
//		 
//		 extentreports = new ExtentReports();
//		 extentreports.attachReporter(sparkreporter);
//		 extentreports.setSystemInfo("browser", "chrome");
//		 extentreports.setSystemInfo("Application", "OpenCart");
//		 extentreports.setSystemInfo("os version", "windows 10");
//		 
//		  }
//	 
//	 public void onTestSuccess(ITestResult result) {
//		 extenttest = extentreports.createTest(result.getName());
//		 extenttest.log(Status.PASS, "Test Case Passed is :"+ result.getName());
//		  }
//	 
//	 public void onTestFailure(ITestResult result) {
//		 extenttest = extentreports.createTest(result.getName());
//		 extenttest.log(Status.FAIL, "Test Case Failed is :"+ result.getName());
//		 extenttest.log(Status.FAIL, "Test Case Failed because of :"+result.getThrowable());
//		  }
//	 
//	 public void onTestSkipped(ITestResult result) {
//		 extenttest = extentreports.createTest(result.getName());
//		 extenttest.log(Status.SKIP, "Test Case Skip is :"+ result.getName());
//		  }
//	 public void onFinish(ITestContext context) {
//		 extentreports.flush();
//			  }
//
//}
