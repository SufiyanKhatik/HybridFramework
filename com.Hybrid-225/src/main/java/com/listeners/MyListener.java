package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Base.BaseClass;
import com.Utils.DriverUtils;
import com.aventstack.extentreports.Status;

public class MyListener extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "TestCase Passed");

	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "TestCase Failed");
		try {
			String path = DriverUtils.getScreenshot(result.getName());
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
       test.log(Status.SKIP, "TestCase Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		reportInit();
	}

	public void onFinish(ITestContext context) {
		report.flush(); // to save extent report.
	}

}
