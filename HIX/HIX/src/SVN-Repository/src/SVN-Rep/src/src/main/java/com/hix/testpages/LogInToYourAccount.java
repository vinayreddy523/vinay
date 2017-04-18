/*package com.hix.testpages;

public class LogInToYourAccount {

}
*/

package com.hix.testpages;

import com.hix.base.Browser;

public class LogInToYourAccount {

	public void UserName(String userName) throws Exception {
		Browser.sendKeys("xpath=.//*[@id='landingPage_userId']", userName);
	}

	public void Password(String password) throws Exception {
		Browser.sendKeys("xpath=.//*[@id='landingPage_password']", password);
	}

	public void Login() {
		Browser.click("xpath=.//*[@id='landingPage_LoginFromLandingPage']");
	
		
	}
}
