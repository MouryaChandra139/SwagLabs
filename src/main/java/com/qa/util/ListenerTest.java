package com.qa.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.base.BaseTest;

public class ListenerTest extends BaseTest implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			TestUtil.takeSnapShot(result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
