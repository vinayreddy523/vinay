package com.hix.tests.smokes;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hix.base.Assert;
import com.hix.base.BaseTestCase;
import com.hix.base.Browser;
import com.hix.base.BrowserFactory;
import com.hix.test.dataobjects.INDIVIDUAL;
import com.hix.test.framework.utils.CommonUtils;
import com.hix.test.framework.utils.CustomerType;
import com.hix.test.framework.utils.ExcelDataProvider;
import com.hix.testpages.ChooseAPlan;
import com.hix.testpages.DisplayHomePage;
import com.hix.testpages.GetQuote;
import com.hix.testpages.IndividualHomePage;
import com.hix.testpages.Register;
import com.hix.testpages.ShoppingCart;
import com.hix.testpages.TellUsAboutYourself;
import com.hix.testpages.WaitScreen;

/**
 * Showing a list of available plans and respective benefit designs to customers
 * in accordance with their eligibility determination.
 */
public class TestCasePPS1 extends BaseTestCase {

	public DisplayHomePage displayHomePage = new DisplayHomePage();
	public IndividualHomePage individualHomePage = new IndividualHomePage();
	public ShoppingCart shoppingCart = new ShoppingCart();
	public TellUsAboutYourself tellusaboutyourself = new TellUsAboutYourself();
	public Register register = new Register();
	public GetQuote getQuote = new GetQuote();
	public ChooseAPlan chooseAPlan = new ChooseAPlan();
	public WaitScreen waitScreen = new WaitScreen();
	public static ExcelDataProvider dataProvider = null;

	@Test(dataProvider = "getIndividualData")
	public void launchHomePage(INDIVIDUAL dataRow) throws Exception {
		// WebDriver browser = BrowserFactory.getBrowser();
		String url = CommonUtils.readFromConfig("BaseURL");
		Browser.go(url);
		Assert.assertEquals(Browser.getCurrentUrl().toLowerCase(),
				"http://67.216.186.254/hixweb/displayhomepage.action");

		Assert.assertTrue(displayHomePage
				.selectCustomerType(CustomerType.For_Individuals_and_Families),
				"Unable to Select Customer Type");

		// Selecting Get Started
		displayHomePage.getStarted("1");

		// Validating if the Individual Home Page is displayed successfully
		Assert.assertTrue(
				individualHomePage.validateIndividualHomePageisDisplayed(),
				"Unable to find the Tell us About Yourself.  Make sure if the Individual Home Page is loaded without any errors");

		// Proceed to Enrolment
		individualHomePage.proceedToEnrolment();

		Assert.assertTrue(tellusaboutyourself.checkLocationDetails(),
				"Failed to Validate Location Details in Tell Us About Yourself Screen...");
		// TO DO : Need to add more checks.

		String zipCode = dataRow.getZipCode().toString();
		String startDate = dataRow.getStartDate().toString();
		Boolean visionPlan = dataRow.isVisionPlan();
		Boolean dentalPlan = dataRow.isDentalPlan();

		// Setting the Zip Code
		try {
			tellusaboutyourself.setLocation(zipCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Setting the Coverage, Who will be covered and view Plans
		tellusaboutyourself.setCoverage(startDate, visionPlan, dentalPlan);

		String gender = dataRow.getGender();
		String dob = dataRow.getDateOfBirth();
		Boolean usesTobacco = dataRow.isUsesTobacco();

		// Selecting who will be covered
		tellusaboutyourself.setWhoWillBeCovered(gender, dob, usesTobacco);

		// View Plans for which you are eligible
		tellusaboutyourself.selectViewPlansForWhichYouAreEligible();
		// Validate Choose Plans Home Page and Proceed to Plan Selection
		Assert.assertTrue(chooseAPlan.validateChooseAPlanHomePage(),
				"Unable to validate Choose A Plan Page..");
		chooseAPlan.proceedToPlanSelection();

		Assert.assertTrue(waitScreen.verifyWaitScreenisDisplayed(),
				"Unable to verify Wait Screen Page...");

		getQuote.selectMedicaPlan();
		getQuote.viewShoppingCart();

		shoppingCart.doCheckout();

		String userName = dataRow.getUserName().toString();
		String password = dataRow.getPassword().toString();
		System.out.println("UserName : " + userName);
		register.setUserName(userName);
		register.setPassword(password);
		register.doLogin();

		System.out.println();
		// Browser.quit();

	}
}
