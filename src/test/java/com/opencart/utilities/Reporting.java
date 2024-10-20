package com.opencart.utilities;

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

public class Reporting implements ITestListener{
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	 public void onStart(ITestContext context) {
		 String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 String repName = "Test_Report_"+timeStamp+".html";
		   sparkreporter=new ExtentSparkReporter("./reports/"+repName);
//		   try {
//			sparkreporter.loadXMLConfig("./report-config.xml");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		   sparkreporter.config().setDocumentTitle("opencart Automation Report"); // Title of report
			sparkreporter.config().setReportName("opencart Functional Testing"); // name of the report
			sparkreporter.config().setTheme(Theme.DARK);
		   sparkreporter.config().setTimeStampFormat(timeStamp);
		  // sparkreporter.config().setCss(".test {text-align: left; } body {background-color: #f0f0f0; }");
		
		 	   
		   extent=new ExtentReports();
		   extent.attachReporter(sparkreporter);
		   
		   
		   extent.setSystemInfo("Application", "opencart");
			extent.setSystemInfo("Module", "Admin");
			extent.setSystemInfo("Sub Module", "Customers");
			extent.setSystemInfo("Operating System", System.getProperty("os.name"));
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			extent.setSystemInfo("browser name", "chrome");
			extent.setSystemInfo("Environemnt","QA");
			extent.setSystemInfo("user","kween");
		  }
	 public void onTestSuccess(ITestResult result) {
		 test=extent.createTest(result.getName());
		 test.log(Status.PASS, "Test case is Passed is:"+result.getName());
		  }
	 public void onTestFailure(ITestResult result) {
		 System.out.println("test faild "+result.getName());
		  test=extent.createTest(result.getName());
			 test.log(Status.FAIL, "Test case is failed is:"+result.getName());
			 test.log(Status.FAIL, "Test case is faild cause is:"+result.getThrowable());
		
			 try
				{
				String screenshotPath=System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
				test.addScreenCaptureFromPath(screenshotPath);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
	  }
	 
	 public void onTestSkipped(ITestResult result) {
		   
		   test=extent.createTest(result.getName()); //test=extent.createTest(result.getTestContext().getName());
			test.createNode(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP, "Test case Skipped");
			test.log(Status.SKIP, result.getThrowable().getMessage());
		   
		   
		  }

	 
	public void onFinish(ITestContext context) {
		   
		 extent.flush();
		  }
	 
	 
//		 public  void onTestStart(ITestResult result) {
//		 
//		  
//			  
//		  }
//		 
//		  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		    // not implemented
//			  System.out.println("test fill sucess percentagre");
//		  }
//
//		  public void onTestFailedWithTimeout(ITestResult result) {
//			  System.out.println("timout");
//		  }

}	 
		
		 
		  



