package com.hix.testpages;

import com.hix.base.Browser;

public class TellUsAboutYourself {

	public boolean checkLocationDetails() {

		boolean chkLocObjects = false;
// Dint understand anything about this if statement. 
		if (Browser.isElementPresent("xpath=//*[@id='zipCode']")
				&& Browser.isElementPresent("xpath=.//*[@id='countyBorder']")
				&& Browser
						.isElementPresent("xpath=.//*[@id='GetStarted']/div/div/div/div/div[2]/div[2]/div[1]/div[1]/label")
				&& Browser
						.isElementPresent("xpath=.//*[@id='GetStarted']/div/div/div/div/div[2]/div[2]/div[1]/div[2]/label")) {
			chkLocObjects = true;
		}
		return chkLocObjects;
	}

	/**
	 * Method to Set the Zip Code
	 * 
	 * @param string
	 * @throws Exception
	 */
	//THis is where its started filling up the data in the required field.
	public void setLocation(String string) throws Exception {
		//why String string ??
		Browser.sendKeys("xpath=.//*[@id='zipCode']", string);
		Browser.click("xpath=.//*[@id='countyBorder']/a/span[1]");
	}

	public void setCoverage(String startDate, boolean dentalPlan,
			boolean visionPlan) {

		/*
		 * WebElement select = browser.findElement(By
		 * .xpath(".//*[@id='GetStarted_reqEffectiveDate']")); List<WebElement>
		 * options = select .findElements(By.tagName("04/01/2013")); for
		 * (WebElement option : options) { System.out.println("start date :" +
		 * startDate); System.out.println("Actual date:" + option.getText()); if
		 * (startDate.equals(option.getText())) option.click(); }
		 */

		if (visionPlan) {
			Browser.click("xpath=.//*[@id='productLineList-2']");
		}

		if (dentalPlan) {
			Browser.click("xpath=.//*[@id='productLineList-1']");
			//where did the start date selected. I dont see any click command for start date. ?
		}
	}

//	public void selectViewPlansForWhichYouAreEligible() {
//		Browser.click("xpath=.//*[@id='GetStarted']/div/div/div/div/div[2]/div[3]/ul/li[2]/img");
		//WHy its written random. This click should come at the bottom of the script. Right. ?
		
	//}

	/**
	 * @param gender
	 * @param dateOfBirth
	 * @param usesTobacco
	 */
	public void setWhoWillBeCovered(String gender, String dateOfBirth,
			boolean usesTobacco) {
		System.out.println("Gender :" + gender);
		if (gender.equalsIgnoreCase("male")) {
			Browser.click("xpath=.//*[@id='GetStarted_personSummaryList_0__gender_referenceDataId2096']");
		} else {
			Browser.click("xpath=.//*[@id='GetStarted_personSummaryList_0__gender_referenceDataId2097']");
		}

		try {
			Browser.sendKeys(
					"xpath=.//*[@id='GetStarted_personSummaryList_0__dob']",
					dateOfBirth);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (usesTobacco) {
			Browser.click("xpath=.//*[@id='GetStarted_personSummaryList_0__tobaccoUse_referenceDataId2253']");
		} else {
			Browser.click("xpath=.//*[@id='GetStarted_personSummaryList_0__tobaccoUse_referenceDataId2254']");
		}
		
		
	}
	public void selectViewPlansForWhichYouAreEligible() {
	Browser.click("xpath=.//*[@id='GetStarted']/div/div/div/div/div[2]/div[3]/ul/li[2]/img");
		//WHy its written random. This click should come at the bottom of the script. Right. ?
		
	}
}
