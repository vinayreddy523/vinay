package com.hix.test.framework.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.hix.base.Browser;

public class Screenshot extends TestListenerAdapter {

	
	@Override
	public void onTestFailure(ITestResult result) {
		File file = new File("");

		Reporter.setCurrentTestResult(result);
		System.out.println(file.getAbsolutePath());
		//Reporter.log(file.getAbsolutePath());
		//String imagepath = null;
		
		//imagepath= "/screenshots/"+ "TC_" + result.getName().toString() + "/"+ result.getName()+ ".jpg";

		//Reporter.log("screenshot saved at " + file.getAbsolutePath()
		//		+File.pathSeparator+"screenshots"+File.pathSeparator + result.getName() + ".jpg");
		// imagepath= "/screenshots/"+result.getName() + ".jpg";
		//String path=File.separator+"screenshots"+File.separator+ "TC_" + result.getName().toString() +File.separator+ result.getName();
		//String path=File.separator+"screenshots"+File.separator+ "TC_" + result.getName().toString() +File.separator+ result.getName();
		String path="/screenshots/TC_" + result.getName().toString()+"/" +result.getName();
		
		String imagepath= CommonUtils.currentDateFileName(path)+ ".jpg";
		
		Reporter.log("<a href=\".."+imagepath+"\""+">screenshot</a>");
		
		//Reporter.log("<a href=\".."+imagepath+"\""+">screenshot</a>");
		try {
			Browser.captureScreenShot(file.getAbsolutePath()+imagepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Reporter.log("Unable to take screenshot");
			e.printStackTrace();
		}
		Reporter.setCurrentTestResult(null);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// will be called after test will be skipped
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// will be called after test will pass
	}

}
