package com.acttime.pageObjectRepoLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.genericLib.Driver;
import com.actitime.genericLib.WebDriverCommonLib;

public class AtiveProjectAndCust extends WebDriverCommonLib{

	@FindBy(xpath="//input[@value='Create New Customer']")
	private WebElement createCustomerBtn;
	
	@FindBy(xpath="//input[@value='Create New Project']")
	private WebElement createprojectBtn;
	
	@FindBy(name="selectedCustomer")
	private WebElement selectCustLst;
	
	@FindBy(xpath="//input[contains(@value,'Show')]")
	private WebElement showBtn;
	
	
	public void nvigateToCustMerDeatilsPage(String customerNAme){
		select(selectCustLst, customerNAme);
		showBtn.click();
		Driver.driver.findElement(By.linkText(customerNAme)).click();
	}
	
	
	public void navigateToCustomerPage(){
		createCustomerBtn.click();
	}
	
	public void navigateToProjectPage(){
		createprojectBtn.click();
	}
	
	
}
