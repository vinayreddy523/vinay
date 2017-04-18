package com.hix.testpages;

import com.hix.base.Browser;

public class Register {

	public void setUserName(String userName) throws Exception {
		Browser.sendKeys("xpath=.//*[@id='userId']", userName);
	}

	public void setPassword(String password) throws Exception {
		Browser.sendKeys("xpath=.//*[@id='password']", password);
	}

	public void doLogin() {
		Browser.click("xpath=.//*[@id='CreateAccount_LoginFromLandingPage']");
	}
}
