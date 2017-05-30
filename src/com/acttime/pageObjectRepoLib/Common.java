package com.acttime.pageObjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Common {
	
	@FindBy(linkText="Logout")
	private WebElement logOutLnk;
	
	
	public void logOut(){
		logOutLnk.click();
	}

}
