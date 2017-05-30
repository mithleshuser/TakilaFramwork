package com.actitime.genericLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	
	public void waitForXpathPresent(String wbXpath){
		WebDriverWait wait = new WebDriverWait(Driver.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated
				      (By.xpath(wbXpath)));
	
	}
	
	public void waitForLinkTextPresent(String linkName){
		WebDriverWait wait = new WebDriverWait(Driver.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated
				      (By.linkText(linkName)));
	
	}
	
	public void select(WebElement sWb , String value){
		Select sel = new Select(sWb);
		sel.selectByVisibleText(value);
	}
	
	public void select(WebElement sWb , int index){
		Select sel = new Select(sWb);
		sel.selectByIndex(index);
	}
	
	
	public boolean verifyText(WebElement wb , String expectedVal){
		boolean flag = false;
		String actVal = wb.getText();
		if(actVal.equals(expectedVal)){
			flag = true;
			System.out.println(expectedVal + "is verfied==PASS");
		}else{
			System.out.println(expectedVal + "is not verfied==FAIL");

		}
		return flag;
	}
	
	
	
	
	

}
