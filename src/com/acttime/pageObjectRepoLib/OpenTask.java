
package com.acttime.pageObjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.genericLib.WebDriverCommonLib;


public class OpenTask extends WebDriverCommonLib{
	
	@FindBy(linkText="Projects & Customers")
	private WebElement projectAndCustomerLnk;
	
	
	public void navigateToProjectAndCustomnerPage(){
		waitForLinkTextPresent("Projects & Customers");
		projectAndCustomerLnk.click();
	}
	
	
	
	
	
	
	
	
	

}
