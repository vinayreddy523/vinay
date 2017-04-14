package com.hix.testpages;

import com.hix.base.Browser;

public class ShoppingCart {

	public void doCheckout(){
		Browser.click("xpath=.//*[@id='ProceedWithShoppingCart']");
	}
}
