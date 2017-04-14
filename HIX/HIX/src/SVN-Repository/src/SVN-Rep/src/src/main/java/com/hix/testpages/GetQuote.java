package com.hix.testpages;

import com.hix.base.Browser;

public class GetQuote {

	public void selectMedicaPlan() {
		Browser.click("xpath=.//*[@id='DisplayExplorePlanOptions']/div[1]/div/div/div[1]/div[3]/div[4]/div/div[1]/div[2]/div[1]/div[1]/a");
	}

	public void confirmYourPurchase() {
		Browser.click("xpath=.//*[@id='DisplayExplorePlanOptions_ProceedFromExplorePlans']");
		//If this is not in order is that ok..?
		
	}
	
	public void viewShoppingCart(){
		Browser.click("xpath=.//*[@id='DisplayExplorePlanOptions']/div[1]/div/div/div[1]/div[1]/a[2]");
	}
}
