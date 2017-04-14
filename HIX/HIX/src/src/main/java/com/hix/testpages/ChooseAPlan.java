package com.hix.testpages;

import com.hix.base.Browser;

public class ChooseAPlan {

	/**
	 * @return
	 */
	public boolean validateChooseAPlanHomePage() {
		boolean found = false;

		if (Browser.isDisplayed("xpath=.//*[@id='WhatToExpect']")) {
			found = true;
		}
		return found;
	}

	public void proceedToPlanSelection() {
		Browser.click("xpath=//*[@id='WhatToExpect']/div/div/div/div/div/div/div/table/tbody/tr/td[3]/a");
	}
	
	public void newfunction()
	{
		src.main.resources.browser_exe.chrome.Browser.sendKeys("id=q", "my name");
	}
	
}
