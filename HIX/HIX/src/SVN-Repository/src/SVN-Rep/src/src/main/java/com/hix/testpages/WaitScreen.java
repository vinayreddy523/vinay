package com.hix.testpages;

import com.hix.base.Browser;

public class WaitScreen {

	/**
	 * Method to verify if the Wait Screen page is displayed
	 * 
	 * @return
	 */
	public boolean verifyWaitScreenisDisplayed() {
		return Browser
				.isElementPresent("xpath=html/body/div[2]/div/div/div/div/table/tbody/tr/td/div");
	}
	
}
