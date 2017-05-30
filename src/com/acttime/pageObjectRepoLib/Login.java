package com.acttime.pageObjectRepoLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.genericLib.Constants;
import com.actitime.genericLib.Driver;

public class Login {
	@FindBy(name="username")
	private WebElement userNameEdt;
	
	@FindBy(name="pwd")
	private WebElement paswordEdt;
	
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	
	public void loginToAPP(String username , String password){
		Driver.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver.driver.get(Constants.url);
		userNameEdt.sendKeys(username);
		paswordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
	
	
	
	
	
	
	

}
