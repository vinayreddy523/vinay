package com.hix.testpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hix.base.Browser;
import com.hix.base.BrowserFactory;
import com.hix.base.TestConstants;
import com.hix.test.framework.utils.CustomerType;

public class DisplayHomePage {

	/**
	 * This method is used to select a customer.
	 * 
	 * @param customerType
	 */
	public boolean selectCustomerType(CustomerType customerType) {

		switch (customerType) {
		case For_Individuals_and_Families:
			Browser.click("xpath=.//*[@id='slide_nav']/li[1]/a");
			return true;
		case For_Small_Business:
			Browser.click("xpath=.//*[@id='slide_nav']/li[2]/a");
			return true;
		case For_Employees:
			Browser.click("xpath=.//*[@id='slide_nav']/li[3]/a");
			return true;
		case For_Brokers_and_Navigators:
			Browser.click("xpath=.//*[@id='slide_nav']/li[4]/a");
			return true;
		default:
			return false;
		}
	}

	/**
	 * Method to select Get Started
	 */
	public void getStarted(String divId) {
		Browser.click("xpath=.//*[@id='slideshow']/div["+divId+"]/div/a");

/*		switch (customerType) {
		case For_Individuals_and_Families:
			Browser.click("xpath=.//*[@id='slideshow']/div[1]/div/a");
		case For_Small_Business:
			Browser.click("xpath=.//*[@id='slideshow']/div[2]/div/a");
		case For_Employees:
			Browser.click("xpath=.//*[@id='slideshow']/div[3]/div/a");
		case For_Brokers_and_Navigators:
			Browser.click("xpath=.//*[@id='slideshow']/div[4]/div/a");
		}*/
	}

	public boolean findTellusaboutyourself() {
		return Browser
				.isDisplayed("xpath=.//*[@id='WhatToExpect']/div/div/div/div/div/div/div[2]");
	}

}
