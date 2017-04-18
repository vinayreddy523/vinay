package com.hix.tests.smokes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hix.base.Assert;
import com.hix.base.BaseTestCase;
import com.hix.base.BrowserFactory;
import com.hix.test.dataobjects.Brokers;
import com.hix.test.framework.utils.CommonUtils;
import com.hix.test.framework.utils.CustomerType;
import com.hix.test.framework.utils.ExcelDataProvider;
import com.hix.testpages.BrokersAndNavigatorsPage;
import com.hix.testpages.DisplayHomePage;
import com.hix.testpages.NavigatorInformation;

/**
 * Showing a list of available plans and respective benefit designs to customers
 * in accordance with their eligibility determination.
 */
public class TC_Brokers_All_Rows extends BaseTestCase {
	private static WebDriver browser = BrowserFactory.getBrowser();
	public DisplayHomePage displayHomePage = new DisplayHomePage();
	public BrokersAndNavigatorsPage brokersandnavigators = new BrokersAndNavigatorsPage();
	public NavigatorInformation navigatorInformation =  new NavigatorInformation();
	public static ExcelDataProvider dataProvider = null;

	@BeforeSuite
	@DataProvider(name = "BrokersData",parallel=false)
	public Object[][] myExcelsheetReader() throws Exception {
		Object[][] data = null;
		Brokers dataRow = new Brokers();
		dataProvider = new ExcelDataProvider("src/test/resources/testdata/Brokers.xls");
		try {
			data = dataProvider.getAllExcelRows(dataRow);
		} catch (Exception e) {
			throw new RuntimeException(
					"Error reading Excel rows. Root cause: ", e);
		}
		return data;
	}

	/**
	 * [HomePage]:HIX BR1.1 Open URL:
	 * http://67.216.186.254/HIXWeb/DisplayHomePage.action
	 * @throws Exception 
	 */
	@Test(dataProvider = "BrokersData")
	public void launchHomePage(Brokers dataRow) throws Exception {
		String url = CommonUtils.readFromConfig("BaseURL");
		browser.get(url);
		Assert.assertEquals(browser.getCurrentUrl().toLowerCase(),
				"http://67.216.186.254/hixweb/displayhomepage.action");
		
		Assert.assertTrue(displayHomePage
				.selectCustomerType(CustomerType.For_Brokers_and_Navigators),
				"Unable to Select Customer Type");

		// Selecting Get Started  
		displayHomePage.getStarted("4");

		// Validating if the Individual Home Page is displayed successfully
		Assert.assertTrue(
				brokersandnavigators.validateBrokersAndNavigatorsPageisDisplayed(),
				"Unable to find the Tell us About Yourself.  Make sure if the Individual Home Page is loaded without any errors");

		// Proceed to Lets Go
		brokersandnavigators.proceedToLetsGo();

		Assert.assertTrue(navigatorInformation.checkBrokerDetails(),
				"Failed to Validate Broker Validate Information...");

		String fname = dataRow.getFirstName().toString();
		String lname = dataRow.getLastName().toString();
		String idNum = dataRow.getIdNumber().toString();
		String broker = dataRow.getNavigatorOrBroker().toString();
		
		String acutualId =idNum.substring(idNum.indexOf("id_")+3);

		navigatorInformation.setFirstName(fname);
		navigatorInformation.setLastName(lname);
		navigatorInformation.setIdNumber(acutualId);
		navigatorInformation.setBroker(broker);
		navigatorInformation.clickOnNextButton();
		navigatorInformation.clickOnConformBrokerInformation();
	}
	
	@AfterSuite
	public void tearDown(){
		browser.close();
		browser.quit();
	}
	
	//@Test (dependsOnMethods="brokerConformationValidation")
	//public void clickOnPreviousButton() throws Exception {
		//navigatorInformation.clickPreviousPage();
	//	Assert.assertTrue(brokersandnavigators.validateBrokersAndNavigatorsPageisDisplayed(),"Unable to find the Tell us About Yourself.  Make sure if the Individual Home Page is loaded without any errors");
	//}
}