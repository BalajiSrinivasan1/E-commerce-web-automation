package com.amazon.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
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
		   sparkreporter.config().setDocumentTitle("Automation testing");
		   sparkreporter.config().setReportName("functional Testing");
		   sparkreporter.config().setTheme(Theme.DARK);
		   sparkreporter.config().setTimeStampFormat(timeStamp);
		  // sparkreporter.config().setCss(".test {text-align: left; } body {background-color: #f0f0f0; }");
		
		 	   
		   extent=new ExtentReports();
		   extent.attachReporter(sparkreporter);
		   
		   extent.setSystemInfo("Computer name", "local host");
		   extent.setSystemInfo("environment", "QA");
		   extent.setSystemInfo("Tester name", "balaji");
		   extent.setSystemInfo("os", "win 10");
		   extent.setSystemInfo("browser name", "chrome");
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
			 String path=System.getProperty("user.dir")+"\\Screenshort\\"+result.getName()+".png";
			 test.addScreenCaptureFromPath(path);
	  }
	 
	 public void onTestSkipped(ITestResult result) {
		 System.out.println("test skipped");
		 test=extent.createTest(result.getName());
		   test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
		   
		   
		  }

	 
	public void onFinish(ITestContext context) {
		    // not implemented
		System.out.println("finesh");
		 extent.flush();
		  }
	 
	 
		 public  void onTestStart(ITestResult result) {
		 
		  
			  
		  }
		 
		  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
			  System.out.println("test fill sucess percentagre");
		  }

		  public void onTestFailedWithTimeout(ITestResult result) {
			  System.out.println("timout");
		  }

		 
		 

		 
		  


}
