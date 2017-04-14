package com.hix.testpages;

import org.openqa.selenium.By;

import com.hix.base.Browser;

public class IndividualHomePage {

	/**
	 * Method to make sure if the Individual Home Page is launched successfully
	 * 
	 * @return
	 */
	public boolean validateIndividualHomePageisDisplayed() {
		boolean result = false;

		if (Browser.isDisplayed("xpath=.//*[@id='WhatToExpect']")) {
			result = true;
		}

		return result;
	}

	/**
	 * Method to Proceed to Enrolment
	 * 
	 */
	public void proceedToEnrolment() {
		Browser.click("xpath=.//*[@id='WhatToExpect']/div/div/div/div/div/div/div[1]/table/tbody/tr/td[3]/a");
	}
}
