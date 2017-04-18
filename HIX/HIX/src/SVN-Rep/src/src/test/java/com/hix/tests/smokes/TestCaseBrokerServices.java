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
public class TestCaseBrokerServices extends BaseTestCase {
	private static WebDriver browser = BrowserFactory.getBrowser();
	public DisplayHomePage displayHomePage = new DisplayHomePage();
	public BrokersAndNavigatorsPage brokersandnavigators = new BrokersAndNavigatorsPage();
	public NavigatorInformation navigatorInformation =  new NavigatorInformation();
	public static ExcelDataProvider dataProvider = null;

	@BeforeSuite
	@DataProvider(name = "BrokersData")
	public Object[][] myExcelsheetReader() throws Exception {
		Object[][] data = null;
		Brokers dataRow = new Brokers();
		dataProvider = new ExcelDataProvider("src/test/resources/testdata/Brokers.xls");
		try {
			data = dataProvider.getExcelRows(dataRow, "2");
		} catch (Exception e) {
			throw new RuntimeException(
					"Error reading Excel rows. Root cause: ", e);
		}
		return data;
	}

	/**
	 * [HomePage]:HIX BR1.1 Open URL:
	 * http://67.216.186.254/HIXWeb/DisplayHomePage.action
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test()
	public void launchHomePage() throws FileNotFoundException, IOException {
		String url = CommonUtils.readFromConfig("BaseURL");
		browser.get(url);
		Assert.assertEquals(browser.getCurrentUrl().toLowerCase(),
				"http://67.216.186.254/hixweb/displayhomepage.action");
	}

	/**
	 * [N/B]Landing: BR1.2 Select "for brokers and navigators" click "get started"

	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(dependsOnMethods = "launchHomePage")
	public void selectCustomerTypeAndGetStarted() throws InterruptedException,
			IOException {
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
	}
	

	/**
	 * Verifying Details in the Navigator/Broker Information
	 */
	@Test(dependsOnMethods = "selectCustomerTypeAndGetStarted")
	public void checkBrokerDetails() {
		Assert.assertTrue(navigatorInformation.checkBrokerDetails(),
				"Failed to Validate Broker Validate Information...");
	}
	
	@Test(dependsOnMethods = "checkBrokerDetails", dataProvider = "BrokersData")
	public void enterBrokerInfomation(Brokers dataRow) throws Exception {
		String fname = dataRow.getFirstName().toString();
		String lname = dataRow.getLastName().toString();
		String idNum = dataRow.getIdNumber().toString();
		String broker = dataRow.getNavigatorOrBroker().toString();
		
		String acutualId =idNum.substring(idNum.indexOf("id_")+3);

		navigatorInformation.setFirstName(fname);
		navigatorInformation.setLastName(lname);
		navigatorInformation.setIdNumber(acutualId);
		navigatorInformation.setBroker(broker);
	}
	
	@Test(dependsOnMethods= "enterBrokerInfomation")
	public void submitTheFormAndValidate() throws Exception{
		navigatorInformation.clickOnNextButton();
		//Assert.assertTrue(navigatorInformation.validateInformatedEnteredNotMatch(),"Unable to find the does not match warning message.");
	}
	
	@Test(dependsOnMethods= "submitTheFormAndValidate")
	public void brokerConformationValidation() throws Exception{
		navigatorInformation.clickOnConformBrokerInformation();
	}
	
	@AfterSuite
	public void tearDown(){
		//browser.close();
		//browser.quit();
	}
	
	/*@Test (dependsOnMethods="brokerConformationValidation",dataProvider="BrokersData")
	public void fillUsernamePassword(Brokers dataRow) throws Exception {
		String userName = dataRow.getUserName().toString();
		String password = dataRow.getPassword().toString();
		System.out.println("Username::"+userName);
		System.out.println("pwd::"+password);
		navigatorInformation.FillUsernamePassword(userName, password);
	
			navigatorInformation.setSecurityQuestion("'DisplayAccountInformation']/div[1]/div/div/div[1]/div[2]/div/div[3]/table/tbody/tr[1]/td/a/span[1]", "2238");
			
			
	@Test (dependsOnMethods="fillUsernamePassword",dataProvider="BrokersData")	
	public void SecurityAnswer(Brokers dataRow) throws Exception {
		String securityAnswe1 = dataRow.getSecurityAnswe1().toString();
		String securityAnswe2 = dataRow.getSecurityAnswe2().toString();
		//String securityAnswe3 = dataRow.getSecurityAnswe3().toString();
		System.out.println("SecurityAnswe1::"+securityAnswe1);
		System.out.println("SecurityAnswe2::"+securityAnswe2);
		//System.out.println("SecurityAnswe3::"+securityAnswe3);
		navigatorInformation.SecurityAnswer(securityAnswe1, securityAnswe2);
		
	}*/
	
	
	@Test (dependsOnMethods="brokerConformationValidation",dataProvider="BrokersData")
	public void fillUsernamePassword(Brokers dataRow) throws Exception {
		String userName = dataRow.getUserName().toString();
		String password = dataRow.getPassword().toString();
		System.out.println("Username::"+userName);
		System.out.println("pwd::"+password);
		navigatorInformation.FillUsernamePassword(userName, password);
		navigatorInformation.setSecurityQuestion("2240");
	

}	
	
	@Test (dependsOnMethods="fillUsernamePassword",dataProvider="BrokersData")	
	public void SecurityAnswer(Brokers dataRow) throws Exception {
		navigatorInformation.setSecurityQuestion("2240");
		String securityAnswe1 = dataRow.getSecurityAnswer1().toString();
		
		System.out.println("SecurityAnswe1::"+securityAnswe1);
		
		//navigatorInformation.setSecurityQuestion1("2239");
		String securityAnswe2 = dataRow.getSecurityAnswer2().toString();
		System.out.println("SecurityAnswe2::"+securityAnswe2);
		
		//navigatorInformation.setSecurityQuestion("2241");
		String securityAnswe3 = dataRow.getSecurityAnswer3().toString();
		System.out.println("SecurityAnswe3::"+securityAnswe3);
		navigatorInformation.SecurityAnswer(securityAnswe1, securityAnswe2,securityAnswe3 );
		
	}
	
	@Test (dependsOnMethods="SecurityAnswer",dataProvider="BrokersData")	
	public void SecurityAnswer1(Brokers dataRow) throws Exception {
		navigatorInformation.setSecurityQuestion("2240");
	}
/*	@Test(dependsOnMethods= "SecurityAnswer")
	public void UserAcceptanceAgrement() throws Exception{
		navigatorInformation.clickOnUserAcceptanceAgrement();
	}
		//String securityQuestion1 = dataRow.getSecurityQuestion1().toString();
		//String securityQuestion2 = dataRow.getSecurityQuestion2().toString();
		//String securityQuestion3 = dataRow.getSecurityQuestion3().toString();
		
			//navigatorInformation.setSecurityQuestion("xpath=.//*[@id='DisplayAccountInformation']/div[1]/div/div/div[1]/div[2]/div/div[3]/table/tbody/tr[1]/td/a/span[1]", "2239");
	/*	navigatorInformation.setFirstName(userName);
		navigatorInformation.setPassword(password);
		navigatorInformation.setsecurityQuestion1(securityQuestion1);
		navigatorInformation.setsecurityQuestion2(securityQuestion2);
		navigatorInformation.setsecurityQuestion3(securityQuestion3);
}*/


	
}
