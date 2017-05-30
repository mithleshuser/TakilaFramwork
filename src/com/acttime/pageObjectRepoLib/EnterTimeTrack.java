package com.acttime.pageObjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.genericLib.WebDriverCommonLib;

public class EnterTimeTrack extends WebDriverCommonLib{
	
	@FindBy(xpath="//div[text()='Tasks']")
	private WebElement taskImg;
	
	
	public void navigateToTaskPage(){
		waitForXpathPresent("//div[text()='Tasks']");
		taskImg.click();		
	}
	
	
	
	
	
	
	
	
	
	

}
