package com.acttime.pageObjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCustomer {

	@FindBy(name="name")
	private WebElement customerNameEdt;
	
	
	@FindBy(xpath="//input[@value='Create Customer']")
	private WebElement createCustomerBtn;
	
	public void createCustomer(String customerName){
		customerNameEdt.sendKeys(customerName);
		createCustomerBtn.click();
	}
	
	
	
}
