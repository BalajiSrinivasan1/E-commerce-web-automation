package com.opencart.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	private int retrycount=0;
	private int limit=3;
    public boolean retry(ITestResult result) {
	if(retrycount<limit) {
		retrycount++;
		return true;
	}
		return false;
	}

}
