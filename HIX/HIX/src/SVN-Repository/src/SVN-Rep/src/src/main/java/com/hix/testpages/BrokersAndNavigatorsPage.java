package com.hix.testpages;

import org.openqa.selenium.By;

import com.hix.base.Browser;

public class BrokersAndNavigatorsPage {

	/**
	 * Method to make sure if the Navigators and Brokers Paged loaded successfully
	 * 
	 * @return
	 */
	public boolean validateBrokersAndNavigatorsPageisDisplayed() {
		boolean result = false;

		if (Browser.isDisplayed("xpath=.//*[@id='DisplayNavigatorBrokerLandingPage']/div/div/div/div/div/div/div/div/div[5]/a/img")) {
			result = true;
		}

		return result;
	}

	/**
	 * Method to Click on Let's Go
	 * 
	 */
	public void proceedToLetsGo() {
		Browser.click("xpath=.//*[@id='DisplayNavigatorBrokerLandingPage']/div/div/div/div/div/div/div/div/div[5]/a/img");
	}
}
