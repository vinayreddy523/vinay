package com.hix.testpages;

import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.seleniumemulation.JavascriptLibrary;
import org.openqa.selenium.support.ui.Select;

import com.hix.base.Browser;
import com.hix.base.BrowserFactory;
import com.hix.test.framework.utils.CommonUtils;
import com.thoughtworks.selenium.Selenium;

public class NavigatorInformation {

	public boolean checkBrokerDetails() {

		boolean chkBkrInfo = false;

		if (Browser.isElementPresent("xpath=//*[@id='navigator.firstName']")
				&& Browser.isElementPresent("xpath=.//*[@id='navigator.lastName']")
				&& Browser
						.isElementPresent("xpath=.//*[@id='RepresentativeRegistrationAction_RepresentativeRegistrationSubmit']")
				&& Browser
						.isElementPresent("xpath=.//*[@id='RepresentativeRegistrationAction_DisplayNavigatorBrokerLandingPage']")) {
			chkBkrInfo = true;
		}
		return chkBkrInfo;
	}
	public void setFirstName(String string) throws Exception {
		Browser.sendKeys("xpath=.//*[@id='navigator.firstName']", string);
	}
	
	public void setLastName(String string) throws Exception {
		Browser.sendKeys("xpath=.//*[@id='navigator.lastName']", string);
	}
	
	public void setBroker(String broker) throws Exception{
		System.out.println("DATA::"+broker);
		Selenium selenium = new WebDriverBackedSelenium(Browser.getBrowser(), CommonUtils.readFromConfig("BaseURL"));
		selenium.mouseDown("css=div.greyBoxSectionWithoutBottomBorder td a");
		selenium.clickAt("css=ul li>a[rel='"+broker.toUpperCase()+"']", "0,0");
		selenium = null;
	}
	
	public void setIdNumber(String string) throws Exception {
		Browser.sendKeys("xpath=.//*[@id='navigator.personalIdFromUI']", string);
	}
	
	public void clickOnNextButton() throws Exception {
		Browser.click("css=#RepresentativeRegistrationAction_RepresentativeRegistrationSubmit");
	}
	
	//public void clickOnNextButton() throws Exception {
		//Browser.click("css=.selectBox-label");
//	}
	public void clickOnConformBrokerInformation() throws Exception {
		Browser.click("css=#DisplayHouseHoldMemebers_AddPersonGrpHouseholdAssoc");
	}
	//public void clickPreviousPage() throws Exception {
	//	Browser.click("xpath=.//*[@id='RepresentativeRegistrationAction_DisplayNavigatorBrokerLandingPage']");
	//}

	public boolean validateInformatedEnteredNotMatch() {
		boolean result = false;

		if (Browser.isTextPresent("The information you entered does not match the ID for any Navigator or Broker. Please re-enter the Navigator or Broker ID")){
			result = true;
		}
		return result;
	}

	public void FillUsernamePassword( String userName, String password) throws Exception{
		
	      Browser.sendKeys("css=#DisplayAccountInformation_users_loginUserId", userName);
	      Browser.sendKeys("css=#DisplayAccountInformation_password", password);
	      Browser.sendKeys("css=#DisplayAccountInformation_reenterpassword", password);

}
	

	public void setSecurityQuestion(String dropdownItem) throws Exception{
				
				Selenium selenium = new WebDriverBackedSelenium(Browser.getBrowser(), CommonUtils.readFromConfig("BaseURL"));
				Thread.sleep(3000);
				selenium.mouseDown("xpath=.//*[@id='DisplayAccountInformation']/div[1]/div/div/div[1]/div[2]/div/div[3]/table/tbody/tr[1]/td/a/span[1]");
				//selenium.mouseDown("xpath=.//*[@id='DisplayAccountInformation']/div[1]/div/div/div[1]/div[2]/div/div[3]/table/tbody/tr[3]/td/a/span[1");
			//	selenium.mouseDown("xpath=.//*[@id='DisplayAccountInformation']/div[1]/div/div/div[1]/div[2]/div/div[3]/table/tbody/tr[7]/td/a/span[1]");
				Thread.sleep(3000);
				selenium.clickAt("css=ul li>a[rel='"+dropdownItem+"']", "0,0");
				selenium = null;
			}
	public void setSecurityQuestion1(String dropdownItem) throws Exception{
		
		Selenium selenium = new WebDriverBackedSelenium(Browser.getBrowser(), CommonUtils.readFromConfig("BaseURL"));
		Thread.sleep(3000);
		//selenium.mouseDown("xpath=.//*[@id='DisplayAccountInformation']/div[1]/div/div/div[1]/div[2]/div/div[3]/table/tbody/tr[1]/td/a/span[1]");
		selenium.mouseDown("xpath=.//*[@id='DisplayAccountInformation']/div[1]/div/div/div[1]/div[2]/div/div[3]/table/tbody/tr[4]/td/a/span[1");
	//	selenium.mouseDown("xpath=.//*[@id='DisplayAccountInformation']/div[1]/div/div/div[1]/div[2]/div/div[3]/table/tbody/tr[7]/td/a/span[1]");
		Thread.sleep(3000);
		selenium.clickAt("css=ul li>a[rel='"+dropdownItem+"']", "0,0");
		selenium = null;
	}
			
			
			public void SecurityAnswer( String securityAnswer1, String securityAnswer2, String securityAnswer3) throws Exception{
					
				      Browser.sendKeys("css=#DisplayAccountInformation_userSecQuesAssocList_0__secAnswer", securityAnswer1);
				      Browser.sendKeys("css=#DisplayAccountInformation_userSecQuesAssocList_1__secAnswer", securityAnswer2);
				      Browser.sendKeys("css=#DisplayAccountInformation_userSecQuesAssocList_2__secAnswer", securityAnswer3);


			}
			
			public void clickOnUserAcceptanceAgrement() throws Exception {
				Browser.click("xpath=.//*[@id='DisplayAccountInformation_agreement']");
			}

/*	public void setSecurityQuestion2(String securityQuestion2) throws Exception{
		System.out.println("DATA::"+securityQuestion2);
		Selenium selenium = new WebDriverBackedSelenium(Browser.getBrowser(), CommonUtils.readFromConfig("BaseURL"));
		
		// not change from here 
		selenium.mouseDown("css=div.greyBoxSectionWithoutBottomBorder td a");
		selenium.clickAt("css=ul li>a[rel='"+broker.toUpperCase()+"']", "0,0");
		selenium = null;
	}
	
	public void setSecurityQuestion3(String securityQuestion3) throws Exception{
		System.out.println("DATA::"+securityQuestion3);
		Selenium selenium = new WebDriverBackedSelenium(Browser.getBrowser(), CommonUtils.readFromConfig("BaseURL"));
		
		// not change from here 
		selenium.mouseDown("css=div.greyBoxSectionWithoutBottomBorder td a");
		selenium.clickAt("css=ul li>a[rel='"+broker.toUpperCase()+"']", "0,0");
		selenium = null;
	}
	*/

}