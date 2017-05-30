package com.acttime.pageObjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCustomerInfo {
	
	@FindBy(className="formsummarytext")
	private WebElement customerNameInfo;

	public WebElement getCustomerNameInfo() {
		return customerNameInfo;
	}
	

}
